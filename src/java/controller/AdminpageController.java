/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import model.Account;
import model.Country;
import model.Film;
import model.Genres;
import model.Status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.AccountService;
import service.CountryService;
import service.FilmService;
import service.GenresService;
import service.MenuService;
import service.NewsService;
import service.StatusService;

/**
 *
 * @author THANH_UIT
 */
@Controller
@RequestMapping(value = "admin")
public class AdminpageController {
    
    
    @RequestMapping(value = "/index")
    public String index(){
        return "/admin/index";
    }
    
    // Account
    @RequestMapping(value = "/account/added")
    public String accountadded(@RequestParam("user_name_add")String user_name,@RequestParam("pass_add")String pass,@RequestParam("email_add")String email,@RequestParam("phone_add")String phone,ModelMap model){
        if(new AccountService().register(new Account(new Date().getTime(),user_name,pass,email,phone))){
             model.addAttribute("message", "Thêm thành công");
        }else{
              model.addAttribute("message", "Thêm thất bại");           
        }
        model.addAttribute("accounts", new AccountService().getAll());
        return "/admin/table_account";
    }
    
     @RequestMapping(value = "/account/deleted")
    public String accountdeleted(@RequestParam("account_id")long account_id,ModelMap model){
        if(new AccountService().delete(new Account(account_id))){
            model.addAttribute("message", "Xóa thành công");    
        }else{
                        model.addAttribute("message", "Xóa thất bại");

        }
        model.addAttribute("accounts", new AccountService().getAll());
        return "/admin/table_account";
    }
    
    @RequestMapping(value = "/account/updated")
    public String accountupdated(@RequestParam("account_id")long account_id,@RequestParam("pass_update")String pass,@RequestParam("email_update")String email,@RequestParam("phone_update")String phone,ModelMap model){
        Account acc=new AccountService().getById(account_id);
        acc.setPassword(pass);
        acc.setEmail(email);
        acc.setPhone(phone);
        if(new AccountService().update(acc)){
            model.addAttribute("message", "Cập nhập     thành công");
        }else{
                        model.addAttribute("message", "Cập nhập thành công");

        }
        model.addAttribute("accounts", new AccountService().getAll());
        return "/admin/table_account";
    }
    
    @RequestMapping(value = "/account")
    public String account(ModelMap model){
        model.addAttribute("accounts", new AccountService().getAll());
        return "/admin/table_account";
    }   
    
    
    @RequestMapping(value = "/account/add/{id}")
    public String accountadd(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 1);
        model.addAttribute("model", new AccountService().getById(id));
        return "/admin/form_account";
    }
    
     @RequestMapping(value = "/account/delete/{id}")
    public String accountdel(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 2);
        model.addAttribute("model", new AccountService().getById(id));
        return "/admin/form_account";
    }
    
     @RequestMapping(value = "/account/update/{id}")
    public String accountupdate(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 3);
        model.addAttribute("model", new AccountService().getById(id));
        return "/admin/form_account";
    }
    
      @RequestMapping(value = "/account/detail/{id}")
    public String accountdetail(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 4);
        model.addAttribute("model", new AccountService().getById(id));
        return "/admin/form_account";
    }
    
    // Country
    
    
     @RequestMapping(value = "/country/added")
    public String countryadded(@RequestParam("name_add")String name,ModelMap model){
        if(new CountryService().add(new Country(new Date().getTime(), name))){
            model.addAttribute("message", "Thêm thành công");
        }else{
            model.addAttribute("message", "Thêm thất bại");
        }
        
        model.addAttribute("countries", new CountryService().getAll());
        return "/admin/table_country";
    }   
    
     @RequestMapping(value = "/country/deleted")
    public String countrydelete(@RequestParam("country_id")long country_id,ModelMap model){
        if(new CountryService().delete(new Country(country_id,""))){
            model.addAttribute("message", "Thêm thành công");
        }else{
            model.addAttribute("message", "Thêm thất bại");
        }
        
        model.addAttribute("countries", new CountryService().getAll());
        return "/admin/table_country";
    } 
    
     @RequestMapping(value = "/country")
    public String country(ModelMap model){
        model.addAttribute("countries", new CountryService().getAll());
        return "/admin/table_country";
    }   
    @RequestMapping(value = "/country/add/{id}")
    public String countryadd(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 1);
        model.addAttribute("model", new CountryService().getById(id));
        return "/admin/form_country";
    }
    
     @RequestMapping(value = "/country/delete/{id}")
    public String countrydel(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 2);
        model.addAttribute("model", new CountryService().getById(id));
        return "/admin/form_country";
    }
    
     @RequestMapping(value = "/country/update/{id}")
    public String countryupdate(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 3);
        model.addAttribute("model", new CountryService().getById(id));
        return "/admin/form_country";
    }
    
      @RequestMapping(value = "/country/detail/{id}")
    public String countrydetail(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 4);
        model.addAttribute("model", new CountryService().getById(id));
        return "/admin/form_country";
    }
    // Film
    @RequestMapping(value = "/film/added")
    public String filmadded(@RequestParam("name_add")String name,
            @RequestParam("description_add")String description,
            @RequestParam("image_add")String image,
            @RequestParam("video_add")String video,
            @RequestParam("genres_add")long genres_id,
            @RequestParam("country_add")long country_id,
            @RequestParam("year_add")int year,
            @RequestParam("see_max_add")boolean see_max,
            @RequestParam("series_add")boolean series,
            @RequestParam("feature_add")boolean feature,
            @RequestParam("rating_add")boolean rating,
            @RequestParam("recent_add")boolean  recent,
            @RequestParam("status_add")long  status_id,
            ModelMap model){
        Film film=new Film(new Date().getTime(),name,description,image,video,new GenresService().getById(genres_id),new CountryService().getById(country_id));
//        film.setRating(rating);
//        film.setSee_many(see_max);
//        film.setSeries(series);
//        film.setFeature(feature);
//        film.setRecently(recent);
        film.setStatus(new StatusService().getById(status_id));
           
        if(new FilmService().add(film)){
            model.addAttribute("message", "Thêm thành công");
        }else{
            model.addAttribute("message", "Thêm thất bại");
        }
        
        model.addAttribute("films", new FilmService().getAll());
        return "/admin/table_film";
    }  
    
    
     @RequestMapping(value = "/film")
    public String film(ModelMap model){
        model.addAttribute("films", new FilmService().getAll());
        return "/admin/table_film";
    }   
    @RequestMapping(value = "/film/add/{id}")
    public String filmadd(@PathVariable(value = "id")long id, ModelMap model){
        model.addAttribute("genreses", new GenresService().getAll());
        model.addAttribute("countries", new CountryService().getAll());
        model.addAttribute("statuses", new StatusService().getAll());
        model.addAttribute("command", 1);
        model.addAttribute("model", new FilmService().getById(id));
        return "/admin/form_film";
    }
    
     @RequestMapping(value = "/film/delete/{id}")
    public String filmdel(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 2);
        model.addAttribute("model", new FilmService().getById(id));
        return "/admin/form_film";
    }
    
     @RequestMapping(value = "/film/update/{id}")
    public String filmupdate(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 3);
        model.addAttribute("model", new FilmService().getById(id));
        return "/admin/form_film";
    }
    
      @RequestMapping(value = "/film/detail/{id}")
    public String filmdetail(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 4);
        model.addAttribute("model", new FilmService().getById(id));
        return "/admin/form_film";
    }
    // Genres
    
     @RequestMapping(value = "/genres")
    public String genres(ModelMap model){
        model.addAttribute("genreses", new GenresService().getAll());
        return "/admin/table_genres";
    }   
    @RequestMapping(value = "/genres/add/{id}")
    public String genresadd(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 1);
        model.addAttribute("model", new GenresService().getById(id));
        return "/admin/form_genres";
    }
    
     @RequestMapping(value = "/genres/delete/{id}")
    public String genresdel(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 2);
        model.addAttribute("model", new GenresService().getById(id));
        return "/admin/form_genres";
    }
    
     @RequestMapping(value = "/genres/update/{id}")
    public String genresdate(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 3);
        model.addAttribute("model", new GenresService().getById(id));
        return "/admin/form_genres";
    }
    
      @RequestMapping(value = "/genres/detail/{id}")
    public String genresdetail(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 4);
        model.addAttribute("model", new GenresService().getById(id));
        return "/admin/form_genres";
    }
    // Menu
    
     @RequestMapping(value = "/menu")
    public String menu(ModelMap model){
        model.addAttribute("menus", new MenuService().getAll());
        return "/admin/table_menu";
    }   
    @RequestMapping(value = "/menu/add/{id}")
    public String menuadd(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 1);
        model.addAttribute("model", new MenuService().getById(id));
        return "/admin/form_menu";
    }
    
     @RequestMapping(value = "/menu/delete/{id}")
    public String menudel(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 2);
        model.addAttribute("model", new MenuService().getById(id));
        return "/admin/form_menu";
    }
    
     @RequestMapping(value = "/menu/update/{id}")
    public String menuupdate(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 3);
        model.addAttribute("model", new MenuService().getById(id));
        return "/admin/form_menu";
    }
    
      @RequestMapping(value = "/menu/detail/{id}")
    public String menudetail(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 4);
        model.addAttribute("model", new MenuService().getById(id));
        return "/admin/form_menu";
    }
    // News
    
     @RequestMapping(value = "/news")
    public String news(ModelMap model){
        model.addAttribute("newses", new NewsService().getAll());
        return "/admin/table_news";
    }   
    @RequestMapping(value = "/news/add/{id}")
    public String newsadd(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 1);
        model.addAttribute("model", new NewsService().getById(id));
        return "/admin/form_news";
    }
    
     @RequestMapping(value = "/news/delete/{id}")
    public String newsdel(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 2);
        model.addAttribute("model", new NewsService().getById(id));
        return "/admin/form_news";
    }
    
     @RequestMapping(value = "/news/update/{id}")
    public String newsupdate(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 3);
        model.addAttribute("model", new NewsService().getById(id));
        return "/admin/form_news";
    }
    
      @RequestMapping(value = "/news/detail/{id}")
    public String newsdetail(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 4);
        model.addAttribute("model", new NewsService().getById(id));
        return "/admin/form_news";
    }
    // Status
    
     @RequestMapping(value = "/status")
    public String status(ModelMap model){
        model.addAttribute("statuses", new StatusService().getAll());
        return "/admin/table_status";
    }   
    @RequestMapping(value = "/status/add/{id}")
    public String statusadd(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 1);
        model.addAttribute("model", new StatusService().getById(id));
        return "/admin/form_status";
    }
    
     @RequestMapping(value = "/status/delete/{id}")
    public String statusdel(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 2);
        model.addAttribute("model", new StatusService().getById(id));
        return "/admin/form_status";
    }
    
     @RequestMapping(value = "/status/update/{id}")
    public String statusupdate(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 3);
        model.addAttribute("model", new StatusService().getById(id));
        return "/admin/form_status";
    }
    
      @RequestMapping(value = "/status/detail/{id}")
    public String statusdetail(@PathVariable(value = "id")long id, ModelMap model){

        model.addAttribute("command", 4);
        model.addAttribute("model", new StatusService().getById(id));
        return "/admin/form_status";
    }
}
