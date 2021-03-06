/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.proyectofinal.repositorios;


import com.gabriel.proyectofinal.entidades.Proveedor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gabriel Miranda
 */
@Repository
public interface ProveedorRepositorio extends JpaRepository <Proveedor,String>
{
    public List<Proveedor> findAllByOrderByNombreAsc();
}
