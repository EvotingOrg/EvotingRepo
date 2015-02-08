/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 *
 * @author Raj
 */
@Entity
@Table(name = "category")
public class Category extends AbstractLongPKEntity {

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private CategoryTypeEnum category;

    public CategoryTypeEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryTypeEnum category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.category);
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
        final Category other = (Category) obj;
        if (this.category != other.category) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Category{" + "category=" + category + '}';
    }

}
