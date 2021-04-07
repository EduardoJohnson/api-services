package com.teste.demo.mapper;


import com.teste.demo.dro.UserDto;
import com.teste.demo.entity.TesteEntity;
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
            mapperFactory.classMap(TesteEntity.class, UserDto.class)
                    //2 campos para mapear
                    // email e name
                    .field("name", "nome")
                    .field("email","emailPessoa")
                    .byDefault()
                    .register();
            mapperFacade = mapperFactory.getMapperFacade();

        }


        public TesteEntity dtoParaEntity(UserDto userDto){

            return mapperFacade.map(userDto, TesteEntity.class);

        }

            public UserDto entityParaDto(TesteEntity testeEntity){
             return mapperFacade.map(testeEntity, UserDto.class);
            }

}
