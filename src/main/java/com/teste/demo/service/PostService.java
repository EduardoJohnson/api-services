package com.teste.demo.service;


import com.teste.demo.entity.PostEntity;
import com.teste.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {


    @Autowired
    private PostRepository repo;



    public PostService(PostRepository postRepository){
        this.repo = postRepository;


    }

        public String save(PostEntity postEntity){
            repo.save(postEntity);
            return("cadastro realizado");
}

    public List<PostEntity> getPost(){

        //Vai pesquisar o usuario de acordo com o post
        //Lá no post vai ter só o ID do usuario, a partir de lá vc encontra usando o repositorio do usuario, todos os dados dele
        //User userRetornado = userRepo.findById(1L);

//        PostEntity post = new PostEntity();
//        post.setUse

        return repo.findAll();
    }


}
