package com.teste.demo.controller;


import com.teste.demo.dro.UserDto;
import com.teste.demo.dto.request.CreateUserDto;
import com.teste.demo.dto.response.TesteUpdateDto;
import com.teste.demo.entity.PostEntity;
import com.teste.demo.entity.TesteEntity;
import com.teste.demo.service.TesteService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/")
public class TesteController {

    @Autowired
    private TesteService service;


    @PostMapping("/create")
    public String create(@RequestBody CreateUserDto createUserDto){
        return service.save(createUserDto);
    }

    @GetMapping(value = "/get")
    public List<UserDto> list() {
        return service.list();

    }
        @PutMapping(value = "/{id}")
        public TesteEntity update(@PathVariable(value = "id")Long id,@RequestBody TesteUpdateDto testeEntity){
            return service.update(id,testeEntity);


    }

    @GetMapping(value = "/{id}")
    public TesteEntity getId(@PathVariable(value = "id")Long id,UserDto userDto){
        return service.filterId(id);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        service.remove(id);
    }




    @GetMapping("/{id}/posts")
    public List<PostEntity> listPost(){
        return service.getPosts();
    }
}
