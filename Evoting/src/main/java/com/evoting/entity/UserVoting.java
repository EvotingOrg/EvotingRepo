/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
//
//@Table(name = "member_group", uniqueConstraints
//        = @UniqueConstraint(columnNames = {"center_info_id", "memberGroup_code"}))

/**
 *
 * @author Rajesh Yadav <developerrajeshyadav@gmail.com>
 */
@Entity
@Table(name = "user_voting", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "election_candidate"}))
public class UserVoting extends AbstractLongPKEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userId;

    @ManyToOne
    @JoinColumn(name = "election_candidate")
    private ElectionCandidate electionCandidateId;

    @Temporal(TemporalType.DATE)
    private Date voteCastedTime;

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public ElectionCandidate getElectionCandidateId() {
        return electionCandidateId;
    }

    public void setElectionCandidateId(ElectionCandidate electionCandidateId) {
        this.electionCandidateId = electionCandidateId;
    }

    public Date getVoteCastedTime() {
        return voteCastedTime;
    }

    public void setVoteCastedTime(Date voteCastedTime) {
        this.voteCastedTime = voteCastedTime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.userId);
        hash = 97 * hash + Objects.hashCode(this.electionCandidateId);
        hash = 97 * hash + Objects.hashCode(this.voteCastedTime);
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
        final UserVoting other = (UserVoting) obj;
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        if (!Objects.equals(this.electionCandidateId, other.electionCandidateId)) {
            return false;
        }
        if (!Objects.equals(this.voteCastedTime, other.voteCastedTime)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserVoting{" + "userId=" + userId + ", electionCandidateId=" + electionCandidateId + ", voteCastedTime=" + voteCastedTime + '}';
    }

}
