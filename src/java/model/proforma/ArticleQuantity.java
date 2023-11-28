/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.proforma;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import model.article.Article;
import service.util.DisplayUtil;

/**
 *
 * @author chalman
 */
@DBTable(name = "article_quantity", sequenceName = "seq_article_quantity")
public class ArticleQuantity {
    @DBField(name = "id_article_quantity", isPrimaryKey = true)
    int idArticleQuantity;
    @DBField(name = "id_article", isForeignKey = true)
    Article article;
    @DBField(name = "quantity")
    double quantity;
    boolean isExist;
    @DBField(name = "status")
    int status;
    @DBField(name = "id_proforma_request", isForeignKey = true)
    ProformaRequest proformaRequest;
    double montantTVA;
    double montantHT;
    double montantTTC;
    
///Getters et setters
    public int getIdArticleQuantity() {
        return idArticleQuantity;
    }
    public void setIdArticleQuantity(int idArticleQuantity) {
        this.idArticleQuantity = idArticleQuantity;
    }
    

    public Article getArticle() {
        return article;
    }
    public void setArticle(Article article) {
        this.article = article;
    }

    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public boolean getIsExist() {
        return isExist;
    }
    public void setIsExist(boolean isExist) {
        this.isExist = isExist;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public ProformaRequest getProformaRequest() {
        return proformaRequest;
    }
    public void setProformaRequest(ProformaRequest proformaRequest) {
        this.proformaRequest = proformaRequest;
    }

    public double getMontantTVA() {
        return (this.getArticle().getPrice() * this.getArticle().getTva()) / 100;
    }
    public String getMontantTVAString() {
        return DisplayUtil.formatMoney(this.getMontantTVA(), "AR");
    }

    public double getMontantHT() {
        return this.getArticle().getPrice() * this.getQuantity();
    }
    public String getMontantHTString() {
        return DisplayUtil.formatMoney(this.getMontantHT(), "AR");
    }
    
    public double getMontantTTC() {
        return this.getMontantHT() + this.getMontantTVA();
    }
    public String getMontantTTCString() {
        return DisplayUtil.formatMoney(this.getMontantTTC(), "AR");
    }

    public String getUnitPriceString() {
        return DisplayUtil.formatMoney(this.getArticle().getPrice(), "AR");
    }
    
    public String getTVAString() {
        return DisplayUtil.formatMoney(this.getArticle().getTva(), "%");
    }
///Constructors
    public ArticleQuantity() {
    }

    public ArticleQuantity(int idArticleQuantity, Article article, double quantity, boolean isExist, int status) {
        this.idArticleQuantity = idArticleQuantity;
        this.article = article;
        this.quantity = quantity;
        this.isExist = isExist;
        this.status = status;
    }

    public ArticleQuantity(Article article, double quantity, int status) {
        this.article = article;
        this.quantity = quantity;
        this.status = status;
    }
    
}
