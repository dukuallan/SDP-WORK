package org.pahappa.systems.kimanyisacco.services.impl;

import org.mindrot.jbcrypt.BCrypt;
import org.pahappa.systems.kimanyisacco.dao.userDAO.UserDAO;
import org.pahappa.systems.kimanyisacco.models.users.User;
import org.pahappa.systems.kimanyisacco.services.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {
    List<User> userList;

    private final UserDAO userDAO = new UserDAO();

    // Save a new member
    public void saveUser(User user) throws Exception {
        if(!checkEmail(user.getEmail()))
            throw new Exception("Email already registered");
        if(!checkPhone(user.getPhone()))
            throw new Exception("The phone number already registered");

        // Hash the password before storing it in the database
        String hashedPassword = hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        user.setStatus(0);
        userDAO.save(user);

    }

    // get all members
    public List<User> getAllUsers() {

        return userDAO.getUsers();
    }
    // removing member in the database
    public boolean deleteUser(Long user_id) {
        return userDAO.deleteUser(user_id);
    }

    @Override
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    // update member details
    public boolean updateUser(User user) {
        // Hash the password before storing it in the database
        String hashedPassword = hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        return userDAO.updateUser(user);
    }


    private String hashPassword(String password) {
        // Use a strong hashing algorithm
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }


    public boolean checkEmail(String email) {
        return userDAO.checkEmail(email);
    }

    @Override
    public boolean checkPhone(String phone) {
        return userDAO.checkPhone(phone);
    }
}
