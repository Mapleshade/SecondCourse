package ru.kpfu.itis.repository.impl;


import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    List<User> users = new ArrayList<User>() {{
        add(new User("Максим", "Игнатьев", "vietto", "1234", "20"));
        add(new User("Андрей", "Титов", "amigo", "1234", "20"));
        add(new User("Михаил", "Магомедов", "misha", "1234", "20"));
        add(new User("Саша", "Прискин", "alex", "1234", "20"));
    }};

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User findUserByLogin(String login) {
        for (User user : users) {
            if (user.getLogin() != null && user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
