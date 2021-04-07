package com.teste.demo.service;


import com.teste.demo.dro.PostDto;
import com.teste.demo.dto.request.CreatePostDto;
import com.teste.demo.entity.PostEntity;
import com.teste.demo.mapper.PostMapper;
import com.teste.demo.repository.PostRepository;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {


    @Autowired
    private PostRepository repo;

    @Autowired
    private PostMapper mapper;




    public PostService(PostRepository postRepository){
        this.repo = postRepository;


    }

        public String save(CreatePostDto createPostDto){

            Long id_user = createPostDto.getId_user();
            String post = createPostDto.getPost();
            PostEntity postEntity = new PostEntity(id_user,post);

            repo.save(postEntity);
            return("cadastro realizado");
}





    public List<PostDto> listPost(){
        List<PostEntity> res = repo.findAll();
        List<PostDto> conversao = res.stream().map(mapper::entityToDto).collect(Collectors.toList());

        return conversao;
    }


}
