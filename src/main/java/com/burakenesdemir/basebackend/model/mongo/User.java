package com.burakenesdemir.basebackend.model.mongo;

import com.burakenesdemir.basebackend.model.base.IdEntity;
import com.burakenesdemir.basebackend.model.type.RoleEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
@NoArgsConstructor
public class User extends IdEntity {
    private String username;

    private String password;

    private String name;

    private String surname;

    private String phoneNumber;

    private String emailAddress;

    private RoleEnum role;
}
