/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.entity;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Raj
 */
@Entity
@Table(name = "product")
public class Product extends AbstractLongPKEntity {

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    private Category categoryId;

    @Column(name = "product_name")
    @NotNull
    private String productName;

    @Column(name = "release_publish_date")
    @Temporal(TemporalType.DATE)
    private Date distributionDate;

    @Column(name = "rating")
    private Double avgRating;

    @OneToMany(mappedBy = "productId")
    @LazyCollection(LazyCollectionOption.TRUE)
    private Collection<UserRating> userRatings;

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getDistributionDate() {
        return distributionDate;
    }

    public void setDistributionDate(Date distributionDate) {
        this.distributionDate = distributionDate;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    public Collection<UserRating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(Collection<UserRating> userRatings) {
        this.userRatings = userRatings;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.categoryId);
        hash = 89 * hash + Objects.hashCode(this.productName);
        hash = 89 * hash + Objects.hashCode(this.distributionDate);
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
        final Product other = (Product) obj;
        if (!Objects.equals(this.categoryId, other.categoryId)) {
            return false;
        }
        if (!Objects.equals(this.productName, other.productName)) {
            return false;
        }
        if (!Objects.equals(this.distributionDate, other.distributionDate)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "categoryId=" + categoryId + ", productName=" + productName + ", releasePublishDate=" + distributionDate + ", avgRating=" + avgRating + '}';
    }

}
