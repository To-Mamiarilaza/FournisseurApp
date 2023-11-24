/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.mouvement;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.sql.Date;
import java.util.List;
import model.article.Article;

/**
 *
 * @author Fy Botas
 */
@DBTable(name = "mouvement", sequenceName = "seq_mouvement")
public class Mouvement {

    @DBField(name = "id_mouvement", isPrimaryKey = true)
    int idMouvement;

    @DBField(name = "date_mouvement")
    Date dateMouvement;

    @DBField(name = "id_article", isForeignKey = true)
    Article article;

    @DBField(name = "type_mouvement")
    int typeMouvement;

    @DBField(name = "quantite")
    double quantite;

    @DBField(name = "prix_unitaire")
    double prixUnitaire;

    @DBField(name = "status")
    int status;

    public int getIdMouvement() {
        return idMouvement;
    }

    public void setIdMouvement(int idMouvement) {
        this.idMouvement = idMouvement;
    }

    public Date getDateMouvement() {
        return dateMouvement;
    }

    public void setDateMouvement(Date dateMouvement) {
        this.dateMouvement = dateMouvement;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getTypeMouvement() {
        return typeMouvement;
    }

    public void setTypeMouvement(int typeMouvement) {
        this.typeMouvement = typeMouvement;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Mouvement(int idMouvement, Date dateMouvement, Article article, int typeMouvement, double quantite, double prixUnitaire, int status) {
        this.idMouvement = idMouvement;
        this.dateMouvement = dateMouvement;
        this.article = article;
        this.typeMouvement = typeMouvement;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.status = status;
    }

    public Mouvement() {
    }
}
