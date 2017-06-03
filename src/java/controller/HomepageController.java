/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Account;
import model.Country;
import model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import service.CountryService;
import service.FilmService;
import service.GenresService;
import service.MenuService;

/**
 *
 * @author THANH_UIT
 */
@Controller
@RequestMapping(value="home")
public class HomepageController {   

    @RequestMapping(value="/index")
    public String index(ModelMap model){
        model.addAttribute("acc",new Account());
        model.addAttribute("menus", new MenuService().getAll());
        model.addAttribute("genreses", new GenresService().getAll());
        model.addAttribute("countries", new CountryService().getAll());
        model.addAttribute("films", new FilmService().getAll());
        return "/home/index";
    }
    
    @RequestMapping(value="/FAQ")
    public String faq(ModelMap model){
        model.addAttribute("acc",new Account());
        model.addAttribute("menus", new MenuService().getAll());
        model.addAttribute("genreses", new GenresService().getAll());
        model.addAttribute("countries", new CountryService().getAll());
        return "/home/FAQ";
    }
    
    @RequestMapping(value="/contact")
    public String contact(ModelMap model){
        model.addAttribute("acc",new Account());
        model.addAttribute("menus", new MenuService().getAll());
        model.addAttribute("genreses", new GenresService().getAll());
        model.addAttribute("countries", new CountryService().getAll());
        return "/home/contact";
    }
}
