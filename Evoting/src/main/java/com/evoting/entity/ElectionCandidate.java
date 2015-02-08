/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Raj
 */
@Entity
@Table(name = "elction_candidate")
public class ElectionCandidate extends AbstractLongPKEntity {

    @JoinColumn(name = "election_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Election electionId;

    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    @ManyToOne
    private Candidate candidateId;

    @Column(name = "party")
    private String party;

    @Column(name = "constituency_state")
    private String constituencyState;

    @Column(name = "post")
    @NotNull
    private String post;

    public Election getElectionId() {
        return electionId;
    }

    public void setElectionId(Election electionId) {
        this.electionId = electionId;
    }

    public Candidate getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Candidate candidateId) {
        this.candidateId = candidateId;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getConstituencyState() {
        return constituencyState;
    }

    public void setConstituencyState(String constituencyState) {
        this.constituencyState = constituencyState;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.electionId);
        hash = 17 * hash + Objects.hashCode(this.candidateId);
        hash = 17 * hash + Objects.hashCode(this.party);
        hash = 17 * hash + Objects.hashCode(this.constituencyState);
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
        final ElectionCandidate other = (ElectionCandidate) obj;
        if (!Objects.equals(this.electionId, other.electionId)) {
            return false;
        }
        if (!Objects.equals(this.candidateId, other.candidateId)) {
            return false;
        }
        if (!Objects.equals(this.party, other.party)) {
            return false;
        }
        if (!Objects.equals(this.constituencyState, other.constituencyState)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ElectionCandidate{" + "electionId=" + electionId + ", candidateId=" + candidateId + ", party=" + party + ", constituencyState=" + constituencyState + '}';
    }

}
