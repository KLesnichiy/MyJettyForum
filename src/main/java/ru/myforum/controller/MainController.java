package ru.myforum.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.myforum.model.Categories;
import ru.myforum.model.Coments;
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
        model.setViewName("redirect:categories");
        return model;

    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "страница  админа");
        model.addObject("message", "Эта страница только для ROLE_ADMIN !");
        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error, HttpServletRequest request) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        }


        model.setViewName("login");

        return model;

    }

    // customize the error message
    private String getErrorMessage(HttpServletRequest request, String key) {

        Exception exception = (Exception) request.getSession().getAttribute(key);

        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Неверные имя пользователя или пароль!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Неверные имя пользователя или пароль!";
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
    public ModelAndView registerUser(@ModelAttribute User user,@RequestParam(value = "date", required = false) String date) {
        if(!date.equals("")) user.setBirthday(stringToDate(date));
        if (dataService.findByUserName(user.getUsername()) != null) dataService.insertRow(user);
        else dataService.insertRole(user);
        return new ModelAndView("redirect:categories");
    }

    private Date stringToDate(String s) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = null;
        try {
            parsed = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parsed;
    }

    @RequestMapping("list")
    public ModelAndView getList() {
        List userList = dataService.getList();
        return new ModelAndView("list", "userList", userList);
    }


    @RequestMapping(value = {"postAndComents"}, method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView getPost(@ModelAttribute("coments") Coments coment,@RequestParam int id_post, HttpServletRequest request) {
        Posts post =new Posts();
        post = dataService.getPost(id_post);
        if(request.getMethod().equals("POST")){
            post.setId(id_post);
            coment.setPosts(post);
            dataService.insertComent(coment);
        }
        List comentsList = dataService.getComentsFromPost(id_post);
        ModelAndView model = new ModelAndView("post", "post", post);
        model.addObject("comentsList",comentsList);


        return model;
    }

    @RequestMapping("categories")
    public ModelAndView getCList(@RequestParam(value = "logout", required = false) String logout) {
        List catList = dataService.listCategories();
        ModelAndView model = new ModelAndView("categories", "listCategories", catList);
         if (logout != null) {
            model.addObject("msg", "Вы успешно вышли.");
        }
        return model;
    }

    @RequestMapping("posts")
    public ModelAndView editUser(@RequestParam int id) {
        List postObject = dataService.getPostbyCategoria(id);
        ModelAndView model = new ModelAndView();
        model.addObject("postObject",postObject);
        model.addObject("id_cat",id);
        model.setViewName("postsList");
        return model;
    }

    @RequestMapping("createPost")
    public ModelAndView createPost(@ModelAttribute("posts") Posts post,@RequestParam int id_cat) {
        Categories categoria=new Categories();
        categoria.setId(id_cat);
        post.setCategories(categoria);
        dataService.insertPost(post);
        int id=post.getCategories().getId();
        return new ModelAndView("redirect:posts?id="+id);
    }

    @RequestMapping(value = {"create"})
    public ModelAndView getForm(@ModelAttribute Posts post,@RequestParam int id) {
        return new ModelAndView("createPost","categoria",id);

    }










}







