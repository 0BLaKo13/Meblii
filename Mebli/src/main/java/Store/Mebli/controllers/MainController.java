package Store.Mebli.controllers;

import Store.Mebli.Repo.FurnitureRepository;
import Store.Mebli.models.Furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private FurnitureRepository furnitureRepository;
    @GetMapping("/")
    public String mainList(Model model){
        Iterable<Furniture> furnitures = furnitureRepository.findAll();
        model.addAttribute("furnitures", furnitures);
        return"home";
    }
    @GetMapping("/add")
    public String adding(Model model){
        return"add";
    }
    @PostMapping("/add")
    public String modelPostAdd(@RequestParam String title, @RequestParam String description, @RequestParam String images, @RequestParam String properties, Model model) {
        Furniture furniture = new Furniture(title, description, images, properties);
        furnitureRepository.save(furniture);
        return "redirect:/";
    }
    @GetMapping("/home/{id}")
    public String modelDetails(@PathVariable(value= "id") long id, Model model){
        if(!furnitureRepository.existsById(id)){
            return "redirect:/";
        }
        Optional<Furniture> furniture = furnitureRepository.findById(id);
        ArrayList<Furniture> res = new ArrayList<>();
        furniture.ifPresent(res::add);
        model.addAttribute("furniture", res);
        return"model";
    }
}
