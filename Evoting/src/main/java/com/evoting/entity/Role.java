/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.entity;

import com.evoting.enums.RoleTypeEnum;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 *
 * @author Raj
 */
@Entity
@Table(name = "roles")
public class Role extends AbstractLongPKEntity {

    @Enumerated(EnumType.STRING)
    private RoleTypeEnum roletype;

    public RoleTypeEnum getRoletype() {
        return roletype;
    }

    public void setRoletype(RoleTypeEnum roletype) {
        this.roletype = roletype;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.roletype);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Role other = (Role) obj;
        if (this.roletype != other.roletype) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Role{" + "roletype=" + roletype + '}';
    }

}
