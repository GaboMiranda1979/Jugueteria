/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.proyectofinal.repositorios;

import com.gabriel.proyectofinal.entidades.Carrito;
import com.gabriel.proyectofinal.entidades.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author OSCAR
 */
@Repository
public interface CarritoRepositorio extends JpaRepository <Carrito,String>{
    
}
