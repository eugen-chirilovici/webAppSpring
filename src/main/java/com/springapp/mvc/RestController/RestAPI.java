package com.springapp.mvc.RestController;

import com.springapp.mvc.dto.DetUserDTO;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/rest/users")
public class RestAPI {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Object> fetchAllUsers() throws Exception {
        return new ResponseEntity<>(userService.getAllUsers(), OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> addUser(@RequestBody DetUserDTO detUserDTO) throws Exception{
        userService.addUser(detUserDTO);
        return new ResponseEntity<>("New User added successfully", CREATED);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody DetUserDTO detUserDTO) throws Exception{
        detUserDTO.setId(id);
        userService.updateUser(detUserDTO);
        return new ResponseEntity<>("User updated successfully", OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> fetchUserById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(userService.getUserById(id), OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUserById(@PathVariable Long id) throws Exception{
        userService.deleteUserById(id);
        return new ResponseEntity<>("User deleted successfully", OK);

    }
}
