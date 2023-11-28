/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.proforma;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;

/**
 *
 * @author chalman
 */
@DBTable(name = "supplier", sequenceName = "seq_supplier")
public class Supplier {
    @DBField(name = "id_supplier", isPrimaryKey = true)
    int idSupplier;
    @DBField(name = "name")
    String name;
    @DBField(name = "adress")
    String adress;
    @DBField(name = "contact_responsable")
    String contactResponsable;
    @DBField(name = "mail")
    String mail;
    
///Getters et setters
    public int getIdSupplier() {
        return idSupplier;
    }
    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getContactResponsable() {
        return contactResponsable;
    }
    public void setContactResponsable(String contactResponsable) {
        this.contactResponsable = contactResponsable;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    
///Constructors
    public Supplier() {
    }

    public Supplier(int idSupplier, String name, String adress, String contactResponsable, String mail) {
        this.idSupplier = idSupplier;
        this.name = name;
        this.adress = adress;
        this.contactResponsable = contactResponsable;
        this.mail = mail;
    }

    public Supplier(String name, String adress, String contactResponsable, String mail) {
        this.name = name;
        this.adress = adress;
        this.contactResponsable = contactResponsable;
        this.mail = mail;
    }
    
///Fonctions
    
}
