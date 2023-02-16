package org.clone.videohosting.services.user;

import org.clone.videohosting.entities.User;
import org.clone.videohosting.exceptions.UserAlreadyExistsException;
import org.clone.videohosting.exceptions.UserNotAuthorizedException;
import org.clone.videohosting.exceptions.UserNotFoundException;
import org.clone.videohosting.repositories.UserRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
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

        if(!userRepository.existsByUserName(user.getUserName())) {
            throw new UserAlreadyExistsException();
        }

        userRepository.save(user);

    }

    @Override
    public User login(String email, String password) {

        Optional<User> loginUser = Optional.ofNullable(userRepository.findByEmail(email));

        if(loginUser.isPresent()) {
            if(password.equals(loginUser.get().getPassword())) {
                return loginUser.get();
            }
        }

        throw new UserNotAuthorizedException();

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll().stream().collect(Collectors.toList());
    }

    @Override
    public User updateUserDetails(String id, User user) {
        return null;
    }

    @Override
    public void removeUser(String id) {

        if(!userRepository.existsById(id)) {
            throw new UserNotFoundException();
        }

        Optional<User> user = userRepository.findById(id);

        userRepository.delete(user.get());

    }
}
