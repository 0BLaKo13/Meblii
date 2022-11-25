package Store.Mebli.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String greeting(Model model){
        return"home";
    }
    @GetMapping("/add")
    public String greet(Model model){
        return"add";
    }
}
