package com.smart.domain;

public class Permission {
    private  int perId;
    private  String  permissionName;
    private  Role  role;

    public int getPerId() {
        return perId;
    }

    public void setPerId(int perId) {
        this.perId = perId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "perId=" + perId +
                ", permissionName='" + permissionName + '\'' +
                ", role=" + role +
                '}';
    }
}
