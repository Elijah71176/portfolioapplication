package se.elijah.portfolioapplication.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import se.elijah.portfolioapplication.model.ContactForm;
import se.elijah.portfolioapplication.service.EmailService;

import javax.script.Bindings;

@Controller
public class ContactController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/contact")
    public String contactForm(Model model) {
        model.addAttribute("pageTitle", "Contact Me");
        model.addAttribute("contactForm", new ContactForm());
        return "contact"; // Return the name of the Thymeleaf template (contact.html)
    }

    @PostMapping("/contact")
    public String submitContact(@Valid @ModelAttribute("contactForm") ContactForm form,
            BindingResult result, Model model) {
    if (result.hasErrors()) {
        model.addAttribute("pageTitle", "Contact Me");
        return "contact"; // Return to the contact form if validation fails

    } try {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("elijah71176@gmail.com");
        message.setSubject("New Contact Form: " + form.getSubject());
        message.setText("From: " + form.getName() + " (" + form.getEmail() + ")\n\n" + form.getMessage());
        emailService.sendEmail("elijah71176@gmail.com", message.getSubject(), message.getText());
        model.addAttribute("successMessage", "Your message has been sent successfully!");
    } catch (Exception e) {
        model.addAttribute("errorMessage", "There was an error sending your message. Please try again later.");
        }
return "contact";
}
}