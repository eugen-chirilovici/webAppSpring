package com.springapp.mvc.restocontroller;


import com.springapp.mvc.dto.UserDTO;
import com.springapp.mvc.exceptionsHandlers.CustomUserException;
import com.springapp.mvc.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Data
@RestController
@RequestMapping("/rest/users")
public class RestUser {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Object> users() throws CustomUserException {
        try {
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomUserException("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody UserDTO userDTO) throws CustomUserException {
        try {
            userService.addUser(userDTO);
            return new ResponseEntity<>("Status: OK. User was saved.", HttpStatus.CREATED);
        }   catch (Exception e) {
            throw new CustomUserException("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable Long id) throws CustomUserException {
        try {
            userService.removeUserById(id);
            return new ResponseEntity<>("User was deleted", HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomUserException("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserDetails(@PathVariable Long id) throws Exception {
        try {
            return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomUserException("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUserInformation(@PathVariable Long id, @RequestBody UserDTO userDTO) throws Exception {
        try {
            userDTO.setId(id);
            userService.updateUser(userDTO);
            return new ResponseEntity<>("User updated.", HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomUserException("Error", HttpStatus.BAD_REQUEST);
        }
    }

}
