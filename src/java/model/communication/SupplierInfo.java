/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.communication;

/**
 *
 * @author To Mamiarilaza
 */
public class SupplierInfo {
    // Field
    int idSupplier;
    String supplierName;
    String supplierAddress;
    String responsableContact;
    String mail;
    
    // Getter and setter

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
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
    
    // Constructor

    public SupplierInfo(int idSupplier, String supplierName, String supplierAddress, String responsableContact, String mail) {
        this.idSupplier = idSupplier;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.responsableContact = responsableContact;
        this.mail = mail;
    }
    
}
