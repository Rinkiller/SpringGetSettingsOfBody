package Rin.compani.sem3.Controllers;

import Rin.compani.sem3.Domain.User;
import Rin.compani.sem3.Services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService dataProcessingService;

    @GetMapping("/")
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<String>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }
    @GetMapping("/sort")
    public List<User> sortByAge(){
        return dataProcessingService.sortUsersByAge(dataProcessingService.getRepository().getListUsers());
    }
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age){
        return dataProcessingService.filterUsersByAge(dataProcessingService.getRepository().getListUsers(),age);
    }
    @GetMapping("/calc")
    public double calculateAverageAge(){
       return dataProcessingService.calculateAverageAge(dataProcessingService.getRepository().getListUsers());
    }

}
