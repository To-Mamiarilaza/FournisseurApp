/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.communication;

/**
 *
 * @author To Mamiarilaza
 */
public class ArticleRequestDTO {
    /// Field
    int idProformaRequestSupplier;
    int idArticle;  // ID Article du client
    String articleName;
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
    
    /// Constructor

    public ArticleRequestDTO(int idProformaRequestSupplier, int idArticle, String articleName, double quantity) {
        this.idProformaRequestSupplier = idProformaRequestSupplier;
        this.idArticle = idArticle;
        this.articleName = articleName;
        this.quantity = quantity;
    }
    
}
