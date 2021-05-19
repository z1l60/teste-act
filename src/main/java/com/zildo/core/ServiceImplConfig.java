package com.zildo.core;

import com.zildo.service.serviceImpl.UsuarioServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceImplConfig {

    @Bean
    public UsuarioServiceImpl UsuarioServiceImpl() {
        return new UsuarioServiceImpl();
    }
}
