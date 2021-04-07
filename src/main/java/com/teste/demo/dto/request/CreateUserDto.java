package com.teste.demo.dto.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserDto {

    private Long cpf;
    private String name;
    private String email;


    public CreateUserDto(
            @JsonProperty(value = "cpf",required = true) Long cpf,
            @JsonProperty(value = "name",required = true)String name,
            @JsonProperty(value = "email",required = true)String email

    ){
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

        public Long getCpf() {
            return cpf;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;


    }
}
