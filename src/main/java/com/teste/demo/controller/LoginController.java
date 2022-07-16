package com.teste.demo.controller;


import com.teste.demo.entity.LoginEntity;
import com.teste.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @GetMapping("/all")
    public List<LoginEntity> findAll() {
        return loginService.listUser();
    }

    @PostMapping("/cadastro")
    public String create(@RequestBody LoginEntity loginEntity){
        return loginService.saveLogin(loginEntity);
    }
}
