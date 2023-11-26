/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.communication;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;

/**
 *
 * @author To Mamiarilaza
 */
@DBTable(name = "supplier_info", sequenceName = "seq_supplier_info")
public class SupplierInfo {
    // Field
    @DBField(name = "id_supplier_info", isPrimaryKey = true)
    int idSupplier;
    @DBField(name = "supplier_name")
    String supplierName;
    @DBField(name = "supplier_address")
    String supplierAddress;
    @DBField(name = "responsable_contact")
    String responsableContact;
    @DBField(name = "mail")
    String mail;
    
/// Getter and setter
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
    
/// Constructor

    public SupplierInfo() {
    }

    
    public SupplierInfo(int idSupplier, String supplierName, String supplierAddress, String responsableContact, String mail) {
        this.idSupplier = idSupplier;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.responsableContact = responsableContact;
        this.mail = mail;
    }

    public SupplierInfo(String supplierName, String supplierAddress, String responsableContact, String mail) {
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.responsableContact = responsableContact;
        this.mail = mail;
    }
    
///Fonctions
    
}
