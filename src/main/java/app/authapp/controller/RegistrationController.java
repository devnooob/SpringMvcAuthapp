package app.authapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.authapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import app.authapp.service.UserService;

@Controller
public class RegistrationController {
  @Autowired
  public UserService userService;

  @GetMapping("/register")
  public String register(@ModelAttribute("user") User user) {
    return "register";
  }

  @PostMapping("/registerProcess")
  public ModelAndView addUser(@ModelAttribute("user") User user) {

    userService.register(user);

    return new ModelAndView("welcome", "username", user.getUsername());
  }
}
