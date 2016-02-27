/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.dao.jpa;

import com.supinfo.supfitness.dao.TrackDao;
import com.supinfo.supfitness.entity.Track;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Laurent
 */
@Stateless
public class JpaTrackDao implements TrackDao{
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addTrack(Track trackEntity){
        em.persist(trackEntity);
    }
}
