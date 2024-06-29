package br.com.barbearia.sistema.service;

import br.com.barbearia.sistema.model.User;
import br.com.barbearia.sistema.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User loginUser(String username, String password){
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent() && passwordEncoder.matches(password, optionalUser.get().getPassword())){
            return optionalUser.get();
        } else {
            throw new RuntimeException("Credencial Invalida");
        }
    }
}
