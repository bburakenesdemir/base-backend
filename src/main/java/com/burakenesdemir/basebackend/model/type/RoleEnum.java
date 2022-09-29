package com.burakenesdemir.basebackend.model.type;

public enum RoleEnum {
    DEFAULT_USER("1", "DEFAULT_USER"),
    ADMIN_USER("2", "ADMIN_USER");
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

