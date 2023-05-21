package com.felix.background.controller;

import com.felix.background.mapper.ProjectMapper;
import com.felix.background.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Felix
 * @since 2023-05-21
 */
@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "http://localhost:9527")
public class ProjectController {



    @Autowired
    private UserMapper userMapper;

    @GetMapping("/hi")
    public String hi(){
        return userMapper.selectOneById(100).getUsername();
    }
}
