/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.dao.jpa;

import com.supinfo.supfitness.dao.UserDao;
import com.supinfo.supfitness.entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Laurent
 */
@Stateless
public class JpaUserDao implements UserDao{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addUser(User userEntity) {
        em.persist(userEntity);
    }
    
    @Override
    public void updateUser(User user) {
        em.merge(user);
    }
   
    @Override
    public User getUser(String userName, String password) {     
        
        Query query = em.createQuery("SELECT u FROM User u WHERE u.userName= :username AND u.password= :password");
        query.setParameter("username", userName);        
        query.setParameter("password", password);
        
        try {
            User usr = (User) query.getSingleResult();
            return usr;
        }
        catch (NoResultException exeption) {
            exeption.printStackTrace();
            return null;
        }

    }
    
}
