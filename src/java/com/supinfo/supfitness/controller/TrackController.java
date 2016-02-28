/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.controller;

import com.supinfo.supfitness.entity.FootRace;
import com.supinfo.supfitness.entity.Track;
import com.supinfo.supfitness.service.TrackService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;

/**
 *
 * @author Laurent
 */
@ManagedBean(name="track")
@RequestScoped
public class TrackController implements Serializable {

    public TrackController(){        
    }
    
    @EJB
    private TrackService trackService;
    
    private Track trackEntity;
    
    private FootRace FootRaceEntity;
    
    private DataModel<Track> trackEntities;

    public TrackService getTrackService() {
        return trackService;
    }

    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }

    public Track getTrackEntity() {
        return trackEntity;
    }

    public void setTrackEntity(Track trackEntity) {
        this.trackEntity = trackEntity;
    }

    public FootRace getFootRaceEntity() {
        return FootRaceEntity;
    }

    public void setFootRaceEntity(FootRace FootRaceEntity) {
        this.FootRaceEntity = FootRaceEntity;
    }

    public DataModel<Track> getTrackEntities() {
        return trackEntities;
    }

    public void setTrackEntities(DataModel<Track> trackEntities) {
        this.trackEntities = trackEntities;
    }
    
    @PostConstruct
    public void init(){
        ExternalContext Ec = FacesContext.getCurrentInstance().getExternalContext();
        FootRaceEntity = (FootRace) Ec.getSessionMap().get("footRaceId");
        List<Track> TrackEntitiesList = trackService.getTracksFromFootRace(FootRaceEntity.getId());
        Track[] trackEntitiesArray = new Track[TrackEntitiesList.size()];
        TrackEntitiesList.toArray(trackEntitiesArray);
        trackEntities = new ArrayDataModel<Track>(trackEntitiesArray);
    }
}
