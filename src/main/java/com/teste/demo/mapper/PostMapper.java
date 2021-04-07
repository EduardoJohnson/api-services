package com.teste.demo.mapper;


import com.teste.demo.dro.PostDto;
import com.teste.demo.entity.PostEntity;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    private MapperFactory mapperFactory;
    private MapperFacade mapperFacade;


    public PostMapper(){
        mapperFactory = new DefaultMapperFactory
                .Builder().build();
        mapperFactory.classMap(PostEntity.class, PostDto.class)
                .byDefault().register();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    public PostEntity dtoToEntity(PostDto postDto){
        return mapperFacade.map(postDto,PostEntity.class);
    }
    public PostDto entityToDto(PostEntity postEntity){
        return mapperFacade.map(postEntity,PostDto.class);
    }
}
