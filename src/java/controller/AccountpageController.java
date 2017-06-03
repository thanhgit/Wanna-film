/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import model.Account;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.AccountService;
import service.CountryService;
import service.GenresService;
import service.MenuService;

/**
 *
 * @author THANH_UIT
 */
@Controller
@RequestMapping(value = "account")
public class AccountpageController {
    @RequestMapping(value = "/login")
    public String login(ModelMap model){
        model.addAttribute("menus", new MenuService().getAll());
        model.addAttribute("genreses", new GenresService().getAll());
        model.addAttribute("countries", new CountryService().getAll());
        model.addAttribute("acc", new Account());
            return "/home/login";
        }

   @RequestMapping(value = "/login/check")
    public String logincheck(@RequestParam("user_name_login")String username,@RequestParam("password_login")String pass,ModelMap model){
        model.addAttribute("menus", new MenuService().getAll());
        model.addAttribute("genreses", new GenresService().getAll());
        model.addAttribute("countries", new CountryService().getAll());
                model.addAttribute("acc", new Account());
              
        Account acc=new Account(username, pass);
        AccountService serviceacc=new AccountService();
        if((acc.getUser_name().trim().equals("") || acc.getPassword().trim().equals(""))){
                model.addAttribute("message", "Bạn chưa nhập tài khoản hoặc mật khẩu");
                 return "/home/login";
        }else{
             if(serviceacc.login(acc)){
                 if(serviceacc.loginAdmin(acc)){
                     model.addAttribute("user_name", acc!=null?acc.getUser_name():"no name");
                     return "/admin/index";
                 }else{
                     model.addAttribute("message", "Bạn đã đăng nhập thành công với quyền người sử dụng");
                     return "/home/login";
                 }
        }else{
            
            
//                model.addAttribute("status_login","style=\"display: block;\"");
//                model.addAttribute("status_register", "style=\"display: none;\"");
              
                model.addAttribute("message", "Tài khoản hoặc mật khẩu của bạn sai");
            return "/home/login";
        }
                
       
        }
        
       
    }
    
    @RequestMapping(value = "/register")
    public String register(@RequestParam("user_name_register")String user_name,@RequestParam("password_register")String password,@RequestParam("email_register")String email,@RequestParam("phone_register")String phone,ModelMap model){
        Account acc =new Account(new Date().getTime(), user_name, password, email, phone);
        model.addAttribute("menus", new MenuService().getAll());
        model.addAttribute("genreses", new GenresService().getAll());
        model.addAttribute("countries", new CountryService().getAll());
                        model.addAttribute("acc", new Account());
        if(new AccountService().isExist(acc)){
            model.addAttribute("message", "Tài khoản đã tồn tại");
//              model.addAttribute("status_login","style=\"display: none;\"");
//                model.addAttribute("status_register", "style=\"display: block;\"");
        }else{
            if(new AccountService().register(acc)){
                        model.addAttribute("message", "Bạn đã đăng ký thành công");
            }else{
                  model.addAttribute("message", "Lỗi mạng");
            }
        }

        return "/home/login";
    }
}
