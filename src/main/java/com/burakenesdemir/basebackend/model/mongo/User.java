package com.burakenesdemir.basebackend.model.mongo;

import com.burakenesdemir.basebackend.model.base.IdEntity;
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

    private String email;

    private RoleEnum roleEnum;
}