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
    Member("member");

    private String role;

    
    RoleTypeEnum(String role) {
        this.role = role;
    }

}
