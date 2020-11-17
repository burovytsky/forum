package forum.controller;

import forum.model.User;
import forum.service.ForumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegController {
    private final ForumService service;


    public RegController(ForumService service) {
        this.service = service;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user) {
        service.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

}
