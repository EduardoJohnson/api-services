package com.teste.demo.controller;


import com.teste.demo.dro.UserDto;
import com.teste.demo.dto.request.CreateUserDto;
import com.teste.demo.dto.response.TesteUpdateDto;
import com.teste.demo.entity.PostEntity;
import com.teste.demo.entity.PersonEntity;
import com.teste.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="http://localhost:3000")
public class PersonController {

    @Autowired
    private PersonService service;


    @PostMapping("/create")
    public String create(@RequestBody CreateUserDto createUserDto){
        return service.save(createUserDto);
    }

    @GetMapping("/get")
    public List<UserDto> list() {
        return service.list();

    }
        @PutMapping(value = "/{id}")
        public PersonEntity update(@PathVariable(value = "id")Long id, @RequestBody TesteUpdateDto testeEntity){
            return service.update(id,testeEntity);


    }

    @GetMapping(value = "/{id}")
    public PersonEntity getId(@PathVariable(value = "id")Long id, UserDto userDto){
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
