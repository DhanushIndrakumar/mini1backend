package com.example.mini1backend.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserResponse {

    private int userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String phone;
}
