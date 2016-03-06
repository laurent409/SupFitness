/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.response;

import java.sql.Date;


/**
 *
 * @author Laurent
 */
public class TrackResponse {
    
    private Double longitude;
    private Double latitude;
    private Double speed;
    private String timestampTrack;

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getTimestampTrack() {
        return timestampTrack;
    }

    public void setTimestampTrack(String timestampTrack) {
        this.timestampTrack = timestampTrack;
    }
    
    
}