/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.facade;

import com.evoting.entity.Election;
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
public class ElectionFacade extends AbstractFacade<Election> {

    @PersistenceContext(unitName = "EvotingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ElectionFacade() {
        super(Election.class);
    }

    public List<Election> selectetValidElections() {
        List<Election> elections = new ArrayList<Election>();
        try {
            Query query = em.createQuery("SELECT e FROM Election e WHERE :date BETWEEN e.fromDate AND e.toDate");
            query.setParameter("date", new Date());
            elections = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elections;
    }

}
