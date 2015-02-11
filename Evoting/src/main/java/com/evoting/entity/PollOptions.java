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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Raj
 */
@Entity
@Table(name = "poll_options", uniqueConstraints = @UniqueConstraint(columnNames = {"poll_id", "option_name"}))
public class PollOptions extends AbstractLongPKEntity {

    @ManyToOne
    @JoinColumn(name = "poll_id", referencedColumnName = "id")
    private Poll pollId;

    @Column(name = "option_name")
    private String optionName;

    @Column(name = "total_count")
    private Integer totalCount;

    @Column(name = "result")
    private Integer result;

    @OneToMany(mappedBy = "pollOptionId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<UserPolling> userPollings;

    public Poll getPollId() {
        return pollId;
    }

    public void setPollId(Poll pollId) {
        this.pollId = pollId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Collection<UserPolling> getUserPollings() {
        return userPollings;
    }

    public void setUserPollings(Collection<UserPolling> userPollings) {
        this.userPollings = userPollings;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.pollId);
        hash = 97 * hash + Objects.hashCode(this.optionName);
        hash = 97 * hash + Objects.hashCode(this.totalCount);
        hash = 97 * hash + Objects.hashCode(this.result);
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
        final PollOptions other = (PollOptions) obj;
        if (!Objects.equals(this.pollId, other.pollId)) {
            return false;
        }
        if (!Objects.equals(this.optionName, other.optionName)) {
            return false;
        }
        if (!Objects.equals(this.totalCount, other.totalCount)) {
            return false;
        }
        if (!Objects.equals(this.result, other.result)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PollOptions{" + "pollId=" + pollId + ", optionName=" + optionName + ", totalCount=" + totalCount + ", result=" + result + '}';
    }
}
