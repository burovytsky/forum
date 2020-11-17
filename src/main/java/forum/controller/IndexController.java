package forum.controller;

import forum.service.ForumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private final ForumService service;

    public IndexController(ForumService service) {
        this.service = service;
    }

    @GetMapping({"/index"})
    public String index(Model model) {
        model.addAttribute("posts", service.getAll());
        return "index";
    }
}
