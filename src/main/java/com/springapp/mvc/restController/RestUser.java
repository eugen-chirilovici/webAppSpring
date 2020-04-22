package com.springapp.mvc.restController;

import com.springapp.mvc.dto.UserDTO;
import com.springapp.mvc.dto.UserRegistDTO;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/users")
public class RestUser {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllUser() throws Exception {
        List<User> users = userService.getAllUsers();
        if(users.size() > 0) {
            return new ResponseEntity<>(userService.getAllUsers(), OK);
        }
        return new ResponseEntity<>(NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable Long id) throws Exception {
        User user = userService.getUserById(id);
        if(user != null) {
            return new ResponseEntity<>(user, OK);
        }
        return new ResponseEntity<>(NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id){
        if(userService.deleteUserById(id)) {
            return new ResponseEntity<>(OK);
        }
        else {
            return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addUser(@RequestBody UserRegistDTO userRegistDTO) throws Exception{
        userService.addUser(userRegistDTO);
        return new ResponseEntity<>(OK);
    }

    @PutMapping("/add/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) throws Exception{
        User user = userService.updateUser(id, userDTO);
        if(user != null){
            return new ResponseEntity<>(user, OK);
        }
        return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
    }

}
