package Rin.compani.sem3.Services;

import Rin.compani.sem3.Domain.User;
import Rin.compani.sem3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class DataProcessingService  {

    public UserRepository getRepository() {
        return repository;
    }
    @Autowired
    private UserRepository repository;

    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }
    public void addUser(User user){
        repository.getListUsers().add(user);
    }
    public void dellUser(String name){
        repository.getListUsers().remove(repository.getListUsers().stream().filter(u->u.getName().equals(name)).findFirst().orElse(null));
    }
    public void editUserByUserName(String name,User user){
        for (User u:repository.getListUsers()){
            if (u.getName().equals(name)){
                u.setName(user.getName());
                u.setAge(user.getAge());
                u.setEmail(user.getEmail());
            }
        }

    }

}
