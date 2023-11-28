/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.proforma;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.article.Article;
import model.base.Society;
import service.util.DisplayUtil;

/**
 *
 * @author chalman
 */
@DBTable(name = "proforma_request", sequenceName = "seq_proforma_request")
public class ProformaRequest {
    @DBField(name = "id_proforma_request", isPrimaryKey = true)
    int idProformaRequest;
    @DBField(name = "id_society",isForeignKey = true)
    Society society;
    @DBField(name = "mail_client")
    String mailClient;
    @DBField(name = "status")
    int status;
    @DBField(name = "date_sending")
    LocalDate dateSending;
    
    List<ArticleQuantity> articleQuantity = new ArrayList<>();

///Getters et setters
    public int getIdProformaRequest() {
        return idProformaRequest;
    }
    public void setIdProformaRequest(int idProformaRequest) {    
        this.idProformaRequest = idProformaRequest;
    }

    public Society getSociety() {
        return society;
    }
    public void setSociety(Society society) {
        this.society = society;
    }

    
    public String getMailClient() {
        return mailClient;
    }
    public void setMailClient(String mailClient) {
        this.mailClient = mailClient;
    }

    public List<ArticleQuantity> getArticleQuantity() {
        return articleQuantity;
    }
    public void setArticleQuantity(List<ArticleQuantity> articleQuantity) {
        this.articleQuantity = articleQuantity;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDate getDateSending() {
        return dateSending;
    }
    public void setDateSending(LocalDate dateSending) {
        this.dateSending = dateSending;
    }
    
    
///Constructors
    public ProformaRequest() {
    }

    public ProformaRequest(int idProformaRequest, Society society, String mailClient, int status, LocalDate dateSending) {
        this.idProformaRequest = idProformaRequest;
        this.mailClient = mailClient;
        this.society = society;
        this.status = status;
        this.dateSending = dateSending;
    }

    public ProformaRequest(Society society, String mailClient, int status, LocalDate dateSending) {
        this.mailClient = mailClient;
        this.society = society;
        this.status = status;
        this.dateSending = dateSending;
    }

    
 ///Fonctions
     // ajouter un article dans une demande
    public ArticleQuantity addArticleQuantity(String article, String quantity) throws Exception {
        if (article.trim().equals("")) {
            throw new Exception("L'article ne doit pas être vide !");
        }
        if (quantity.trim().equals("")) {
            throw new Exception("La quantite ne doit pas être vide !");
        }

        Double quantityParsed;
        try {
            quantityParsed = Double.valueOf(quantity);
        } catch (Exception e) {
            throw new Exception("La valeur du quantite doit être un nombre !");
        }

        if(quantityParsed < 0) {
            throw new Exception("La valeur du quantite doit etre un nombre positif");
        }
        Article articleFinding = GenericDAO.findById(Article.class, Integer.valueOf(article), null);
        ArticleQuantity articleQuantity = new ArticleQuantity();
        //Verification de l'existence de l'article dans la liste des articles ajoutes
        if(isArticleInList(articleFinding, quantityParsed) != -1) {
            int idArticleAdded = isArticleInList(articleFinding, quantityParsed);
            this.getArticleQuantity().get(idArticleAdded).setQuantity(this.getArticleQuantity().get(idArticleAdded).getQuantity() + quantityParsed);
            this.getArticleQuantity().get(idArticleAdded).setIsExist(true);
            
            return this.getArticleQuantity().get(idArticleAdded);
        } else {
            articleQuantity = new ArticleQuantity(articleFinding, quantityParsed, 1);
            this.getArticleQuantity().add(articleQuantity);
            articleQuantity.setIsExist(false);
        }
       

        return articleQuantity;
    }

    //Verifier si l'article est deja ajoute dans la liste
    public int isArticleInList(Article article, Double newQuantity) throws Exception {
        for(int i = 0; i < this.getArticleQuantity().size(); i++) {
            if(article.getIdArticle() == this.getArticleQuantity().get(i).getArticle().getIdArticle()) {
                return i;
            }
        }
        
        return -1;
    }
    
    // supprimer une demande d'article
    public void deleteRequest(String code) throws Exception {
        if (code.trim().equals("")) {
            throw new Exception("Le code article ne doit pas être vide ou null !");
        }

        for (int i = 0; i < this.getArticleQuantity().size(); i++) {
            if (this.getArticleQuantity().get(i).getArticle().getCode().equals(code)) {
                if(this.getArticleQuantity().get(i).getIdArticleQuantity() != 0) {
                    this.getArticleQuantity().get(i).setStatus(0);
                    GenericDAO.updateById(this.getArticleQuantity().get(i), this.getArticleQuantity().get(i).getIdArticleQuantity(), null);
                 }
                this.getArticleQuantity().remove(i);
            }
        }
    }

    //Affichage du proformaRequest
    public void displayProforma() {
        for(int i = 0; i < this.getArticleQuantity().size(); i++) {
            System.out.println("article = "+this.getArticleQuantity().get(i).getArticle().getDesignation()+", Quantity = "+this.getArticleQuantity().get(i).getQuantity());
        }
    }
    
    //Total montant TTC proforma
    public double getMontantTTCTotal() {
        double sum = 0.0; 
        for(int i = 0; i < this.getArticleQuantity().size(); i++) {
            sum += sum + this.getArticleQuantity().get(i).getMontantTTC();
        }
        
        return sum;
    }
    public String getMontantTTCTotalString() {
        return DisplayUtil.formatMoney(this.getMontantTTCTotal(), "AR");
    }
    public String getMontantTotalLetter() {
        String montantTotalString = String.valueOf(this.getMontantTTCTotal());
    
        return DisplayUtil.toLetter((int)(this.getMontantTTCTotal()));
    }
    
    //Total montant HT proforma
    public double getMontantHTTotal() {
        double sum = 0.0; 
        for(int i = 0; i < this.getArticleQuantity().size(); i++) {
            sum += sum + this.getArticleQuantity().get(i).getMontantHT();
        }
        
        return sum;
    }
    public String getMontantHTTotalString() {
        return DisplayUtil.formatMoney(this.getMontantHTTotal(), "AR");
    }
    
    //Total montant HT proforma
    public double getMontantTVATotal() {
        double sum = 0.0; 
        for(int i = 0; i < this.getArticleQuantity().size(); i++) {
            sum += sum + this.getArticleQuantity().get(i).getMontantTVA();
        }
        
        return sum;
    }
    public String getMontanTVATotalString() {
        return DisplayUtil.formatMoney(this.getMontantTVATotal(), "AR");
    }
    
    public String getDateSendingFormatted() {
        return DisplayUtil.formatLocalDate(this.getDateSending());
    }
    
    //Sauvegarder la demande proforma
    public void save() throws Exception {
        GenericDAO.save(this, null);
        for(int i = 0; i < this.getArticleQuantity().size(); i++) {
            this.getArticleQuantity().get(i).setProformaRequest(this);
            GenericDAO.save(this.getArticleQuantity().get(i), null);
        }
    }
}
