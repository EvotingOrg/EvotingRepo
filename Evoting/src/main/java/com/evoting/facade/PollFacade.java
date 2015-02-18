/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.facade;

import com.evoting.entity.Poll;
import java.util.ArrayList;
import java.util.Date;
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

    public List<Poll> selectetValidPollings() {
        List<Poll> polls = new ArrayList<Poll>();
        try {
            Query query = em.createQuery("SELECT p FROM Poll p WHERE :date BETWEEN p.fromDate AND p.toDate");
            query.setParameter("date", new Date());
            polls = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return polls;
    }
}
