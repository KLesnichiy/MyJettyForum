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
<<<<<<< HEAD
=======
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.myforum.model.Categories;
<<<<<<< HEAD
import ru.myforum.model.Coments;
=======
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
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
<<<<<<< HEAD
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:categories");
=======

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security + Hibernate Example");
        model.addObject("message", "This is default page!");
        model.setViewName("hello");
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
        return model;

    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
<<<<<<< HEAD
        model.addObject("title", "страница  админа");
        model.addObject("message", "Эта страница только для ROLE_ADMIN !");
=======
        model.addObject("title", "Spring Security + Hibernate Example");
        model.addObject("message", "This page is for ROLE_ADMIN only!");
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
<<<<<<< HEAD
    public ModelAndView login(@RequestParam(value = "error", required = false) String error, HttpServletRequest request) {
=======
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        }

<<<<<<< HEAD

=======
        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
        model.setViewName("login");

        return model;

    }
<<<<<<< HEAD

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

=======

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

>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
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
<<<<<<< HEAD
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
=======
    public ModelAndView registerUser(@ModelAttribute User user) {
        if (dataService.findByUserName(user.getUsername()) != null) dataService.insertRow(user);
        else dataService.insertRole(user);
        return new ModelAndView("redirect:list");
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
    }

    @RequestMapping("list")
    public ModelAndView getList() {
        List userList = dataService.getList();
        return new ModelAndView("list", "userList", userList);
    }


<<<<<<< HEAD
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
=======
    @RequestMapping("post")
    public ModelAndView getPost(@RequestParam int id) {
        Posts post = dataService.getPost(id);
        return new ModelAndView("post", "post", post);
    }

    @RequestMapping("categories")
    public ModelAndView getCList() {
        List catList = dataService.listCategories();
        return new ModelAndView("categories", "listCategories", catList);
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
    }

    @RequestMapping("posts")
    public ModelAndView editUser(@RequestParam int id) {
        List postObject = dataService.getPostbyCategoria(id);
<<<<<<< HEAD
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
=======
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
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0

    }
}










}







