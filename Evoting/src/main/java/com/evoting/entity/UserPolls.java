/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.entity;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Raj
 */
@Entity
@Table(name = "user_polls")
public class UserPolls extends AbstractLongPKEntity {

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    @JoinColumn(name = "poll_option_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PollOptions pollOptionId;

    @JoinColumn(name = "poll_id", referencedColumnName = "id")
    private Poll pollId;

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.userId);
        hash = 79 * hash + Objects.hashCode(this.pollOptionId);
        hash = 79 * hash + Objects.hashCode(this.pollId);
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
        final UserPolls other = (UserPolls) obj;
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        if (!Objects.equals(this.pollOptionId, other.pollOptionId)) {
            return false;
        }
        if (!Objects.equals(this.pollId, other.pollId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserPolls{" + "userId=" + userId + ", pollOptionId=" + pollOptionId + ", pollId=" + pollId + '}';
    }
}
