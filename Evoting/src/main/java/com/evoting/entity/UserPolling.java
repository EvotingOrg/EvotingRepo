/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.entity;

import com.evoting.controller.util.SessionBean;
import static com.evoting.entity.Candidate_.name;
import java.util.Date;
import java.util.Objects;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Raj
 */
@Entity
@Table(name = "user_polls", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "poll_id", "poll_option_id"}))
public class UserPolling extends AbstractLongPKEntity {
    
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private Users userId;
    
    @JoinColumn(name = "poll_id", referencedColumnName = "id")
    @ManyToOne
    private Poll pollId;
    
    @JoinColumn(name = "poll_option_id", referencedColumnName = "id")
    @ManyToOne
    private PollOptions pollOptionId;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "polled_date")
    private Date pollingTime;
    
    public Users getUserId() {
        return userId;
    }
    
    public void setUserId(Users userId) {
        this.userId = userId;
    }
    
    public PollOptions getPollOptionId() {
        return pollOptionId;
    }
    
    public void setPollOptionId(PollOptions pollOptionId) {
        this.pollOptionId = pollOptionId;
    }
    
    public Poll getPollId() {
        return pollId;
    }
    
    public void setPollId(Poll pollId) {
        this.pollId = pollId;
    }
    
    public Date getPollingTime() {
        return pollingTime;
    }
    
    public void setPollingTime(Date pollingTime) {
        this.pollingTime = pollingTime;
    }
    
    @Inject
    SessionBean sessionBean;
    
    @PrePersist
    public void init() {
        this.setUserId(sessionBean.getCurrentUser());
        this.setPollingTime(new Date());
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.userId);
        hash = 97 * hash + Objects.hashCode(this.pollId);
        hash = 97 * hash + Objects.hashCode(this.pollOptionId);
        hash = 97 * hash + Objects.hashCode(this.pollingTime);
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
        final UserPolling other = (UserPolling) obj;
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        if (!Objects.equals(this.pollId, other.pollId)) {
            return false;
        }
        if (!Objects.equals(this.pollOptionId, other.pollOptionId)) {
            return false;
        }
        if (!Objects.equals(this.pollingTime, other.pollingTime)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "UserPolling{" + "userId=" + userId + ", pollId=" + pollId + ", pollOptionId=" + pollOptionId + ", pollingTime=" + pollingTime + '}';
    }
    
}
