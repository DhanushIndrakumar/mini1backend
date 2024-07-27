package com.example.mini1backend.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="Employee")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @NotBlank(message = "User first name is mandatory")
    private String userFirstName;

    @NotBlank(message = "User last name is mandatory")
    private String userLastName;

    @NotBlank(message = "User email is mandatory")
    @Email(message = "Email should be valid")
    private String userEmail;

    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number should be 10 digits")
    private String phone;



}
