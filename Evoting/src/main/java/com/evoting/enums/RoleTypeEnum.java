/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.enums;

/**
 *
 * @author Raj
 */
public enum RoleTypeEnum {

    Admin("admin"),
    User("user");

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    RoleTypeEnum(String role) {
        this.role = role;
    }

}
