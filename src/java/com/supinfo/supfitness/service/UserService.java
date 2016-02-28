/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.service;

import com.supinfo.supfitness.dao.UserDao;
import com.supinfo.supfitness.entity.User;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Laurent
 */
@Stateless
public class UserService {
    
    @EJB
    private UserDao userDao;
    
    public void addUser(User userEntity){
        userDao.addUser(userEntity);
    }
    
    public void updateUser(User userEntity){
        userDao.updateUser(userEntity);
    }
    
    public User getUser(String username, String password){
        return userDao.getUser(username, password);
    }
}
