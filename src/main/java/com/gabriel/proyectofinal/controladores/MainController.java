/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.proyectofinal.controladores;

import com.gabriel.proyectofinal.entidades.Articulo;
import com.gabriel.proyectofinal.entidades.Usuario;
import com.gabriel.proyectofinal.servicios.ArticuloServicio;
import com.gabriel.proyectofinal.servicios.UsuarioServicio;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Gabriel Miranda
 */

@Controller
@RequestMapping("/")
public class MainController {
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    
    @Autowired
    private ArticuloServicio articuloServicio;
    
    @GetMapping("/")
	public String index(ModelMap modelo) {
		
		return "index";
	}
        
 
       @GetMapping("/login")
	public String login(HttpSession session, Authentication usuario, ModelMap modelo, @RequestParam(required = false) String error, @RequestParam(required = false)String logout) {
		try {
			if (usuario.getName() != null) {
				return "redirect:/";
			} else {
				
				if (error != null && !error.isEmpty()) {
					modelo.addAttribute("error", "La dirección de mail o la contraseña que ingresó son incorrectas.");
				}
                                if (logout != null) {
                                    modelo.put("logout", "Ha salido correctamente.");
        }
                                
				return "index";
			}
			
		} catch (Exception e) {
			if (error != null && !error.isEmpty()) {
				modelo.addAttribute("error", "La dirección de mail o la contraseña que ingresó son incorrectas.");
			}
			return "index";
		}
	}
	
	@GetMapping("/loginsuccess")
	public String loginresolver() {
				
		return "redirect:/";
                
	}
        
        
        
        @GetMapping("/catalogo")
    public String catalogo(ModelMap modelo) {
        List<Articulo> articulos = articuloServicio.listarTodos();
        modelo.addAttribute("articulos", articulos);
        return "catalogo";
    }

/*
    @PostMapping("/mailsender")
	public String enviarMail(@PathVariable String correo, @RequestParam String nombre, @RequestParam String apellido, @RequestParam String mensaje) {

		try {
			notificacionService.notificar(id, mail);
			return "redirect:/";
		} catch (Exception e) {
			return "redirect:/";
		}
	}
*/
}
