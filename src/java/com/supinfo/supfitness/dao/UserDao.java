/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.dao;

import com.supinfo.supfitness.entity.User;
import javax.ejb.Local;

/**
 *
 * @author Laurent
 */
@Local
public interface UserDao {
    public User GetUser (String username, String password);
    
}
