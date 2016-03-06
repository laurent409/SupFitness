/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.response;

/**
 *
 * @author Laurent
 */
public class FootRaceResponse {
    
    private String name;
    private Double speedAverage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSpeedAverage() {
        return speedAverage;
    }

    public void setSpeedAverage(Double speedAverage) {
        this.speedAverage = speedAverage;
    }
     
}