package com.teste.demo.authentication.security;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.teste.demo.entity.PeopleEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


public class UserPrincipal implements UserDetails {

    private String name;
    private String password;

    public UserPrincipal(PeopleEntity peopleEntity){
        this.name = peopleEntity.getName();
        this.password = peopleEntity.getPassword();
    }

    public static UserPrincipal create(PeopleEntity peopleEntity){
        return new UserPrincipal(peopleEntity);
    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
