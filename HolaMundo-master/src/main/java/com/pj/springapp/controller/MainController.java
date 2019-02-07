package com.pj.springapp.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Daniel Pardo Ligorred
 * @ http://www.programacionj2ee.com
 */
@Controller
public class MainController {

    /**
     * Muestra la pagina de inicio.
     *
     * @param model Objeto de Spring para la carga de atributos.
     * @param request Objeto que contiene todas las propiedades de la llamada.
     * @return String Nombre de la vista.
     */
    @RequestMapping({"/", "/index"})
    public String showHomePage(Model model, HttpServletRequest request) {

        model.addAttribute("author", "Daniel Pardo Ligorred");
        model.addAttribute("website", "http://www.programacionj2ee.com");

        return "home";
    }
}
