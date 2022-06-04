package app.authapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.authapp.model.Login;
import app.authapp.model.User;
import app.authapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

  @Autowired
  UserService userService;

  @GetMapping("/login")
  public String login(@ModelAttribute("login") Login login) {
    return "login";
  }

  @PostMapping("/loginProcess")
  public ModelAndView loginProcess(@ModelAttribute("login") Login login) {
    ModelAndView mav = null;

    User user = userService.validateUser(login);

    if (null != user) {
      mav = new ModelAndView("welcome");
      mav.addObject("username", user.getUsername());
    } else {
      mav = new ModelAndView("login");
      mav.addObject("message", "Username or Password is wrong!!");
    }

    return mav;
  }

}
