package com.teste.demo.mapper;


import com.teste.demo.dro.UserDto;
import com.teste.demo.entity.PeopleEntity;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private MapperFactory mapperFactory;
    private MapperFacade mapperFacade;

    public UserMapper(){

        mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(PeopleEntity.class, UserDto.class)
                //2 campos para mapear
                // email e name
                .field("name", "fistName")
                .field("email","emailPerson")
                .byDefault()
                .register();
        mapperFacade = mapperFactory.getMapperFacade();

    }


    public PeopleEntity dtoParaEntity(UserDto userDto){

        return mapperFacade.map(userDto, PeopleEntity.class);

    }

    public UserDto entityParaDto(PeopleEntity peopleEntity){
        return mapperFacade.map(peopleEntity, UserDto.class);
    }

}