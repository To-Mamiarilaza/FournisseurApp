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
@DBTable(name = "society", sequenceName = "seq_society")
public class Society {

    // Field
    @DBField(name = "id_society", isPrimaryKey = true)
    int idSociety;

    @DBField(name = "society_name")
    String society;

    @DBField(name = "society_address")
    String societyAdresse;

    @DBField(name = "responsable_contact")
    String responsableContact;

    @DBField(name = "mail")
    String mail;

    @DBField(name = "status")
    int status;

//Getter and setter
    public int getIdSociety() {
        return idSociety;
    }

    public void setIdSociety(int idSociety) {
        this.idSociety = idSociety;
    }

    public String getSociety() {
        return society;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public String getSocietyAdresse() {
        return societyAdresse;
    }

    public void setSocietyAdresse(String societyAdresse) {
        this.societyAdresse = societyAdresse;
    }

    public String getResponsableContact() {
        return responsableContact;
    }

    public void setResponsableContact(String responsableContact) {
        this.responsableContact = responsableContact;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    // constructors
    public Society(int idSociety, String society, String societyAdresse, String responsableContact, String mail, int status) {
        this.idSociety = idSociety;
        this.society = society;
        this.societyAdresse = societyAdresse;
        this.responsableContact = responsableContact;
        this.mail = mail;
        this.status = status;
    }

    public Society() {
    }

}
