/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.dao;

import com.supinfo.supfitness.entity.FootRace;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Laurent
 */
@Local
public interface FootRaceDao {
    public void addFootRace(FootRace footRaceEntity);
    public void deleteFootRace(FootRace footRaceEntity);
    public List<FootRace> getFootRacesFromUser(Long idCreator);
}
