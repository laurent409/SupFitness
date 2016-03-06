/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.ressource;

import com.supinfo.supfitness.entity.FootRace;
import com.supinfo.supfitness.entity.Track;
import com.supinfo.supfitness.entity.User;
import com.supinfo.supfitness.response.AddResponse;
import com.supinfo.supfitness.response.FootRaceResponse;
import com.supinfo.supfitness.response.TrackResponse;
import com.supinfo.supfitness.service.FootRaceService;
import com.supinfo.supfitness.service.TrackService;
import com.supinfo.supfitness.service.UserService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
 

/**
 *
 * @author Laurent
 */
@Path("/api")
@Stateless
public class AddRessource {
    
    @EJB
    private UserService userService;
    
    @EJB
    private FootRaceService footRaceService;
    
    @EJB
    private TrackService trackService;
    
    @POST
    @Path("/add-foot-race")
    @Consumes(MediaType.APPLICATION_JSON)
    public String AddFootRaceTrack(AddResponse ressource) {
        User userEntity = userService.getUser(ressource.getUsername(), ressource.getPassword());
        if ( userEntity == null ) {
            return "Wrong username of wrong password";
        } else {
            FootRaceResponse footRaceResponse = ressource.getFootRace();
            
            FootRace footRace = new FootRace();
            footRace.setName(footRaceResponse.getName());
            footRace.setSpeedAverage(footRaceResponse.getSpeedAverage());
            footRace.setUserId(userEntity.getId());
            
            Long footRaceId = footRaceService.addFootRace(footRace);
            
            for(TrackResponse t : ressource.getTrack()){
                TrackResponse trackResponse = t;
                
                Track track = new Track();
                track.setLatitude(trackResponse.getLatitude());
                track.setLongitude(trackResponse.getLongitude());
                track.setSpeed(trackResponse.getSpeed());
                track.setTimestamp(trackResponse.getTimestampTrack());
                track.setFootRaceId(footRaceId);
                
                trackService.addTrack(track);
            }
            return "Success add !";
        }        
    }
}
