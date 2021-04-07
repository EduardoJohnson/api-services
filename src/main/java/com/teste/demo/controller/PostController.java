package com.teste.demo.controller;

import com.teste.demo.entity.PostEntity;

import com.teste.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(value = "/api")
public class PostController {


    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public String create(@RequestBody PostEntity postEntity){
        return "Usuario cadastrado" + postService.save(postEntity);
    }

    @GetMapping("/all")
    public List<PostEntity> getAll() {

        return postService.getPost();


    }
}