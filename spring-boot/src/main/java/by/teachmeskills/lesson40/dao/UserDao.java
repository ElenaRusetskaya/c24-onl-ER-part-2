package by.teachmeskills.lesson40.dao;

import by.teachmeskills.lesson40.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> getAll();
    Optional<User> getByName(Long name);
    User save(User user);
    User remove(User user);
    void delete(Long name);
}
