/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.xml.internal.ws.api.pipe.Fiber;
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
@RequestMapping(value = "top")
public class ToppageController {
    @RequestMapping(value="/")
    public String get_top(ModelMap model){
        model.addAttribute("toprecently", new FilmService().getFilmRecently());
        model.addAttribute("topview", new FilmService().getFilmSeeMany());
        model.addAttribute("topfeature", new FilmService().getFilmFetured());
        model.addAttribute("toprating", new FilmService().getFilmRating());
        model.addAttribute("acc",new Account());
        model.addAttribute("menus", new MenuService().getAll());
        model.addAttribute("genreses", new GenresService().getAll());
        model.addAttribute("countries", new CountryService().getAll());       
        return "/top/top_template";
    }
}
