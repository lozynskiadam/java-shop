package lozynskiadam.shop.controllers;

import lozynskiadam.shop.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = {"", "/"})
    public String index(Model model) {
        model.addAttribute("context", "users");
        model.addAttribute("users", this.userRepository.findAll());

        return "pages/users/index";
    }

}
