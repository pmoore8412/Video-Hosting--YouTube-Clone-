package org.clone.videohosting.services.user;

import org.clone.videohosting.entities.User;

import java.util.List;

public interface UserService {

    User getUser(String userName);

    void addUser(User user);

    User login(String email, String password);

    List<User> getAllUsers();

    User updateUserDetails(String id, User user);

    void removeUser(String id);

}
