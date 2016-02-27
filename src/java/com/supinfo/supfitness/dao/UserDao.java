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
    public void addUser(User userEntity);
    public void updateUser(User userEntity);
    public User GetUser (String userName, String password);
}
