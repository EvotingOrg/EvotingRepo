/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.entity;

import com.evoting.enums.RoleTypeEnum;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Rajesh Yadav <developerrajeshyadav@gmail.com>
 */
@Entity
@Table(name = "groups", uniqueConstraints = @UniqueConstraint(columnNames = {"username", "groupname"}))
public class Groups extends AbstractLongPKEntity {

    @Column(name = "username")
    private String userName;

    @Enumerated(EnumType.STRING)
    @Column(name = "groupname")
    private RoleTypeEnum groupName;

    public Groups() {
    }

    public Groups(String userName, RoleTypeEnum groupName) {
        this.userName = userName;
        this.groupName = groupName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public RoleTypeEnum getGroupName() {
        return groupName;
    }

    public void setGroupName(RoleTypeEnum groupName) {
        this.groupName = groupName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.userName);
        hash = 59 * hash + Objects.hashCode(this.groupName);
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
        final Groups other = (Groups) obj;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.groupName, other.groupName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Groups{" + "userName=" + userName + ", groupName=" + groupName + '}';
    }

}
