package ru.myforum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.myforum.model.User;
import ru.myforum.services.DataService;



/**
 * Created by Шмель on 11.12.2017.
 */
@Controller

public class MainController {
    @Autowired
    DataService dataService;



    @RequestMapping(value={"form","/"})
    public ModelAndView getForm(@ModelAttribute User user) {
        return new ModelAndView("form");
    }

    @RequestMapping("register")
    public ModelAndView registerUser(@ModelAttribute User user) {
        dataService.insertRow(user);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping("list")
    public ModelAndView getList() {
        List userList = dataService.getList();
        return new ModelAndView("list", "userList", userList);
    }




    @RequestMapping("Access_Denied")
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user","Fonza");
        return "accessDenied";
    }



    }







