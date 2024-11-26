package Rin.compani.sem3.Services;

import Rin.compani.sem3.Domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }
}
