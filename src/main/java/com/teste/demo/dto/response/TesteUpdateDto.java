package com.teste.demo.dto.response;


import javax.persistence.Id;


public class TesteUpdateDto {

    private static final long serialVersionUID = 1l;

    @Id
    private Long id;
    private Long cpf;
    private String name;
    private String email;

    public TesteUpdateDto(Long id, Long cpf, String name, String email) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
