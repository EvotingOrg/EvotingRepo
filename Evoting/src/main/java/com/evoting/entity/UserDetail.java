/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @Table(name = "elction_candidate", uniqueConstraints =
 * @UniqueConstraint(columnNames = {"election_id", "candidate_id"}))
 *
 * @author Raj
 */
@Entity
@Table(name = "user_detail", uniqueConstraints = @UniqueConstraint(columnNames = {"voter_id"}))
public class UserDetail extends AbstractLongPKEntity {

    @Column(name = "voter_id")
    private String voterId;

    @Column(name = "phone_no")
    private String phoneNo;
    
    @Column(name= "profile_pic")
    private String profilePic;

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    @Embedded
    private Address address;

    public UserDetail() {
    }

    public UserDetail(Address address) {
        this.address = address;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.voterId);
        hash = 17 * hash + Objects.hashCode(this.phoneNo);
        hash = 17 * hash + Objects.hashCode(this.address);
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
        final UserDetail other = (UserDetail) obj;
        if (!Objects.equals(this.voterId, other.voterId)) {
            return false;
        }
        if (!Objects.equals(this.phoneNo, other.phoneNo)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserDetail{" + "voterId=" + voterId + ", phoneNo=" + phoneNo + ", address=" + address + '}';
    }

}
