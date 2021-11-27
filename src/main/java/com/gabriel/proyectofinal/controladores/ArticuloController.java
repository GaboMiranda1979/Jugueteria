/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.proyectofinal.controladores;

import com.gabriel.proyectofinal.Exceptions.WebException;
import com.gabriel.proyectofinal.entidades.Articulo;
import com.gabriel.proyectofinal.entidades.Proveedor;
import com.gabriel.proyectofinal.servicios.ArticuloServicio;
import com.gabriel.proyectofinal.servicios.ProveedorServicio;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Gabriel Miranda
 */
@Controller
@RequestMapping("/articulo")
public class ArticuloController {
    
    @Autowired
    ArticuloServicio articuloServicio;
    
    @Autowired
    ProveedorServicio proveedorServicio;
    
   
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")

            @GetMapping("/registro")
	public String articulo(ModelMap modelo) {
            
            List<Articulo> articulos = articuloServicio.listarTodos();
        
        modelo.addAttribute("articulos", articulos);

        List<Proveedor> proveedores = proveedorServicio.listarTodos();
        modelo.addAttribute("proveedores", proveedores);
        return "articulosAdmin";

		
	
	}
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/registro")
	public String guardar(ModelMap modelo, @RequestParam String nombre, @RequestParam Double precio,
			@RequestParam Integer cantidad, @RequestParam String foto, @RequestParam String proveedor, @RequestParam String categoria) {

		try {
			articuloServicio.guardar(nombre, precio, categoria, cantidad, foto, proveedor);

			modelo.put("exito", "registro exitoso");
			return "articulosAdmin";
		} catch (WebException e) {
			modelo.put("error", e.getMessage());
			return "articulosAdmin";
		}
        }

 @PostMapping("/listar")
	public String listarCategoria(ModelMap modelo, String categoria) {
            
            List<Articulo> articulos = articuloServicio.listarCategoria(categoria);
        
        modelo.addAttribute("articulos", articulos);

        
        return "listarcategoria";
}
        
        @PostMapping("/buscar")
	public String buscarNombre(ModelMap modelo, String nombre) {
            
            List<Articulo> articulos = articuloServicio.buscarNombre(nombre);
        
        modelo.addAttribute("articulos", articulos);

        
        return "listarcategoria";
}
        
}   

