/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.facade;

import com.evoting.entity.Poll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Raj
 */
@Stateless
public class PollFacade extends AbstractFacade<Poll> {
    @PersistenceContext(unitName = "EvotingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PollFacade() {
        super(Poll.class);
    }
    
}
