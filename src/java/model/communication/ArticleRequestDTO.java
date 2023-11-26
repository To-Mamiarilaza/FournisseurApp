/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.communication;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;

/**
 *
 * 
 * @author To Mamiarilaza
 */
@DBTable(name = "article_request_dto", sequenceName = "seq_article_request_dto")
public class ArticleRequestDTO {
    /// Field
    @DBField(name = "id_proforma_request_supplier", isForeignKey = true)
    int idProformaRequestSupplier;
    @DBField(name = "id_article")
    int idArticle;  // ID Article du client
    @DBField(name = "article_name")
    String articleName;
    @DBField(name = "quantity")
    double quantity;
    
    /// Getter and setter

    public int getIdProformaRequestSupplier() {
        return idProformaRequestSupplier;
    }

    public void setIdProformaRequestSupplier(int idProformaRequestSupplier) {
        this.idProformaRequestSupplier = idProformaRequestSupplier;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public void setQuantity(String quantity) throws Exception {
        if(quantity.trim().equals("") || quantity == null) {
            throw new Exception("La quantite ne doit pas etre null");
        }
        double quantityParsed;
        try {
            quantityParsed = Double.valueOf(quantity);
        } catch(Exception e) {
            throw new Exception("La quantite ne doit pas etre null");
        }
        this.setQuantity(quantityParsed);
    }
    
    /// Constructor
    public ArticleRequestDTO(int idProformaRequestSupplier, int idArticle, String articleName, double quantity) {
        this.idProformaRequestSupplier = idProformaRequestSupplier;
        this.idArticle = idArticle;
        this.articleName = articleName;
        this.quantity = quantity;
    }
    
    public ArticleRequestDTO(String articleName, String quantity) throws Exception {
        try {
            this.setArticleName("Milk");
            this.setQuantity(quantity);
        } catch(Exception e) {
            throw e;
        }
    }
}
