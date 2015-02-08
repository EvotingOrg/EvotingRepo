/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.facade;

import com.evoting.entity.UserPolls;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Raj
 */
@Stateless
public class UserPollsFacade extends AbstractFacade<UserPolls> {
    @PersistenceContext(unitName = "EvotingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserPollsFacade() {
        super(UserPolls.class);
    }
    
}
