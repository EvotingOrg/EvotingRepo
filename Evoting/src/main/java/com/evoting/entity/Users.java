/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.entity;

import java.util.Collection;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Raj
 */
@Entity
@Table(name = "users")
public class Users extends AbstractLongPKEntity {

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_detail_id")
    @LazyCollection(LazyCollectionOption.FALSE)
    private UserDetail userDetail;

    @OneToMany(mappedBy = "userId")
    @LazyCollection(LazyCollectionOption.TRUE)
    private Collection<UserVoting> userVotings;

    @OneToMany(mappedBy = "userId")
    @LazyCollection(LazyCollectionOption.TRUE)
    private Collection<UserPolling> userPollings;

    private transient String confirmPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public Collection<UserVoting> getUserVotings() {
        return userVotings;
    }

    public void setUserVotings(Collection<UserVoting> userVotings) {
        this.userVotings = userVotings;
    }

    public Collection<UserPolling> getUserPollings() {
        return userPollings;
    }

    public void setUserPollings(Collection<UserPolling> userPollings) {
        this.userPollings = userPollings;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.userName);
        hash = 17 * hash + Objects.hashCode(this.password);
        hash = 17 * hash + Objects.hashCode(this.userDetail);
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
        final Users other = (Users) obj;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.userDetail, other.userDetail)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getUserName();
    }
}
