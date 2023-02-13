package org.clone.videohosting.services.user;

import org.clone.videohosting.entities.User;
import org.clone.videohosting.exceptions.UserNotFoundException;
import org.clone.videohosting.repositories.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public User getUser(String userName) {

        if(!userRepository.existsByUserName(userName)) {
            throw new UserNotFoundException();
        }

        return userRepository.findByUserName(userName);
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public User login(String email, String password) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User updateUserDetails(String id, User user) {
        return null;
    }

    @Override
    public void removeUser(String id) {

    }
}
