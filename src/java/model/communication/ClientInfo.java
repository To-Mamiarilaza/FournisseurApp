/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.communication;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.util.List;

/**
 *
 * @author To Mamiarilaza
 */
@DBTable(name = "client_info", sequenceName = "seq_client_info")
public class ClientInfo {
    /// Field
    @DBField(name = "id_client", isPrimaryKey = true)
    int idClient;
    @DBField(name = "client_name")
    String clientName;
    @DBField(name = "client_adress") 
    String clientAddress;
    @DBField(name = "responsable_client")
    String responsableContact;
    @DBField(name = "mail")
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
    public ClientInfo() {
    }

    public ClientInfo(int idClient, String clientName, String clientAddress, String responsableContact, String mail) {
        this.idClient = idClient;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.responsableContact = responsableContact;
        this.mail = mail;
    }

    public ClientInfo(String clientName, String clientAddress, String responsableContact, String mail) {
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.responsableContact = responsableContact;
        this.mail = mail;
    }
    
///Fonctions
    public void checkClientExisting(String name, String mail, String clientAdress, String responsableContact) throws Exception {
        String sql = "SELECT * FROM client_info WHERE name= '%s' AND mail='%s'";
        String.format(sql, name, mail);
        List<ClientInfo> clientInfo = (List<ClientInfo>) GenericDAO.directQuery(ClientInfo.class, sql, null);
        if(clientInfo == null) {
            ClientInfo newClientInfo = new ClientInfo(name, clientAdress, responsableContact, mail);
            GenericDAO.save(newClientInfo, null);
        }
    }
}
