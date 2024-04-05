package org.pahappa.systems.kimanyisacco.services;

import org.pahappa.systems.kimanyisacco.models.users.User;

import java.util.List;

public interface UserService {
    void saveUser(User user) throws Exception;
    List<User> getAllUsers();
    boolean deleteUser(Long user_id);

    User getUser(Long id);

    boolean updateUser(User user);

    boolean checkEmail(String email);
    boolean checkPhone(String phone);
}
