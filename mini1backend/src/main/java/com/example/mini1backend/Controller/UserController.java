package com.example.mini1backend.Controller;

import com.example.mini1backend.DTO.RegisterRequest;
import com.example.mini1backend.DTO.RegisterResponse;
import com.example.mini1backend.DTO.UserResponse;
import com.example.mini1backend.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
@Tag(name="User Operations")
public class UserController {

    private final UserService userService;


    @Operation(
            description = "End point to register a user",
            summary="A user can register by providing the required details"
    )
    @PostMapping("register")
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest){
        return userService.registerUser(registerRequest);
    }

    @Operation(
            description = "End point to retrieve  a user",
            summary="A user can retrieve the details by providing the userId"
    )
    @GetMapping("getUser/{userId}")
    public UserResponse getUserById(@PathVariable int userId){
        return userService.getUserById(userId);
    }

    @Operation(
            description = "End point to retrieve  all users",
            summary="All the user information can be retrieved"
    )
    @GetMapping("getAllUsers")
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }

    @Operation(
            description = "End point to delete a single user",
            summary="A particular user can be removed by providing the userId"
    )
    @DeleteMapping("deleteUserById/{userId}")
    public String deleteUserById(@PathVariable int userId){
        return userService.deleteUserById(userId);
    }

    @Operation(
            description = "End point to update the details of a user",
            summary="A particular user details can be updated by providing the userId and new details of the user"
    )
    @PutMapping("updateUserById/{userId}")
    public UserResponse updateUserId(@RequestBody RegisterRequest registerRequest,@PathVariable int userId){
        return userService.updateUserById(registerRequest,userId);
    }



}
