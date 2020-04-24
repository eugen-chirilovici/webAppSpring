package com.springapp.mvc.restcontrollers;

import com.springapp.mvc.dto.UserRestDTO;
import com.springapp.mvc.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
     private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllUsersRest(){
        return new ResponseEntity<>(userService.getAllUsers(), OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserByIdRest(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUserById(id),OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> addUserRest(@RequestBody UserRestDTO userRestDTO){
        userService.createUser(userRestDTO);
        return new ResponseEntity <>("User saved",CREATED);
    }

    @RequestMapping(value = "/user/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUserByIdRest(@PathVariable Long id, @RequestBody UserRestDTO userRestDTO){
        userService.updateUser(userRestDTO, id);
        return new ResponseEntity<>("User updated", OK);
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUserRest (@PathVariable Long id){
        userService.deleteUser(userService.getUserById(id));
        return new ResponseEntity<>("User deleted", OK);
    }

}
