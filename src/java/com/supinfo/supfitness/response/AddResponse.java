/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.response;

import java.util.List;


/**
 *
 * @author Laurent
 */
public class AddResponse {
    
    private String username;
    private String password;
    private FootRaceResponse footRace;
    private List<TrackResponse> track;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public FootRaceResponse getFootRace() {
        return footRace;
    }

    public void setFootRace(FootRaceResponse footRace) {
        this.footRace = footRace;
    }

    public List<TrackResponse> getTrack() {
        return track;
    }

    public void setTrack(List<TrackResponse> track) {
        this.track = track;
    }

}
