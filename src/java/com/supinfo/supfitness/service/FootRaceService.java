/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.service;

import com.supinfo.supfitness.dao.FootRaceDao;
import com.supinfo.supfitness.entity.FootRace;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Laurent
 */
@Stateless
public class FootRaceService {
    
    @EJB
    private FootRaceDao footRaceDao;
    
    public Long addFootRace(FootRace footRaceEntity){
        return footRaceDao.addFootRace(footRaceEntity);
    }
    
    public void deleteFootRace(FootRace footRaceEntity){
        footRaceDao.deleteFootRace(footRaceEntity);
    }
    
    public List<FootRace> getFootRacesFromUser(Long idCreator){
        return footRaceDao.getFootRacesFromUser(idCreator);
    }
    
    public FootRace getFootRaceById(Long idFootRace){
        return footRaceDao.getFootRaceById(idFootRace);
    }
}
