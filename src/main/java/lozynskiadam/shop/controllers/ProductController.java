package lozynskiadam.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/products")
public class ProductController {

    @GetMapping(path = {"", "/"})
    public String index(Model model) {
        return "pages/products/index";
    }

}
