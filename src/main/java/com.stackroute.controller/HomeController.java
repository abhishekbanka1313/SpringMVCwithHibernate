package com.stackroute.controller;

import com.stackroute.dao.UserDao;
import com.stackroute.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
//Dispatcher Servlet forwards the request to Controller , check the mapping in XML file
public class HomeController {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/")
    // This annotation maps HTTP requests to handler methods of MVC and REST controllers.
    public ModelAndView display(ModelMap map)
    {
        ModelAndView model=new ModelAndView("index");
        User obj = new User();
        obj.setName("Abhishek");
        map.addAttribute("greeting",obj.getName());
        return model;
    }

    @RequestMapping(value = "/user")
    public ModelAndView userdata(ModelMap map, @RequestParam String firstName, @RequestParam String password) {
        //map.addAttribute ("username",firstName);
        //map.addAttribute ("password",password);
        ModelAndView model=new ModelAndView("user");
        User user1=new User();
        user1.setName(firstName);
        user1.setPassword(password);
        model.addObject(user1);
        userDao.saveUser(user1);
        map.addAttribute("userList", userDao.getAllUser());
        model.addObject("name", user1.getName());
        model.addObject("password",user1.getPassword());
        //return "userdata";
        return model;
    }
}
