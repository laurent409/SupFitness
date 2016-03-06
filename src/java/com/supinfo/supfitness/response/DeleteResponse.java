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
public class DeleteResponse {
    
    private String username;
    private String password;
    private Long idFootRace;

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

    public Long getIdFootRace() {
        return idFootRace;
    }

    public void setIdFootRace(Long idFootRace) {
        this.idFootRace = idFootRace;
    }
        
}
