/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.proyectofinal.servicios;

import com.gabriel.proyectofinal.Exceptions.WebException;
import com.gabriel.proyectofinal.entidades.Articulo;
import com.gabriel.proyectofinal.entidades.Carrito;
import com.gabriel.proyectofinal.repositorios.CarritoRepositorio;
import com.gabriel.proyectofinal.repositorios.UsuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Gabriel Miranda
 */
@Service
public class CarritoServicio {
    
     @Autowired
    private CarritoRepositorio carritoRepositorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {WebException.class, Exception.class})
    public Carrito guardar(String usuario, List<Articulo> articulos, Double total) throws WebException {
//      validar(nombre, apellido, correo, clave, rol);
        Carrito entidad = new Carrito();
        entidad.setUsuario(usuarioRepositorio.getById(usuario));
        entidad.setArticulos(articulos);
        entidad.setTotalPedido(total);
        return carritoRepositorio.save(entidad);
    }

    
}
