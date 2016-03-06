/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.dao.jpa;

import com.supinfo.supfitness.dao.FootRaceDao;
import com.supinfo.supfitness.entity.FootRace;
import com.supinfo.supfitness.entity.FootRace_;
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
public class JpaFootRaceDao implements FootRaceDao{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Long addFootRace(FootRace footRaceEntity) {
        em.persist(footRaceEntity);
        em.flush();
        return footRaceEntity.getId();
    }
    
    @Override
    public void deleteFootRace(FootRace footRaceEntity) {
        footRaceEntity = em.merge(footRaceEntity);
        em.remove(footRaceEntity);
    }

    @Override
    public List<FootRace> getFootRacesFromUser(Long idCreator) {
        //Query query = em.createQuery("SELECT it FROM Item it WHERE it.idCreator = :idCreator");
        //return (List<Item>) query.setParameter("idCreator", idCreator).getResultList();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<FootRace> query = cb.createQuery(FootRace.class);
        Root<FootRace> root = query.from(FootRace.class);
        List<Predicate> predicate = new ArrayList<>();
        if ( idCreator != null )
            predicate.add(cb.equal(root.get(FootRace_.userId), idCreator));

        query.where(predicate.toArray(new Predicate[predicate.size()]));
        
        try {
            return (List<FootRace>) em.createQuery(query).getResultList();
        } catch (Exception e) {
            return null;
        }               
    
    }
}
