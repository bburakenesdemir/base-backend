package com.burakenesdemir.basebackend.model.type;

public class RoleEnum {
    public static final String DEFAULT_USER = "1";

    private final String roleName;
    private final String roleId;

    RoleEnum(String roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }
}

