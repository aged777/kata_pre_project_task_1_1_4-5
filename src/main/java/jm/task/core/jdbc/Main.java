package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

//        Создание объекта класса UserServiceImpl, на него будет ссылаться ссылка userService типа UserService
        UserService userService = new UserServiceImpl();

//        Cоздание таблицы User(ов)
        userService.createUsersTable();

//        Добавление 4 User(ов)
        userService.saveUser("Alex", "Semenov", (byte) 23);
        userService.saveUser("Alex2", "Semenov2", (byte) 24);
        userService.saveUser("Alex3", "Semenov3", (byte) 21);
        userService.saveUser("Alex4", "Semenov4", (byte) 28);

//        Получение всех User из базы
        List<User> users = userService.getAllUsers();

//        Вывод в консоль
        for (User user:users
        ) {
            System.out.println(user);
        }

//        Очистка таблицы User(ов)
        userService.cleanUsersTable();

//        Удаление таблицы
        userService.dropUsersTable();
    }
}
