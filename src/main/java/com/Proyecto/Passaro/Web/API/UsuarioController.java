package com.Proyecto.Passaro.Web.API;

import java.util.List;

import javax.websocket.server.PathParam;

import com.Proyecto.Passaro.Repository.Entities.UsuarioEntity;
import com.Proyecto.Passaro.Service.UsuarioService;
import com.Proyecto.Passaro.Service.Model.UsuarioDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/UsuariosAPI")
public class UsuarioController {
    private final UsuarioService usuarioService;

    UsuarioController(UsuarioService usuarioService){
        this.usuarioService=usuarioService;
    }


    @GetMapping()
    public List<UsuarioDTO> GetNombreyApellido(@RequestParam(name = "nombre",required = false,defaultValue = "")String nombre,
    @RequestParam(name = "apellido1",required = false, defaultValue = "")String apellido1 ){
            if(nombre.equals("") && apellido1.equals("")){
                return usuarioService.GetAll();
            }else{
                return usuarioService.GetByNombreyApellido(nombre, apellido1);
            }
    }

    @GetMapping("/{id}")
    public List<UsuarioDTO> GetId(@PathVariable("id") Long id){
        return usuarioService.GetById(id);
    }
    @PostMapping
    public UsuarioDTO AddOrder(@RequestBody UsuarioDTO usuario){
        return usuarioService.add(usuario);
    }
    
    @PutMapping("/{id}")
    public UsuarioDTO UpdateOrder(@RequestBody UsuarioDTO usuario, @PathVariable("id") Long id){
        return usuarioService.update(id,usuario);
    }
    
    @DeleteMapping("/{id}")
    public void DeleteOrder(@PathVariable("id") Long id){
        usuarioService.delete(id);

    }
   
}
