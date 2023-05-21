package com.felix.background.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.felix.background.dto.common.ResponseData;
import com.felix.background.dto.out.UserOutputDto;
import com.felix.background.entity.TbUser;
import com.felix.background.entity.User;
import com.felix.background.mapper.UserMapper;
import com.felix.background.service.UserService;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Felix
 * @since 2023-05-14
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:9527")
public class UserController {


    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @SaCheckLogin
    @PostMapping(value = "/list")
    ResponseData<List<UserOutputDto>> query(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Integer department, String username, String name, String mobile) {
        ResponseData<List<UserOutputDto>> responseData = new ResponseData<>();
        QueryWrapper queryWrapper = QueryWrapper.create();
        queryWrapper.where(StringUtils.isNoneBlank(username) ? TbUser.USER.USERNAME.eq(username) : null)
                .and(StringUtils.isNoneBlank(name) ? TbUser.USER.NAME.like(name) : null)
                .and(StringUtils.isNoneBlank(String.valueOf(department)) ? TbUser.USER.DEPARTMENT.eq(department) : null)
                .and(StringUtils.isNoneBlank(mobile) ? TbUser.USER.MOBILE.like(mobile) : null);

        Page<User> page = userMapper.paginate(pageIndex, pageSize, queryWrapper);
        List<User> records = page.getRecords();
        List<UserOutputDto> userOutDtoList = records.stream()
                .map(user -> modelMapper.map(user, UserOutputDto.class))
                .collect(Collectors.toList());
        responseData.setData(userOutDtoList);
        responseData.setCode(ResponseData.SUCCESS_CODE);
        responseData.setMessage("查询成功");
        responseData.setTotal(page.getTotalRow());
        return responseData;
    }

    @PostMapping(value = "/login")
    ResponseData<UserOutputDto> login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        QueryWrapper queryWrapper = QueryWrapper.create();
        if (StringUtils.isBlank(user.getUsername())) {
            return ResponseData.failure("用户名不能为空");
        }
        if (StringUtils.isBlank(user.getPassword())) {
            return ResponseData.failure("密码不能为空");
        }
        queryWrapper
                .where(TbUser.USER.USERNAME.eq(user.getUsername()))
                .and(TbUser.USER.PASSWORD.eq(user.getPassword()))
                .and(TbUser.USER.IS_DELETE.eq(0));
        User user1 = userMapper.selectOneByQuery(queryWrapper);
        if (null == user1) {
            return ResponseData.failure("用户名或密码错误");
        } else {
            UserOutputDto outputDto = modelMapper.map(user1, UserOutputDto.class);
            StpUtil.login(outputDto.getId());
            ResponseData responseData = new ResponseData();
            responseData.setMessage("登陆成功");
            responseData.setCode(ResponseData.SUCCESS_CODE);
            Map<String, Object> map = new HashMap<>();
            map.put("token", StpUtil.getTokenValue());
            responseData.setData(map);
            return responseData;
        }
    }

    //    @SaCheckLogin
    @GetMapping(value = "/logout")
    public ResponseData logout() {
        StpUtil.logout(StpUtil.getLoginId());                    // 将指定账号踢下线
        if (StpUtil.isLogin()) {
            return ResponseData.success("退出登陆成功", StpUtil.getLoginId());
        }
        return ResponseData.failure("退出登陆失败");
    }

    @GetMapping(value = "/isLogin")
    public ResponseData isLogin() {
        boolean login = StpUtil.isLogin();
        if (login) {
            return ResponseData.success("用户已登陆", StpUtil.getLoginId());
        }
        return ResponseData.failure("用户未登陆");
    }

    @SaCheckLogin
    @GetMapping(value = "/info")
    public ResponseData info() {
        boolean login = StpUtil.isLogin();
        if (login) {
            User user = userMapper.selectOneById(StpUtil.getLoginIdAsInt());
            return ResponseData.success("查询成功", modelMapper.map(user, UserOutputDto.class));
        }
        return ResponseData.failure("查询失败");
    }


    @SaCheckLogin
    @GetMapping(value = "/getUserInfo")
    public ResponseData userInfo(@RequestParam Integer id) {
        return ResponseData.success(modelMapper.map(userMapper.selectOneById(id), UserOutputDto.class));
    }

    @SaCheckLogin
    @GetMapping(value = "/transaction")
    public ResponseData transactionList() {
        Map<String, Object> map = new HashMap<>();
        map.put("total", 20);
        map.put("items", 20);
        map.put("order_no", "156484646511");
        map.put("timestamp", new Date());
        map.put("price", new int[]{100, 200, 300});
        return ResponseData.success(map);
    }


    @SaCheckLogin
    @PostMapping(value = "/save")
    ResponseData saveUser(@RequestBody User user) {
        int update = userMapper.update(user);
        if (update == 1) {
            return ResponseData.success("更新成功", userMapper.selectOneById(user.getId()));
        }
        return ResponseData.failure("更新失败");
    }
//
//    @PostMapping(value = "/create")
//    public ResponseEntity<Object> create(@RequestBody User params) {
//        userService.save(params);
//        return new ResponseEntity<>("created successfully", HttpStatus.OK);
//    }
//
//    @PostMapping(value = "/delete/{id}")
//    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
//        userService.removeById(id);
//        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
//    }
//
//    @PostMapping(value = "/update")
//    public ResponseEntity<Object> update(@RequestBody User params) {
//        userService.updateById(params);
//        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
//    }
}
