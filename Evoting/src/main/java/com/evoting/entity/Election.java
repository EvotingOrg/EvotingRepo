/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.entity;

import java.util.Collection;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Raj
 */
@Entity
@Table(name = "election")
public class Election extends AbstractLongPKEntity {

    @Column(name = "election_name")
    private String electionName;
    @Column(name = "descrition")
    private String description;
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ElectionCandidate> elctionCandidates;

    public String getElectionName() {
        return electionName;
    }

    public void setElectionName(String electionName) {
        this.electionName = electionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<ElectionCandidate> getElctionCandidates() {
        return elctionCandidates;
    }

    public void setElctionCandidates(Collection<ElectionCandidate> elctionCandidates) {
        this.elctionCandidates = elctionCandidates;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.electionName);
        hash = 79 * hash + Objects.hashCode(this.description);
        hash = 79 * hash + Objects.hashCode(this.elctionCandidates);
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
        final Election other = (Election) obj;
        if (!Objects.equals(this.electionName, other.electionName)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.elctionCandidates, other.elctionCandidates)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Election{" + "electionName=" + electionName + ", description=" + description + ", elctionCandidates=" + elctionCandidates + '}';
    }

}
