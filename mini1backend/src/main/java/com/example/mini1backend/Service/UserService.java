package com.example.mini1backend.Service;

import com.example.mini1backend.DTO.RegisterRequest;
import com.example.mini1backend.DTO.RegisterResponse;
import com.example.mini1backend.DTO.UserResponse;
import com.example.mini1backend.Entities.User;
import com.example.mini1backend.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public RegisterResponse registerUser(RegisterRequest registerRequest) {
        User user=new User();
        user.setUserFirstName(registerRequest.getUserFirstName());
        user.setUserLastName(registerRequest.getUserLastName());
        user.setUserEmail(registerRequest.getUserEmail());
        user.setPhone(registerRequest.getPhone());
        userRepository.save(user);
        RegisterResponse registerResponse=new RegisterResponse();
        registerResponse.setUserId(user.getUserId());
        registerResponse.setUserFirstName(user.getUserFirstName());
        return  registerResponse;

    }

    public UserResponse getUserById(int userId) {
        User user= userRepository.findById(userId).get();
        UserResponse userResponse=new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setUserFirstName(user.getUserFirstName());
        userResponse.setUserLastName(user.getUserLastName());
        userResponse.setUserEmail(user.getUserEmail());
        userResponse.setPhone(user.getPhone());
        return userResponse;
    }

    public List<UserResponse> getAllUsers() {
        List<User> userList=userRepository.findAll();
        List<UserResponse> userResponseList=new ArrayList<>();
        for(User user:userList){
            UserResponse userResponse=new UserResponse();
            userResponse.setUserId(user.getUserId());
            userResponse.setUserFirstName(user.getUserFirstName());
            userResponse.setUserLastName(user.getUserLastName());
            userResponse.setUserEmail(user.getUserEmail());
            userResponse.setPhone(user.getPhone());
            userResponseList.add(userResponse);
        }
        return userResponseList;
    }

    public String deleteUserById(int userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(userId);
            return "User successfully deleted";
        } else {
            return "User not found";
        }
    }

    public UserResponse updateUserById(RegisterRequest registerRequest, int userId) {
       User user=userRepository.findById(userId).orElseThrow();
       user.setUserFirstName(registerRequest.getUserFirstName());
       user.setUserLastName(registerRequest.getUserLastName());
       user.setUserEmail(registerRequest.getUserEmail());
       user.setPhone(registerRequest.getPhone());
       userRepository.save(user);
       UserResponse userResponse=new UserResponse();
       userResponse.setUserId(user.getUserId());
       userResponse.setUserFirstName(user.getUserFirstName());
       userResponse.setUserLastName(user.getUserLastName());
       userResponse.setUserEmail(user.getUserEmail());
       userResponse.setPhone(user.getPhone());
       return userResponse;
    }
}
