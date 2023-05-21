package com.felix.background.service.impl;

import com.felix.background.entity.User;
import com.felix.background.mapper.UserMapper;
import com.felix.background.service.UserService;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 * @author Felix
 * @since 2023-05-14
 */
@Service
public class UserServiceImpl   implements UserService {
    @Autowired
    private UserMapper userMapper;

}
