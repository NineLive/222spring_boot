package ru.spring.spring_boot.service;


import ru.spring.spring_boot.models.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User findOne(long id);

    public void save(User user);

    public void update(long id, User updatedUser);

    public void delete(long id);
}
