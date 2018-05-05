package ru.myforum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.myforum.model.Categories;
import ru.myforum.model.Posts;
import ru.myforum.model.User;
import ru.myforum.services.DataService;

import javax.servlet.http.HttpServletRequest;


/*
/**
 * Created by Шмель on 11.12.2017.
 */
@Controller
public class MainController {

    @Autowired
    DataService dataService;

    @RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
    public ModelAndView defaultPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security + Hibernate Example");
        model.addObject("message", "This is default page!");
        model.setViewName("hello");
        return model;

    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security + Hibernate Example");
        model.addObject("message", "This page is for ROLE_ADMIN only!");
        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }

    // customize the error message
    private String getErrorMessage(HttpServletRequest request, String key) {

        Exception exception = (Exception) request.getSession().getAttribute(key);

        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username and password!";
        }

        return error;
    }

    // for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        // check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);

            model.addObject("username", userDetail.getUsername());

        }

        model.setViewName("403");
        return model;

    }

    @RequestMapping(value = {"form"})
    public ModelAndView getForm(@ModelAttribute User user) {
        return new ModelAndView("form");
    }

    @RequestMapping("register")
    public ModelAndView registerUser(@ModelAttribute User user) {
        if (dataService.findByUserName(user.getUsername()) != null) dataService.insertRow(user);
        else dataService.insertRole(user);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping("list")
    public ModelAndView getList() {
        List userList = dataService.getList();
        return new ModelAndView("list", "userList", userList);
    }


    @RequestMapping("post")
    public ModelAndView getPost(@RequestParam int id) {
        Posts post = dataService.getPost(id);
        return new ModelAndView("post", "post", post);
    }

    @RequestMapping("categories")
    public ModelAndView getCList() {
        List catList = dataService.listCategories();
        return new ModelAndView("categories", "listCategories", catList);
    }

    @RequestMapping("posts")
    public ModelAndView editUser(@RequestParam int id) {
        List postObject = dataService.getPostbyCategoria(id);
        return new ModelAndView("postsList", "postObject", postObject);
    }

    @RequestMapping("createPost")
    public ModelAndView createPost(@ModelAttribute Posts post) {
        Categories categoria=dataService.getCategories(1);
        dataService.insertPost(new Posts(post.getTitle(),post.getText(),categoria));
        return new ModelAndView("redirect:posts");
    }

    @RequestMapping(value = {"create"})
    public ModelAndView getForm(@ModelAttribute Posts post) {
        return new ModelAndView("createPost");

    }
}







