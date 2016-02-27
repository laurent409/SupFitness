/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.dao.jpa;

import com.supinfo.supfitness.dao.FootRaceDao;
import com.supinfo.supfitness.entity.FootRace;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Laurent
 */
@Stateless
public class JpaFootRaceDao implements FootRaceDao{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addFootRace(FootRace footRaceEntity) {
        em.persist(footRaceEntity);
    }
}
