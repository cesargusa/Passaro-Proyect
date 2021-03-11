package com.Proyecto.Passaro.Web.Config;



import com.Proyecto.Passaro.Service.UsuarioService;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DI {
    @Bean
    ModelMapper createModelMapper() {
        return new ModelMapper();
    }

    @Bean
    UsuarioService createUsuarioService(){
        return new UsuarioService();
    }
}
