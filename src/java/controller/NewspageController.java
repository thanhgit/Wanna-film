/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Account;
import model.Film;
import model.News;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import service.CountryService;
import service.GenresService;
import service.MenuService;
import service.NewsService;
import service.StatusService;

/**
 *
 * @author THANH_UIT
 */
@Controller
@RequestMapping(value = "news")
public class NewspageController {
    @RequestMapping(value = "/")
    public String getNews(ModelMap model){
        List<News> news=new NewsService().getRecentNews(6);
        int row=news.size()%2==0?news.size()/2:(news.size()/2)+1;
        model.addAttribute("row", row);
        model.addAttribute("news", news);
        
        List<Film> film_showing=new StatusService().getFilm_Showing();
        int row_showing=film_showing.size()%2==0?film_showing.size()/2:(film_showing.size()/2)+1;
        model.addAttribute("row_showing",row_showing);
        model.addAttribute("showing", film_showing);
        
        List<Film> film_coming_soon=new StatusService().getFilm_ComingSoon();
        int row_coming_soon=film_coming_soon.size()%2==0?film_coming_soon.size()/2:(film_coming_soon.size()/2)+1;
        model.addAttribute("row_coming_soon",row_coming_soon);
        model.addAttribute("coming_soon", film_coming_soon);
        
        model.addAttribute("news_update", new NewsService().getAll());
        
        model.addAttribute("news_hot", new NewsService().getRecentNews(3));
        
        model.addAttribute("acc",new Account());
        model.addAttribute("menus", new MenuService().getAll());
        model.addAttribute("genreses", new GenresService().getAll());
        model.addAttribute("countries", new CountryService().getAll());
        return "/news/news_template";
    }
}
