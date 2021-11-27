/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.proyectofinal.servicios;

import com.gabriel.proyectofinal.Exceptions.WebException;
import com.gabriel.proyectofinal.entidades.Articulo;
import com.gabriel.proyectofinal.entidades.Proveedor;
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
public class ProveedorServicio {
    
      @Autowired
    private ProveedorRepositorio proveedorRepositorio;
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {WebException.class, Exception.class})
    public Proveedor guardar(Proveedor proveedor) throws WebException {

        Proveedor entidad = new Proveedor();
        entidad.setNombre(proveedor.getNombre());
        entidad.setCorreo(proveedor.getCorreo());
        entidad.setActivo(true);
        return proveedorRepositorio.save(entidad);
    }


    
     @Transactional(readOnly = true)
	public List<Proveedor> listarTodos() {
		return proveedorRepositorio.findAllByOrderByNombreAsc();
    
}
}