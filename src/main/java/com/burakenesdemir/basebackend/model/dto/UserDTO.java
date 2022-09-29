package com.burakenesdemir.basebackend.model.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public interface UserDTO {

    @Data
    class RegisterDto {
        @NotEmpty(message = "Username not be null!")
        private String username;
        @NotEmpty(message = "Email not be null!")
        private String email;
        private String password;
        private String passwordConfirmation;
        @NotEmpty(message = "Name field not be null!")
        private String firstName;
        @NotEmpty(message = "Lastname field not be null!")
        private String lastName;
        @Pattern(regexp = "[0-9\\s]{10}")
        private String phone;
    }

    @Data
    class LoginDto {
        private String username;
        private String password;
    }

    @Data
    class UpdatePasswordDto {
        private String currentPassword;
        private String newPassword;
    }

    @Data
    class UpdateEmailDto {
        private String currentEmail;
        private String newEmail;
    }

    @Data
    class UpdateUsernameDto {
        private String currentUsername;
        private String newUsername;
    }

    @Data
    class ChangePasswordDto {
        private String currentPassword;
        private String newPassword;
    }

    @Data
    class ChangeEmailDto {
        private String currentEmail;
        private String newEmail;
    }
}
