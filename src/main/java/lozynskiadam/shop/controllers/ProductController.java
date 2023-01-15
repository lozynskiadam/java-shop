package lozynskiadam.shop.controllers;

import jakarta.validation.Valid;
import lozynskiadam.shop.models.Product;
import lozynskiadam.shop.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = {"", "/"})
    public String index(Model model) {
        model.addAttribute("context", "products");
        model.addAttribute("products", this.productRepository.findAll());

        return "pages/products/index";
    }

    @GetMapping(path = "/create")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("context", "products");

        return "pages/products/create";
    }

    @PostMapping(path = "/create")
    public String create(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            this.productRepository.save(product);

            return "redirect:/products";
        }

        return "pages/products/create";
    }

    @GetMapping(path = "/{id}/edit")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("product", this.productRepository.findById(id));
        model.addAttribute("context", "products");

        return "pages/products/create";
    }

    @PostMapping(path = "/{id}/edit")
    public String edit(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            this.productRepository.save(product);

            return "redirect:/products";
        }

        return "pages/products/create";
    }

    @PostMapping(path = "/{id}/delete")
    public String delete(@PathVariable int id)
    {
        this.productRepository.deleteById(id);

        return "redirect:/products";
    }

}
