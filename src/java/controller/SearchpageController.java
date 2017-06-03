/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CountryService;
import service.FilmService;
import service.GenresService;
import service.MenuService;

/**
 *
 * @author THANH_UIT
 */
@Controller
@RequestMapping(value = "search")
public class SearchpageController {
    @RequestMapping(value="/key/{key}",method = RequestMethod.GET)
    public String searchkey(@PathVariable(value = "key") String key,ModelMap model){
        model.addAttribute("acc", new Account());
        model.addAttribute("menus", new MenuService().getAll());
        model.addAttribute("genreses", new GenresService().getAll());
        model.addAttribute("countries", new CountryService().getAll());        
        return "/search/search_template";
    }
    
     @RequestMapping(value="/key",method = RequestMethod.POST)
    public String search(@RequestParam("Search")String key, ModelMap model){
  
        model.addAttribute("films", new FilmService().getFilmByKey(key));
        model.addAttribute("acc", new Account());
        model.addAttribute("menus", new MenuService().getAll());
        model.addAttribute("genreses", new GenresService().getAll());
        model.addAttribute("countries", new CountryService().getAll());        
        return "/search/search_template";
    }
    
     @RequestMapping(value="/",method = RequestMethod.GET)
    public String searchAll( ModelMap model){
  
        model.addAttribute("films", new FilmService().getAll());
        model.addAttribute("acc", new Account());
        model.addAttribute("menus", new MenuService().getAll());
        model.addAttribute("genreses", new GenresService().getAll());
        model.addAttribute("countries", new CountryService().getAll());        
        return "/search/search_template";
    }
}
