package com.Proyecto.Passaro.Web.Config;

import com.Proyecto.Passaro.Repository.Entities.UsuarioEntity;
import com.Proyecto.Passaro.Repository.Interfaces.UsuarioRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class initDB {
    @Bean
    CommandLineRunner initDataBase(UsuarioRepository usuarioRepository){
        return args ->{
           /*  usuarioRepository.save(new UsuarioEntity("Cesar","Gutierrez","Sanchez",722709600));
            usuarioRepository.save(new UsuarioEntity("Elena","Sanchez","Bartolome",686645454));
            usuarioRepository.save(new UsuarioEntity("Antonio","Gutierrez","Perruca",615953723)); */
        };
    }
}
