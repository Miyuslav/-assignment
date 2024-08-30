package net.javaguides.springboot.controller;

import jakarta.validation.Valid;
import net.javaguides.springboot.dto.RegistrationDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


    //handle login page request
    @GetMapping("/login")
    public String loginPage() {
        return "login";


    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }

    //handle method for registration
    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDto user,
                           BindingResult result,
                            Model model) {
        User exitingUser = userService.findByEmail(user.getEmail());
        if(exitingUser!=null && exitingUser.getEmail() != null && !exitingUser.getEmail().isEmpty() ) {
            result.rejectValue("email", "error.user", "Email already exists!");
            return "register";
        }
        if(result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";

    }
}