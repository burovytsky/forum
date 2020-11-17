package forum.controller;

import forum.service.ForumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    private final ForumService forumService;

    public LoginController(ForumService forumService) {
        this.forumService = forumService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request) {
        if (forumService.checkUser(request.getParameter("username"), request.getParameter("password"))) {
            return "redirect:/index";
        }
        return "login";
    }
}