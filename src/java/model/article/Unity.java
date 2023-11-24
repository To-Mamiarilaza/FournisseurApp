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
@DBTable(name = "unity", sequenceName = "seq_unity")
public class Unity {
    @DBField(name = "id_unity", isPrimaryKey = true)
    int idUnity;
    @DBField(name = "name")
    String name;
    
///Getters et setters
    public int getIdUnity() {
        return idUnity;
    }
    public void setIdUnity(int idUnity) {
        this.idUnity = idUnity;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
///Constructors

    public Unity() {
    }

    public Unity(int idUnity, String name) {
        this.idUnity = idUnity;
        this.name = name;
    }

    public Unity(String name) {
        this.name = name;
    }
    
///Fonctions
    
}
