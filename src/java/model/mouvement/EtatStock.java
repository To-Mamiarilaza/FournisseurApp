/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.mouvement;

import generalisation.GenericDAO.GenericDAO;
import java.time.LocalDate;
import java.util.List;
import model.article.Article;

/**
 *
 * @author Fy Botas
 */
public class EtatStock {

    Article article;
    LocalDate date;
    //methods

    //pump
    public double getPUMP() throws Exception {
        double PUMP = getCoutTotal() / getQuantiteMouvement(1);
        return PUMP;
    }

    //cout total des entrées
    public double getCoutTotal() throws Exception {
        List<Mouvement> mouvements = (List<Mouvement>) GenericDAO.directQuery(Mouvement.class, "select * from mouvement where id_article = " + this.getArticle().getIdArticle() + " and date_mouvement<='" + this.getDate() + "' and type_mouvement = 1", null);
        double coutTotal = 0;
        for (int i = 0; i < mouvements.size(); i++) {
            coutTotal += mouvements.get(i).getQuantite() * mouvements.get(i).getPrixUnitaire();
        }
        return coutTotal;
    }

    // avoir la somme des quantite entrants ainsi que les sortants ceux qui nous permet ainsi de trouver le reste
    public double getQuantiteMouvement(int type_mouvement) throws Exception {
        List<Mouvement> mouvements = (List<Mouvement>) GenericDAO.directQuery(Mouvement.class, "select * from mouvement where id_article = " + this.getArticle().getIdArticle() + " and date_mouvement<='" + this.getDate() + "' and type_mouvement = " + type_mouvement, null);
        double sommeQuantite = 0;
        for (int i = 0; i < mouvements.size(); i++) {
            sommeQuantite += mouvements.get(i).getQuantite();
        }
        return sommeQuantite;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getReste() throws Exception {
        double reste = getQuantiteMouvement(1) - getQuantiteMouvement(2);
        return reste;
    }

    public double getMontant() throws Exception {
        return getReste() * getPUMP();
    }

    public EtatStock(Article article, LocalDate date) {
        this.article = article;
        this.date = date;
    }

    public EtatStock() {
    }

}
