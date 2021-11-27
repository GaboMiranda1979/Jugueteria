/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.proyectofinal.controladores;

import static org.springframework.core.style.StylerUtils.style;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Gabriel Miranda
 */
@Controller
public class NosotrosControlador {
     @GetMapping("/nosotros")
	public String contacto(ModelMap modelo) {
		
		return "nosotros";
	}

       
        
}
