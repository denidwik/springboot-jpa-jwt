package pl.rmitula.authapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.rmitula.authapp.dto.UserSummary;
import pl.rmitula.authapp.model.User;
import pl.rmitula.authapp.security.CurrentUser;
import pl.rmitula.authapp.security.UserPrincipal;
import pl.rmitula.authapp.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        return userService.getCurrentUser(currentUser);
    }

    @GetMapping("/findAllUser")
    public List<User> findAllUser(@RequestHeader (value = "Authorization") String autho){
        return userService.findAllUser();
    }
}
