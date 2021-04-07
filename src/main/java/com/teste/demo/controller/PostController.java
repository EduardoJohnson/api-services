package com.teste.demo.controller;

import com.teste.demo.dro.PostDto;
import com.teste.demo.dto.request.CreatePostDto;
import com.teste.demo.entity.PostEntity;

import com.teste.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/get")
public class PostController {


    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public String create(@RequestBody CreatePostDto createPostDto){
        return "Usuario cadastrado" + postService.save(createPostDto);
    }

    @GetMapping("/all")
    public List<PostDto> findAll() {
        return postService.listPost();


    }
}