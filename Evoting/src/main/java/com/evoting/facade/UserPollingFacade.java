/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.evoting.facade;

import com.evoting.entity.UserPolling;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rajesh Yadav <developerrajeshyadav@gmail.com>
 */
@Stateless
public class UserPollingFacade extends AbstractFacade<UserPolling> {
    @PersistenceContext(unitName = "EvotingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserPollingFacade() {
        super(UserPolling.class);
    }

}
