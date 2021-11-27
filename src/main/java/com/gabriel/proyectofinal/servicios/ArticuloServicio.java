/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.proyectofinal.servicios;

import com.gabriel.proyectofinal.Exceptions.WebException;
import com.gabriel.proyectofinal.entidades.Articulo;
import com.gabriel.proyectofinal.enumeraciones.Categoria;
import com.gabriel.proyectofinal.repositorios.ArticuloRepositorio;
import com.gabriel.proyectofinal.repositorios.ProveedorRepositorio;
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
public class ArticuloServicio {
    
 @Autowired
 private ArticuloRepositorio articuloRepositorio; 
 
 @Autowired
 private ProveedorRepositorio proveedorRepositorio;
  
 @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {WebException.class, Exception.class})
    public Articulo guardar(String nombre, Double precio, String categoria, Integer cantidad,
            String foto, String proveedor) throws WebException {

//        validar(nombre, apellido, correo, clave, rol);

        Articulo entidad = new Articulo();

        entidad.setNombre(nombre);
        entidad.setPrecio(precio);
        entidad.setCategoria(Categoria.valueOf(categoria));
        entidad.setCantidad(cantidad);
        entidad.setFoto(foto);
        entidad.setProveedor(proveedorRepositorio.getById(proveedor));
        entidad.setActivo(true);
        return articuloRepositorio.save(entidad);
    }
    
    @Transactional(readOnly = true)
	public List<Articulo> listarTodos() {
		return articuloRepositorio.findAllByOrderByNombreAsc();
	}

    @Transactional(readOnly = true)
	public List<Articulo> listarCategoria(String categoria){
		return articuloRepositorio.buscarPorCategoria(Categoria.valueOf(categoria));
	}
        
        @Transactional(readOnly = true)
	public List<Articulo> buscarNombre(String nombre){
		return articuloRepositorio.findByNombreContainingOrderByNombre(nombre);
	}
 
}
    

