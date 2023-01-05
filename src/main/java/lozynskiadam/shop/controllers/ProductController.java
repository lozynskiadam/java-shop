package lozynskiadam.shop.controllers;

import lozynskiadam.shop.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = {"", "/"})
    public String index(Model model) {
        model.addAttribute("products", this.productRepository.findAll());

        return "pages/products/index";
    }

}
