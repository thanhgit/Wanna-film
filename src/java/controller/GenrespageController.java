/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Film;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CountryService;import service.FilmService;
import service.MenuService;

import service.GenresService;

/**
 *
 * @author THANH_UIT
 */
@Controller
@RequestMapping(value="genres")
public class GenrespageController {
    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public String genresId(@PathVariable String name, ModelMap model){
        model.addAttribute("name", name);
        List<Film> films= new GenresService().getByName(name).getFilms();
        int row=(films.size()%6==0)?(films.size()/6):(films.size()/6)+1;
        model.addAttribute("row", row);
        model.addAttribute("films", films);
        model.addAttribute("see_many", new GenresService().getFilmSeeMany(name));
        model.addAttribute("acc",new Account());
        model.addAttribute("menus", new MenuService().getAll());
        model.addAttribute("genreses", new GenresService().getAll());
        model.addAttribute("countries", new CountryService().getAll());
        return "/genres/genres_template";
    }
    
    @RequestMapping(value = "/{name}/{page}",method = RequestMethod.GET)
    public String genresId(@PathVariable(value="name") String name,@PathVariable(value = "page") String strpage, ModelMap model){
        model.addAttribute("name", name);
        List<Film> films= new GenresService().getByName(name).getFilms();
        int row=(films.size()%6==0)?(films.size()/6):(films.size()/6)+1;
        model.addAttribute("row", row);
        int page=Integer.parseInt(strpage);

        model.addAttribute("page", page);
        model.addAttribute("films", (List<Film>)util.Util.getFilmAsArrayByLength(films, (page-1)*6, 6));
        model.addAttribute("see_many", new GenresService().getFilmSeeMany(name));
        model.addAttribute("acc",new Account());
        model.addAttribute("menus", new MenuService().getAll());
        model.addAttribute("genreses", new GenresService().getAll());
        model.addAttribute("countries", new CountryService().getAll());
        return "/genres/genres_template";
    }
}
