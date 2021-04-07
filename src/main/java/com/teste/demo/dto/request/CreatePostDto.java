package com.teste.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatePostDto {

    private Long id_user;
    private String post;


    public CreatePostDto(
            @JsonProperty(value = "id_user",required = true)Long id_user,
            @JsonProperty(value = "post",required = true)String post
    ){
        this.id_user = id_user;
        this.post = post;
    }

    public Long getId_user() {
        return id_user;
    }

    public String getPost() {
        return post;
    }
}

