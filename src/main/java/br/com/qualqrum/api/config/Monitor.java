package br.com.qualqrum.api.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.qualqrum.api.repository.UserRepository;

@Component
public class Monitor {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init(){
        // System.out.println("users:: " +   userRepository.findAll().size());
    }
    
}