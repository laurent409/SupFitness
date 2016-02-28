/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.controller;

import com.supinfo.supfitness.entity.FootRace;
import com.supinfo.supfitness.entity.User;
import com.supinfo.supfitness.service.FootRaceService;
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
@ManagedBean(name="footRace")
@RequestScoped
public class FootRaceController implements Serializable{
 
    public FootRaceController(){
    }
    
    @EJB
    private FootRaceService footRaceService;
    
    private FootRace footRaceEntity;
    
    private DataModel<FootRace> footRaceEntities;

    public FootRaceService getFootRaceService() {
        return footRaceService;
    }

    public void setFootRaceService(FootRaceService footRaceService) {
        this.footRaceService = footRaceService;
    }

    public FootRace getFootRaceEntity() {
        return footRaceEntity;
    }

    public void setFootRaceEntity(FootRace footRaceEntity) {
        this.footRaceEntity = footRaceEntity;
    }    
    
    public DataModel<FootRace> getFootRaceEntities() {
        return footRaceEntities;
    }

    public void setFootRaceEntities(DataModel<FootRace> footRaceEntities) {
        this.footRaceEntities = footRaceEntities;
    }
    
    @PostConstruct
    public void init(){
        ExternalContext Ec = FacesContext.getCurrentInstance().getExternalContext();
        User userSession = (User) Ec.getSessionMap().get("userSession");
        List<FootRace> footRaceEntitiesList = footRaceService.getFootRacesFromUser(userSession.getId());
        FootRace[] footRaceEntitiesArray = new FootRace[footRaceEntitiesList.size()];
        footRaceEntitiesList.toArray(footRaceEntitiesArray);
        footRaceEntities = new ArrayDataModel<FootRace>(footRaceEntitiesArray);
    }
    
    public void goToDetails(FootRace footRace){
        try{
            ExternalContext Ec = FacesContext.getCurrentInstance().getExternalContext();
            Ec.getSessionMap().put("footRaceId", footRace);
            redirectAfter(Ec,"details-foot-race.xhtml");
        } catch(Exception e){
            
        }
    }
    
    private void redirectAfter(ExternalContext Ec, String context) {
        try {
            Ec.redirect(Ec.getRequestContextPath()+ "/" + context);
        }
        catch (Exception exeption){
        }
    }        
}
