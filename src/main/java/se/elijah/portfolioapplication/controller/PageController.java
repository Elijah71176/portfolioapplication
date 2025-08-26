package se.elijah.portfolioapplication.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.elijah.portfolioapplication.service.ProjectService;

@Controller
public class PageController {
    private final ProjectService projectService;

    public PageController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("pageTitle", "About Me");
        model.addAttribute("tagline", "Learn more about me and my journey as a developer.");
        model.addAttribute("description", "Currently looking for internship opportunities. Passionate about cloud computing and backend development.");
        return "about"; // Return the name of the Thymeleaf template (about.html)
    }
    @GetMapping("/projects")
    public String projects(Model model) {
        model.addAttribute("pageTitle", "My Projects");
        model.addAttribute("projects", projectService.listProjects());
        return "projects"; // Return the name of the Thymeleaf template (projects.html)
    }
    @GetMapping("/gallery")
    public String gallery(Model model) {
        model.addAttribute("pageTitle", "Gallery");
        model.addAttribute("tagline", "A collection of images showcasing my work and experiences.");

        // ✅ Pass the projects (with image URLs) to Thymeleaf
        model.addAttribute("images", projectService.listProjects());
        return "gallery"; // Return the name of the Thymeleaf template (gallery.html)
    }
}
