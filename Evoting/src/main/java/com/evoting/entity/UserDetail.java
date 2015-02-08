/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.entity;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Raj
 */
@Entity
@Table(name = "user_detail")
public class UserDetail extends AbstractLongPKEntity {

    @Column(name = "voter_id")
    private String voterId;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_detail")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Address addressId;

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.voterId);
        hash = 47 * hash + Objects.hashCode(this.addressId);
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
        if (!Objects.equals(this.addressId, other.addressId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserDetail{" + "voterId=" + voterId + ", addressId=" + addressId + '}';
    }
}
