package com.teste.demo.service;


import com.teste.demo.controller.LoginController;
import com.teste.demo.entity.LoginEntity;
import com.teste.demo.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repo;


    public LoginService(LoginRepository loginRepository) {
        this.repo = loginRepository;
    }

    public String saveLogin(LoginEntity loginEntity){
            repo.save(loginEntity);
            return ("Cadastro feito com sucesso");

    }

    public List<LoginEntity> listUser(){
        return repo.findAll();
    }
}
