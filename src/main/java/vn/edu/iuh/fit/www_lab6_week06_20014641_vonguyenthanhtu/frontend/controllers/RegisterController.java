package vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.model.User;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.services.UserService;

import java.time.LocalDateTime;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        User user = new User();
        model.addAttribute("account", user);
        return "register";
    }

//    @PostMapping("/register")
//    public String register(@ModelAttribute User user){
//        user.setRegisterAt(LocalDateTime.now());
//
//        userService.insert(user);
//        return "redirect:/";
//    }
}
