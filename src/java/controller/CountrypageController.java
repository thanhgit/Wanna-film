/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Account;
import model.Film;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CountryService;
import service.GenresService;
import service.MenuService;

/**
 *
 * @author THANH_UIT
 */
@Controller
@RequestMapping(value="country")
public class CountrypageController {
    @RequestMapping(value="/{name}")
    public String getCountryFilmAll(@PathVariable(value = "name") String name,ModelMap model){
        model.addAttribute("name", name);
        List<Film> films= new CountryService().getByName(name).getFilms();
        int row=(films.size()%6==0)?(films.size()/6):(films.size()/6)+1;
        model.addAttribute("row", row);
        model.addAttribute("films", films);
        model.addAttribute("see_many", new CountryService().getFilmSeeMany(name));
        model.addAttribute("acc",new Account());
        model.addAttribute("menus", new MenuService().getAll());
        model.addAttribute("genreses", new GenresService().getAll());
        model.addAttribute("countries", new CountryService().getAll());
        return "/country/country_template";
    }
    
    
     @RequestMapping(value = "/{name}/{page}",method = RequestMethod.GET)
    public String getCountryFilmByPage(@PathVariable(value="name") String name,@PathVariable(value = "page") String strpage, ModelMap model){
        model.addAttribute("name", name);
        List<Film> films= new CountryService().getByName(name).getFilms();
        int row=(films.size()%6==0)?(films.size()/6):(films.size()/6)+1;
        model.addAttribute("row", row);
        int page=Integer.parseInt(strpage);

        model.addAttribute("page", page);
        model.addAttribute("films", (List<Film>)util.Util.getFilmAsArrayByLength(films, (page-1)*6, 6));
        model.addAttribute("see_many", new CountryService().getFilmSeeMany(name));
        model.addAttribute("acc",new Account());
        model.addAttribute("menus", new MenuService().getAll());
        model.addAttribute("genreses", new GenresService().getAll());
        model.addAttribute("countries", new CountryService().getAll());
        return "/country/country_template";
    }
}
