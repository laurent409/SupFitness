/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.service;

import com.supinfo.supfitness.dao.TrackDao;
import com.supinfo.supfitness.entity.Track;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Laurent
 */
@Stateless
public class TrackService {
    
    @EJB
    private TrackDao trackDao;
    
    public void addTrack(Track trackEntity){
        trackDao.addTrack(trackEntity);
    }
    
    public void deleteTrack(Track trackEntity){
        trackDao.deleteTrack(trackEntity);
    }
    
    public List<Track> getTracksFromFootRace(Long idFootRace){
       return trackDao.getTracksFromFootRace(idFootRace);
    }
    
}
