package com.Proyecto.Passaro.Repository.Interfaces;

import java.util.List;

import com.Proyecto.Passaro.Repository.Entities.UsuarioEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long>{
    @Query(value = "SELECT u FROM Usuario u WHERE id = :id")
    List<UsuarioEntity> findProductById(@Param("id") Long id);

    @Query(value = "SELECT u FROM Usuario u WHERE (:nombre='' OR nombre LIKE %:nombre%) AND (:apellido1='' OR apellido1 LIKE %:apellido1%) ORDER BY nombre")
    List<UsuarioEntity> findByNombreyApellido(@Param("nombre") String nombre,@Param("apellido1")String apellido1);
}
