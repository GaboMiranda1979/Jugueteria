/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.proyectofinal.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Gabriel Miranda
 */

@Controller
@RequestMapping("/")
public class MainController {
    
    @GetMapping("/")
	public String index(ModelMap modelo) {
		
		return "index";
	}
        @GetMapping("/login")
	public String login(ModelMap modelo) {
		
		return "login";
        }
    
}