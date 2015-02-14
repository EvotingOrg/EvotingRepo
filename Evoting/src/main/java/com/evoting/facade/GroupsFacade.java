/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.facade;

import com.evoting.entity.Groups;
import com.evoting.entity.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Rajesh Yadav <developerrajeshyadav@gmail.com>
 */
@Stateless
public class GroupsFacade extends AbstractFacade<Groups> {

    @PersistenceContext(unitName = "EvotingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GroupsFacade() {
        super(Groups.class);
    }

    public Groups findByUserName(String userName) {
        Groups userGroup = null;
        try {
            Query query = getEntityManager().createQuery("SELECT g FROM Groups g WHERE g.username:userName");
            query.setParameter("userName", userName);
            userGroup = (Groups) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userGroup;
    }
}
