package se.elijah.portfolioapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.elijah.portfolioapplication.service.ProjectService;

@Controller
public class HomeController {

    private final ProjectService projectService;

    public HomeController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pageTitle", "Welcome");
        model.addAttribute("tagline", "AWS Developer Student • Spring Boot • Java");
        return "index"; // Return the name of the Thymeleaf template (index.html)
    }
}
