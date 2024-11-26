package Rin.compani.sem3.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public UserService getUserService() {
        return userService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }


    @Autowired
    UserService userService;
    @Autowired
    DataProcessingService dataProcessingService;
    @Autowired
    NotificationService notificationService;
//
//    public RegistrationService(String name, int age, String email) {
//        userService.createUser(name, age, email);
//    }


//    Создать сервис "RegistrationService", который принимает на вход данные о пользователе (имя, возраст, email),
//    создает пользователя с помощью UserService, затем использует DataProcessingService для добавленияпользователя в список и
//    выполнения операций над этим списком. Послевыполнения каждой операции, использовать NotificationService длявыводаинформации о
//    выполненной операции. Рекомендации для преподавателей по оценке задания:
//    1. Проверьте правильность использования аннотации @Autowired.
//    2. Убедитесь, что все операции выполняются внужномпорядкеирезультаты каждой операции корректны

}
