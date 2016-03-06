/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.ressource;

import com.supinfo.supfitness.entity.FootRace;
import com.supinfo.supfitness.entity.Track;
import com.supinfo.supfitness.entity.User;
import com.supinfo.supfitness.response.DeleteResponse;
import com.supinfo.supfitness.service.FootRaceService;
import com.supinfo.supfitness.service.TrackService;
import com.supinfo.supfitness.service.UserService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Laurent
 */
@Path("/delete")
@Stateless
public class DeleteRessource {

    @EJB
    private UserService userService;
    
    @EJB
    private FootRaceService footRaceService;
    
    @EJB
    private TrackService trackService;
    
    @POST
    @Path("/foot-race")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response DeleteFootRaceTrack(DeleteResponse ressource) {
        User userEntity = userService.getUser(ressource.getUsername(), ressource.getPassword());
        if ( userEntity == null ) {
            return Response.status(401).type("text/plain")
                    .entity("Authentification: Failure").build();
        } else {
            FootRace footRace = footRaceService.getFootRaceById(ressource.getIdFootRace());
            if ( footRace != null ) {
                footRaceService.deleteFootRace(footRace);
                List<Track> trackToDelete = trackService.getTracksFromFootRace(ressource.getIdFootRace());
                for(Track t: trackToDelete){
                    trackService.deleteTrack(t);
                }
            } else {
                return Response.status(401).type("text/plain")
                        .entity("Remove: Failure - Maybe the foot-race doesn't exist").build();
            }
            return Response.status(202).type("text/plain")
                    .entity("Authentification: Success, Remove: Success").build();
        }
    }
    
}
