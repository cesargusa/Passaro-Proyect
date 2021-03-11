package com.Proyecto.Passaro.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.Proyecto.Passaro.Repository.Entities.UsuarioEntity;
import com.Proyecto.Passaro.Repository.Interfaces.UsuarioRepository;
import com.Proyecto.Passaro.Service.Model.UsuarioDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UsuarioDTO> GetAll() {
        return usuarioRepository.findAll().stream().map(x -> modelMapper.map(x, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    public List<UsuarioDTO> GetById(Long id) {
        return usuarioRepository.findById(id).stream().map(x -> modelMapper.map(x, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    public List<UsuarioDTO> GetByNombreyApellido(String nombre, String apellido1) {
        return usuarioRepository.findByNombreyApellido(nombre, apellido1).stream()
                .map(x -> modelMapper.map(x, UsuarioDTO.class)).collect(Collectors.toList());
    }

    public UsuarioDTO add(UsuarioDTO usuario) {
        UsuarioEntity usuarioAñadir = modelMapper.map(usuario, UsuarioEntity.class);
        UsuarioEntity result = usuarioRepository.save(usuarioAñadir);
        return modelMapper.map(result, UsuarioDTO.class);

    }

    public UsuarioDTO update(Long id, UsuarioDTO usuario) {
        UsuarioEntity usuarioUpdate = modelMapper.map(usuario, UsuarioEntity.class);
        UsuarioEntity result = usuarioRepository.save(usuarioUpdate);
        return modelMapper.map(result, UsuarioDTO.class);

    }

    public void delete(Long id) {
        Optional<UsuarioEntity> usuarioDelete = usuarioRepository.findById(id);
        if (usuarioDelete.isPresent()) {
            usuarioRepository.delete(usuarioDelete.get());
        }
    }
}
