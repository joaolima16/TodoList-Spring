package app.todolist.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.todolist.domain.user.LoginDTO;
import app.todolist.domain.user.User;
import app.todolist.domain.user.UserDTO;
import app.todolist.domain.user.UserRepository;

@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserDTO userDTO) {
        User user = new User(userDTO);
        userRepository.save(user);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userRepository.findAll());
    }


    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody LoginDTO loginDTO){

        List<UserDetails> users = userRepository.findByPassword(loginDTO.password().trim());

        System.out.println(loginDTO.password().trim());
        return ResponseEntity.ok().body(users.get(0));
    }
}

