/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.dao;

import com.supinfo.supfitness.entity.Track;
import javax.ejb.Local;

/**
 *
 * @author Laurent
 */
@Local
public interface TrackDao {
    public void addTrack(Track trackEntity);
}