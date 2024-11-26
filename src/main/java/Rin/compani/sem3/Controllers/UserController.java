package Rin.compani.sem3.Controllers;
import Rin.compani.sem3.Domain.User;
import Rin.compani.sem3.Services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService registrationService;
    @GetMapping
    public List<User> getAllUser(){
        return registrationService.getDataProcessingService().getRepository().getListUsers();
    }
    @GetMapping("/addUser/{name}/{age}/{email}")
    public String addUser( @PathVariable("name") String name,@PathVariable("age") int age,@PathVariable("email") String email) {
        registrationService.getDataProcessingService().addUser(registrationService.getUserService().createUser(name,age,email));
        return "User created in base";
    }
    @GetMapping("/editUser")
    public String editUser(@RequestBody String name, User user) {
        registrationService.getDataProcessingService().editUserByUserName(name,user);
        return "User is edited";
    }
    @GetMapping("/dellUser/{name}")
    public String deleteUser(@RequestBody String name) {
        registrationService.getDataProcessingService().dellUser(name);
        return "User is edited";
    }
}
