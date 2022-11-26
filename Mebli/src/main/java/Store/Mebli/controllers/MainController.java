package Store.Mebli.controllers;

import Store.Mebli.Repo.FurnitureRepository;
import Store.Mebli.models.Furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private FurnitureRepository furnitureRepository;
    @GetMapping("/")
    public String greeting(Model model){
        Iterable<Furniture> furnitures = furnitureRepository.findAll();
        model.addAttribute("furnitures", furnitures);
        return"home";
    }
    @GetMapping("/add")
    public String greet(Model model){
        return"add";
    }
}
