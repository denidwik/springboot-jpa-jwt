package pl.rmitula.authapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rmitula.authapp.dto.UserSummary;
import pl.rmitula.authapp.model.User;
import pl.rmitula.authapp.repository.UserRepository;
import pl.rmitula.authapp.security.UserPrincipal;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserSummary getCurrentUser(UserPrincipal userPrincipal) {
        return UserSummary.builder()
                .id(userPrincipal.getId())
                .email(userPrincipal.getEmail())
                .name(userPrincipal.getName())
                .build();
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }
}
