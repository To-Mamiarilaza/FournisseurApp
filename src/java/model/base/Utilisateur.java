/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.base;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;

/**
 *
 * @author To Mamiarilaza
 */
@DBTable(name = "utilisateur", sequenceName = "seq_utilisateur")
public class Utilisateur {
    // Field
    @DBField(name = "id_utilisateur", isPrimaryKey = true)
    int idUtilisateur;
    
    @DBField(name = "id_society", isForeignKey = true)
    Society society;
    
    @DBField(name = "username")
    String username;
    
    @DBField(name = "password")
    String password;
    
    @DBField(name = "mail")
    String mail;
    
    @DBField(name = "photo")
    String photo;
    
    @DBField(name = "status")
    int status;
    
    // Getter and Setter

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Society getSociety() {
        return society;
    }

    public void setSociety(Society society) {
        this.society = society;
    }

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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    // Constructor

    public Utilisateur() {
    }

    public Utilisateur(Society society, String username, String password, String mail, String photo, int status) {
        this.society = society;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.photo = photo;
        this.status = status;
    }

    public Utilisateur(int idUtilisateur, Society society, String username, String password, String mail, String photo, int status) {
        this.idUtilisateur = idUtilisateur;
        this.society = society;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.photo = photo;
        this.status = status;
    }
    
}
