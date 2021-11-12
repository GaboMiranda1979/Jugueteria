/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.proyectofinal.servicios;

import com.gabriel.proyectofinal.Exceptions.WebException;
import com.gabriel.proyectofinal.entidades.Usuario;
import com.gabriel.proyectofinal.enumeraciones.Rol;
import com.gabriel.proyectofinal.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author Gabriel  Miranda
 */
@Service
public class UsuarioServicios {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {WebException.class, Exception.class})
    public Usuario guardar(String nombre, String apellido, String correo,
            String password) throws WebException {

//        validar(nombre, apellido, correo, clave, rol);

        Usuario entidad = new Usuario();

        entidad.setNombre(nombre);
        entidad.setApellido(apellido);
        entidad.setCorreo(correo);
        entidad.setPassword(new BCryptPasswordEncoder().encode(password));
        entidad.setRol(Rol.USUARIO);
        entidad.setActivo(true);
        return usuarioRepositorio.save(entidad);
    }
}
