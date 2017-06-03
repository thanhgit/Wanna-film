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
import service.FilmService;
import service.GenresService;
import service.MenuService;

/**
 *
 * @author THANH_UIT
 */
@Controller
@RequestMapping(value="movies")
public class MoviepageController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String genresId(ModelMap model){
        List<Film> films= new FilmService().getMovieFilm();
        int row=(films.size()%6==0)?(films.size()/6):(films.size()/6)+1;
        model.addAttribute("row", row);
        model.addAttribute("films", films);
        model.addAttribute("see_many", new FilmService().getFilmSeeMany(false));
        model.addAttribute("acc",new Account());
        model.addAttribute("menus", new MenuService().getAll());
        model.addAttribute("genreses", new GenresService().getAll());
        model.addAttribute("countries", new CountryService().getAll());
        return "/series_movie/series_movie_template";
    }
    
    @RequestMapping(value = "{page}",method = RequestMethod.GET)
    public String genresId(@PathVariable(value = "page") String strpage, ModelMap model){
        List<Film> films= new FilmService().getMovieFilm();
        int row=(films.size()%6==0)?(films.size()/6):(films.size()/6)+1;
        model.addAttribute("row", row);
        int page=Integer.parseInt(strpage);

        model.addAttribute("page", page);
        model.addAttribute("films", (List<Film>)util.Util.getFilmAsArrayByLength(films, (page-1)*6, 6));
        model.addAttribute("see_many", new FilmService().getFilmSeeMany(false));
        model.addAttribute("acc",new Account());
        model.addAttribute("menus", new MenuService().getAll());
        model.addAttribute("genreses", new GenresService().getAll());
        model.addAttribute("countries", new CountryService().getAll());
        return "/series_movie/series_movie_template";
    }
}
