/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.proyectofinal.controladores;

import com.gabriel.proyectofinal.Exceptions.WebException;
import com.gabriel.proyectofinal.servicios.UsuarioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Gabriel Miranda
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioServicios usuarioServicio;
    
    @PostMapping("/registro")
	public String guardar(ModelMap modelo, @RequestParam String nombre, @RequestParam String apellido,
			@RequestParam String correo, @RequestParam String password) {

		try {
			usuarioServicio.guardar(nombre, apellido, correo, password);

			modelo.put("exito", "registro exitoso");
			return "index";
		} catch (WebException e) {
			modelo.put("error", e.getMessage());
			return "index";
		}
	}

    
}
