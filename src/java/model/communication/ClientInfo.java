/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.communication;

/**
 *
 * @author To Mamiarilaza
 */
public class ClientInfo {
    /// Field
    String clientName;
    String clientAddress;
    String responsableContact;
    String mail;
    
    /// Getter and setter

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
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
    
    /// Constructor

    public ClientInfo(String clientName, String clientAddress, String responsableContact, String mail) {
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.responsableContact = responsableContact;
        this.mail = mail;
    }
    
}
