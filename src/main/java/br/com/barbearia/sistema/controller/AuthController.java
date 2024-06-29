package br.com.barbearia.sistema.controller;


import br.com.barbearia.sistema.model.User;
import br.com.barbearia.sistema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

   @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
       User registeredUser = userService.registerUser(user);
       return  ResponseEntity.ok(registeredUser);
   }

   @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user){
       User authenticatedUser = userService.loginUser(user.getUsername(), user.getPassword());
       return  ResponseEntity.ok(authenticatedUser);
   }

}