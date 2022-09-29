package com.burakenesdemir.basebackend.model.mongo;

import com.burakenesdemir.basebackend.model.base.IdEntity;
import com.burakenesdemir.basebackend.model.dto.UserDTO;
import com.burakenesdemir.basebackend.model.type.RoleEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
@EqualsAndHashCode(callSuper=false)
public class User extends IdEntity {
    private String username;

    private String password;

    private String name;

    private String surname;

    private String phoneNumber;

    private String emailAddress;

    private RoleEnum roleEnum;

    public User(UserDTO.RegisterDto dto){
        username = dto.getUsername();
        password = dto.getPassword();
        name = dto.getFirstName();
        surname = dto.getLastName();
        phoneNumber = dto.getPhone();
        emailAddress = dto.getEmail();
        roleEnum = RoleEnum.DEFAULT_USER;
    }
}
