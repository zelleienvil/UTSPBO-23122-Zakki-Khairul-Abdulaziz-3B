/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.pbo;

/**
 *
 * @author kurohana
 */
public class Login{
    private String username;
    private String password;
    
    public Login(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public String cekUser(){        
        if ("admin".equals(this.username) && "inipassword123".equals(this.password)){
            return "admin";
        } else {
            return "customer";
        }
    }
}
