package com.teste.demo.service;

import com.teste.demo.dro.UserDto;
import com.teste.demo.dto.request.CreateUserDto;
import com.teste.demo.dto.response.TesteUpdateDto;
import com.teste.demo.entity.PostEntity;
import com.teste.demo.entity.PersonEntity;
import com.teste.demo.mapper.UserMapper;
import com.teste.demo.repository.PostRepository;
import com.teste.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.stream.Collectors;


@Service
public class PersonService {

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    private PostRepository repo;

    @Autowired
    private UserMapper mapper;

    public PersonService(PersonRepository personRepository)    {
        this.personRepository = personRepository;
    }

    public String save(CreateUserDto createUserDto){

        Long cpf = createUserDto.getCpf();
        String name = createUserDto.getName();
        String email = createUserDto.getEmail();
        String password = createUserDto.getPassword();

        PersonEntity personEntity = new PersonEntity(cpf,name,email,password);

        personRepository.save(personEntity);

        String toString = "Usuário " + name + " Cadastrado";

        return toString;


    }

    public PersonEntity update(Long id, TesteUpdateDto testeUpdateDto){

        Long cpf = testeUpdateDto.getCpf();
        String name = testeUpdateDto.getName();
        String email = testeUpdateDto.getEmail();

        PersonEntity att = personRepository.findById(id).get();

        att.setCpf(cpf);
        att.setName(name);
        att.setEmail(email);


        return personRepository.save(att);

    }

    public List<UserDto>   list(){
        List<PersonEntity> teste = personRepository.findAll();

        List<UserDto> listaConvertida = teste.stream().map(mapper::entityParaDto).collect(Collectors.toList());

        return listaConvertida;

    }

    public PersonEntity filterId(Long id){
        return personRepository.findById(id).get();
    }
    public void remove(Long id){
        personRepository.deleteById(id);
    }



    public List<PostEntity> getPosts() {
        return repo.findAll();

    }

}
