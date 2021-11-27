/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.proyectofinal.controladores;

import com.gabriel.proyectofinal.Exceptions.WebException;
import com.gabriel.proyectofinal.entidades.Articulo;
import com.gabriel.proyectofinal.entidades.Proveedor;
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
@RequestMapping("/proveedor")
public class ProveedorController {
    
    @Autowired
    ProveedorServicio proveedorServicio;
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
            @GetMapping("/registro")
	public String proveedor(ModelMap modelo, final Proveedor proveedor) {
		
		return "proveedorAdmin";
	}
      @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/registro")
	public String guardar(ModelMap modelo, Proveedor proveedor) {

		try {
			proveedorServicio.guardar(proveedor);

			modelo.put("exito", "registro exitoso");
			return "redirect:/proveedor/registro";
		} catch (WebException e) {
			modelo.put("error", e.getMessage());
			return "proveedorAdmin";
		}
        }
    
}
