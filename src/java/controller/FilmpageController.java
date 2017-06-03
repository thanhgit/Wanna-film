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
import service.CountryService;
import service.FilmService;
import service.GenresService;
import service.MenuService;

/**
 *
 * @author THANH_UIT
 */
@Controller
@RequestMapping(value = "film")
public class FilmpageController {
    @RequestMapping(value = "/{name}")
    public String getIntroFilm(@PathVariable(value = "name")String name,ModelMap model){
        
        model.addAttribute("name", name);
        model.addAttribute("menus", new MenuService().getAll());
        model.addAttribute("acc",new Account());
        model.addAttribute("genreses", new GenresService().getAll());
        model.addAttribute("countries", new CountryService().getAll());
        return "/film/film_intro_template";
    }
    
    @RequestMapping(value = "/{name}/xemphim")
    public String getContentFilm(@PathVariable(value = "name")String name,ModelMap model){
        
        model.addAttribute("name", name);
        model.addAttribute("film", new FilmService().getByName(name));
        model.addAttribute("films", util.Util.getFilmAsArrayByLength(new FilmService().getAll(), 0, 5));
        model.addAttribute("menus", new MenuService().getAll());
        model.addAttribute("acc",new Account());
        model.addAttribute("genreses", new GenresService().getAll());
        model.addAttribute("countries", new CountryService().getAll());
        return "/film/film_content_template";
    }
}
