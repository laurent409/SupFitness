/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.controller;

import com.supinfo.supfitness.entity.User;
import com.supinfo.supfitness.service.UserService;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Laurent
 */
@ManagedBean(name="user")
@RequestScoped
public class UserController implements Serializable{
    
    public UserController() {
    }

    @EJB
    private UserService userService;

    private User user = new User();
    private User userSession;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public User getUserSession() {
        return userSession;
    }

    public void setUserSession(User user) {
        this.userSession = user;
    }

    @PostConstruct
    public void init() {
        ExternalContext Ec = FacesContext.getCurrentInstance().getExternalContext();
        userSession = (User) Ec.getSessionMap().get("userSession");
    }    
    
    public void onLoad() throws IOException {
        ExternalContext Ec = FacesContext.getCurrentInstance().getExternalContext();
        User usr = (User)Ec.getSessionMap().get("userSession");
        if ( usr == null )
            Ec.redirect("sign-in.xhtml");
    }
    
    public void onLoadSign() throws IOException {
        ExternalContext Ec = FacesContext.getCurrentInstance().getExternalContext();
        User usr = (User)Ec.getSessionMap().get("userSession");
        if ( usr != null )
            Ec.redirect("manage.xhtml");
    }
    
    public void logOut() throws IOException {
        ExternalContext Ec = FacesContext.getCurrentInstance().getExternalContext();
        Ec.getSessionMap().remove("userSession");
        Ec.redirect("index.xhtml");
    }
    
    public void signUp() {
        try {
            userService.addUser(user);
            ExternalContext Ec = FacesContext.getCurrentInstance().getExternalContext();
            redirectAfter(Ec,"sign-in.xhtml");
        
        } catch (Exception e) {
        }
    }

    public void signIn() {
        try {
            User userEntity = userService.getUser(user.getUserName(), user.getPassword());
            ExternalContext Ec = FacesContext.getCurrentInstance().getExternalContext();
            if(userEntity == null)
                Ec.redirect("sign-in.xhtml");

            Ec.getSessionMap().put("userSession", userEntity);
            redirectAfter(Ec,"manage.xhtml");
        
        } catch (Exception e) {
        }
    }
    
    public void updateProfile() {
        try {
            userService.updateUser(userSession);
            ExternalContext Ec = FacesContext.getCurrentInstance().getExternalContext();
            redirectAfter(Ec,"manage.xhtml");            
        } catch (Exception e) {
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
