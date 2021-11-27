/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.proyectofinal.repositorios;

import com.gabriel.proyectofinal.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gabriel Miranda
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario,String>
 {
    @Query("SELECT a from Usuario a WHERE a.correo LIKE :correo AND a.activo = true")

    public Usuario buscarPorEmail(@Param("correo") String correo);
}
