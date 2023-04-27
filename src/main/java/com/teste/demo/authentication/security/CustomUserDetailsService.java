package com.teste.demo.authentication.security;

import com.teste.demo.entity.PeopleEntity;
import com.teste.demo.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PeopleRepository peopleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        PeopleEntity existUser = peopleRepository.findByName(username);

        if(existUser != null){
            throw new Error("usuario nao existe");
        }

        return UserPrincipal.create(existUser);
    }
}
