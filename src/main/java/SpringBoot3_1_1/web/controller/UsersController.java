package SpringBoot3_1_1.web.controller;

import SpringBoot3_1_1.web.models.User;
import SpringBoot3_1_1.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UsersController {

//    private final UserService userService;

    private final UserRepository userRepository;

    @Autowired
    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Autowired
//    public UsersController(UserService userService) {
//        this.userService = userService;
//    }

    @GetMapping()
    public String show(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users/*userService.getAllUsers()*/);
        return "users";
    }

    @GetMapping("/user")
    public String index(@RequestParam("id") Long id, Model model) {
        Optional<User> user = userRepository.findById(id);//userService.getByIdUser(id);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
//        userService.save(user);
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
//        userService.delete(id);
        userRepository.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String edit(Model model, @RequestParam("id") Long id) {
        Optional<User> user = userRepository.findById(id);
        model.addAttribute("user", user/*userService.getByIdUser(id)*/);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user, @RequestParam("id") Long id) {
//        userService.update(id, user);
        Optional<User> userOptional = userRepository.findById(id);
        userOptional.get().setName(user.getName());
        userOptional.get().setEmail(user.getEmail());
        return "redirect:/users";
    }
}
