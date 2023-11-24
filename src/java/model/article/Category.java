/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.article;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;

/**
 *
 * @author chalman
 */
@DBTable(name = "category", sequenceName = "seq_category")
public class Category {
    @DBField(name = "id_category", isPrimaryKey = true)
    int idCategory;
    @DBField(name = "code")
    String code;
    @DBField(name = "designation")
    String designation;
    @DBField(name = "description")
    String description;
    @DBField(name = "status")
    int status;
    
///Getters et setters
    public int getIdCategory() {
        return idCategory;
    }
    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code)  throws Exception {
        if(code.trim().equals("") || code == null) {
            throw new Exception("Aucune valeur de code trouve");
        }
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) throws Exception {
        if(designation.trim().equals("") || designation == null) {
            throw new Exception("Aucune valeur de designation trouve");
        }
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) throws Exception {
        if(description.trim().equals("") || description == null) {
            throw new Exception("Aucune valeur de decription trouve");
        }
        this.description = description;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    
///Constructors

    public Category() {
    }

    public Category(int idCategory, String code, String designation, String description, int status) {
        this.idCategory = idCategory;
        this.code = code;
        this.designation = designation;
        this.description = description;
        this.status = status;
    }

    public Category(String code, String designation, String description, int status) {
        this.code = code;
        this.designation = designation;
        this.description = description;
        this.status = status;
    }
    
    public Category(String code, String designation, String description ) throws Exception {
        try {
            this.setCode(code);
            this.setDesignation(designation);
            this.setDescription(description);
            this.setStatus(1);
        } catch(Exception e) {
            throw e;
        }
    }
///Fonctions
}
