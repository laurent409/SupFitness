/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.dao.jpa;

import com.supinfo.supfitness.dao.TrackDao;
import com.supinfo.supfitness.entity.Track;
import com.supinfo.supfitness.entity.Track_;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

    @Override
    public List<Track> getTracksFromFootRace(Long idFootRace) {
        //Query query = em.createQuery("SELECT it FROM Item it WHERE it.idCreator = :idCreator");
        //return (List<Item>) query.setParameter("idCreator", idCreator).getResultList();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Track> query = cb.createQuery(Track.class);
        Root<Track> root = query.from(Track.class);
        List<Predicate> predicate = new ArrayList<>();
        if ( idFootRace != null )
            predicate.add(cb.equal(root.get(Track_.footRaceId), idFootRace));

        query.where(predicate.toArray(new Predicate[predicate.size()]));
        
        try {
            return (List<Track>) em.createQuery(query).getResultList();
        } catch (Exception e) {
            return null;
        }               
    }
}
