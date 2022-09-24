package com.example.login.controller;


        import com.example.login.controller.dto.UserDto;
        import com.example.login.repository.entity.User;
        import com.example.login.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.core.Authentication;
        import org.springframework.security.core.context.SecurityContextHolder;
        import org.springframework.web.bind.annotation.*;
        import java.util.Collections;

@RestController
@RequestMapping("/users")
public class UserController {

    final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<User> getUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        boolean isAuthenticated = authentication.isAuthenticated();
        String currentPrincipalName = authentication.getName();
        System.out.println(currentPrincipalName);
        if (currentPrincipalName!="anonymousUser") {
            System.out.println("isAuthenticated");
            return userService.all();
        }
        else {
            System.out.println("isAuthenticated not" );
            return Collections.emptyList();
        }


    }

     @CrossOrigin
     @GetMapping("/{userid}")
     public User findById(@PathVariable Long userid) {
        return userService.findById( userid );
     }

//    @CrossOrigin
//    @GetMapping("/{username}")
//
//    public User findByIdName(@PathVariable String username) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//
//        return userService.findByIdName(currentPrincipalName);
//    }

    @CrossOrigin
    @GetMapping("/currentuser")

    public User findByIdName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        boolean isAuthenticated = authentication.isAuthenticated();


        return userService.findByIdName(currentPrincipalName);
    }





}

