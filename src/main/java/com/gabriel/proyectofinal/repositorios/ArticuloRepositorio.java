/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.proyectofinal.repositorios;

import com.gabriel.proyectofinal.entidades.Articulo;
import com.gabriel.proyectofinal.enumeraciones.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gabriel Miranda
 */
@Repository
public interface ArticuloRepositorio extends JpaRepository<Articulo,String>
 {
    public List<Articulo> findAllByOrderByNombreAsc();
    
    @Query("SELECT a from Articulo a WHERE a.categoria LIKE :categoria AND a.activo = true")
    public List<Articulo> buscarPorCategoria(@Param ("categoria")Categoria categoria);


public List<Articulo> findByNombreContainingOrderByNombre(String nombre);
}