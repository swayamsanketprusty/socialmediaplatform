package project.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    @Secured("ROLE_USER") // Requires the user to have the "ROLE_USER" role
    public String home() {
        return "home";
    }
}
