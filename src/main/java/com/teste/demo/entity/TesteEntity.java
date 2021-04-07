package com.teste.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user", schema = "public")
public class TesteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf")
    private Long cpf;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany
    @JoinColumn(name = "id_user")
    private List<PostEntity> posts;

    public TesteEntity(){

    }

    public TesteEntity(Long cpf, String name, String email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEntity> posts) {
        this.posts = posts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
