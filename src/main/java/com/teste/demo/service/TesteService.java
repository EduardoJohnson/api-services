package com.teste.demo.service;

import com.teste.demo.dro.UserDto;
import com.teste.demo.dto.request.CreateUserDto;
import com.teste.demo.dto.response.TesteUpdateDto;
import com.teste.demo.entity.PostEntity;
import com.teste.demo.entity.TesteEntity;
import com.teste.demo.mapper.UserMapper;
import com.teste.demo.repository.PostRepository;
import com.teste.demo.repository.TesteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.stream.Collectors;


@Service
public class TesteService {

    @Autowired
    private final TesteRepository testeRepository;


    @Autowired
    private PostRepository repo;

    @Autowired
    private UserMapper mapper;

    public TesteService(TesteRepository testeRepository){
        this.testeRepository = testeRepository;
    }

    public String save(CreateUserDto createUserDto){


        Long cpf = createUserDto.getCpf();
        String name = createUserDto.getName();
        String email = createUserDto.getEmail();

        TesteEntity testeEntity = new TesteEntity(cpf,name,email);

        testeRepository.save(testeEntity);

        String toString = "Usuário " + name + " Cadastrado";

        return toString;


    }

    public TesteEntity update(Long id, TesteUpdateDto testeUpdateDto){

        Long cpf = testeUpdateDto.getCpf();
        String name = testeUpdateDto.getName();
        String email = testeUpdateDto.getEmail();

        TesteEntity att = testeRepository.findById(id).get();

        att.setCpf(cpf);
        att.setName(name);
        att.setEmail(email);


        return testeRepository.save(att);

    }

    public List<UserDto> list(){
        List<TesteEntity> teste = testeRepository.findAll();

        List<UserDto> listaConvertida = teste.stream().map(mapper::entityParaDto).collect(Collectors.toList());

        return listaConvertida;

    }

    public TesteEntity filterId(Long id){
        return testeRepository.findById(id).get();
    }
    public void remove(Long id){
        testeRepository.deleteById(id);
    }



    public List<PostEntity> getPosts() {
        return repo.findAll();

    }

}
