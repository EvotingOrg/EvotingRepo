package com.evoting.entity;

import java.io.Serializable;

public interface PersistentEntity<PK extends Serializable> extends Serializable {

    PK getId();

    boolean isNew();

    public void setId(PK id);
}
