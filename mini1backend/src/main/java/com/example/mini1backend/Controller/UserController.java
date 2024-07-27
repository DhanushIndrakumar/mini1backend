package com.example.mini1backend.Controller;

import com.example.mini1backend.DTO.RegisterRequest;
import com.example.mini1backend.DTO.RegisterResponse;
import com.example.mini1backend.DTO.UserResponse;
import com.example.mini1backend.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("register")
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest){
        return userService.registerUser(registerRequest);
    }

    @GetMapping("getUser/{userId}")
    public UserResponse getUserById(@PathVariable int userId){
        return userService.getUserById(userId);
    }

    @GetMapping("getAllUsers")
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("deleteUserById/{userId}")
    public String deleteUserById(@PathVariable int userId){
        return userService.deleteUserById(userId);
    }

    @PutMapping("updateUserById/{userId}")
    public UserResponse updateUserId(@RequestBody RegisterRequest registerRequest,@PathVariable int userId){
        return userService.updateUserById(registerRequest,userId);
    }



}
