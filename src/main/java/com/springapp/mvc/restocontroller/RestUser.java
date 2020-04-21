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
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody UserDTO userDTO) throws CustomUserException {
        userService.addUser(userDTO);
        return new ResponseEntity<>("Status: OK. User was saved.", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable Long id) throws Exception {
        userService.removeUserById(id);
        return new ResponseEntity<>("User was deleted", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserDetails(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUserInformation(@PathVariable Long id, @RequestBody UserDTO userDTO) throws Exception {
        userDTO.setId(id);
        userService.updateUser(userDTO);
        return new ResponseEntity<>("User updated.", HttpStatus.OK);
    }

}
