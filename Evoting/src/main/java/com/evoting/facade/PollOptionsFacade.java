/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.facade;

import com.evoting.entity.Poll;
import com.evoting.entity.PollOptions;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Rajesh Yadav <developerrajeshyadav@gmail.com>
 */
@Stateless
public class PollOptionsFacade extends AbstractFacade<PollOptions> {

    @PersistenceContext(unitName = "EvotingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PollOptionsFacade() {
        super(PollOptions.class);
    }

    public List<PollOptions> getPollOptionsByPoll(Poll poll) {
        List<PollOptions> pollOptions = new ArrayList<PollOptions>();
        try {
            Query query = em.createQuery("SELECT p FROM PollOptions p WHERE p.pollId=:pollId");
            query.setParameter("pollId", poll.getId());
            pollOptions = query.getResultList();
        } catch (Exception e) {
        }
        return pollOptions;
    }

}
