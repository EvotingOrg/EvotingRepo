/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.facade;

import com.evoting.entity.Election;
import com.evoting.entity.ElectionCandidate;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author Rajesh Yadav <developerrajeshyadav@gmail.com>
 */
@Stateless
public class ElectionCandidateFacade extends AbstractFacade<ElectionCandidate> {

    @PersistenceContext(unitName = "EvotingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ElectionCandidateFacade() {
        super(ElectionCandidate.class);
    }

    public List<ElectionCandidate> electionCandidateByElection(Election election) {
        List<ElectionCandidate> electionCandidates = new ArrayList<>();
        try {
            Query q = em.createQuery("SELECT ec FROM ElectionCandidate e WHERE e.candidateId=:id");
            q.setParameter("id", election.getId());
            electionCandidates = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return electionCandidates;
    }
}
