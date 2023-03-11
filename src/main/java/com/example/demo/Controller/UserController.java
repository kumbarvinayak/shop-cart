package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class UserController {
@Autowired
    UserService userService;

@PostMapping("/users")
public ResponseEntity<User>CreateUser(@RequestBody User user){
return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
}
@GetMapping("/users/{id}")
    public ResponseEntity<User>getUserById(@PathVariable("id")Long id) {
    return ResponseEntity.ok().body(userService.getUserById(id));
}
@GetMapping("/users")
        public List<User>getAllUsers() {return (List<User>) userService.getAllUsers();}

    @PutMapping("/users/{id}")
    public ResponseEntity<User>UpdateUser(@PathVariable("id")Long id, @RequestBody User user){
      return ResponseEntity.ok(userService.updateUser(id, user));
    }
@DeleteMapping("users/{id}")
public ResponseEntity<String> deleteUser(@PathVariable("id")Long id){
userService.deleteUser(id);
return new ResponseEntity<>("",HttpStatus.NO_CONTENT);
}

}

