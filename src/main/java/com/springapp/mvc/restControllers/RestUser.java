package com.springapp.mvc.restControllers;

import com.springapp.mvc.dto.UserDTO;
import com.springapp.mvc.exceptionHandler.ExceptionsHandler;
import com.springapp.mvc.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/users")
public class RestUser {

    @Autowired
    private  UserService userService;

    @Autowired
    private ExceptionsHandler exceptionsHandler;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Object> users() throws Exception {
        return new ResponseEntity<>(userService.getAllUsers(), OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody UserDTO userDTO) throws Exception {
        userService.addUser(userDTO);
        return new ResponseEntity<>("User was saved successfully", CREATED);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> remove(@PathVariable Long id) throws Exception {
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted", OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserDetails(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(userService.getUserById(id), OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUserDetails(@PathVariable Long id, @RequestBody UserDTO userDTO) throws Exception {
        userDTO.setId(id);
        userService.updateUser(userDTO);
        return new ResponseEntity<>("User updated successfully", OK);
    }
}
