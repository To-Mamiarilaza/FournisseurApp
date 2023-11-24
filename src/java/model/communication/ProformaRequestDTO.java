/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.communication;

import generalisation.GenericDAO.GenericDAO;
import generalisation.utils.GenericUtil;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author To Mamiarilaza
 */
public class ProformaRequestDTO {
    // Field
    int idProformaRequest;
    LocalDate sendingDate;
    SupplierInfo supplier;
    ClientInfo client;
    LocalDate responseDate;
    double amount;
    String pdfRepresentation;
    List<ArticleRequestDTO> articleRequests;
    
    // Getter and setter

    public int getIdProformaRequest() {
        return idProformaRequest;
    }

    public void setIdProformaRequest(int idProformaRequest) {
        this.idProformaRequest = idProformaRequest;
    }

    public LocalDate getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(LocalDate sendingDate) {
        this.sendingDate = sendingDate;
    }

    public SupplierInfo getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierInfo supplier) {
        this.supplier = supplier;
    }

    public ClientInfo getClient() {
        return client;
    }

    public void setClient(ClientInfo client) {
        this.client = client;
    }

    public LocalDate getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(LocalDate responseDate) {
        this.responseDate = responseDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPdfRepresentation() {
        return pdfRepresentation;
    }

    public void setPdfRepresentation(String pdfRepresentation) {
        this.pdfRepresentation = pdfRepresentation;
    }

    public List<ArticleRequestDTO> getArticleRequests() {
        return articleRequests;
    }

    public void setArticleRequests(List<ArticleRequestDTO> articleRequests) {
        this.articleRequests = articleRequests;
    }
    
    // Constructor

    public ProformaRequestDTO(int idProformaRequest, LocalDate sendingDate, SupplierInfo supplier, ClientInfo client, LocalDate responseDate, double amount, String pdfRepresentation, List<ArticleRequestDTO> articleRequests) {
        this.idProformaRequest = idProformaRequest;
        this.sendingDate = sendingDate;
        this.supplier = supplier;
        this.client = client;
        this.responseDate = responseDate;
        this.amount = amount;
        this.pdfRepresentation = pdfRepresentation;
        this.articleRequests = articleRequests;
    }
    
    // method
    public static ProformaRequestDTO getProformaRequestExample() {
        int idProformaRequest = 1;
        LocalDate sendingDate = LocalDate.now();
        SupplierInfo supplier = new SupplierInfo(1, "Leader price", "Tanjombato", "+261 23 532 65", "leaderPrice@gmail.com");
        ClientInfo client = new ClientInfo("Milk Shop", "Andoharanofotsy", "+261 32 125 32", "milkShop@gmail.com");
        LocalDate responseDate = null;
        double amount = 0;
        String pdfRepresentation = null;
        List<ArticleRequestDTO> articleRequests = new ArrayList<>();
        articleRequests.add(new ArticleRequestDTO(1, "Savony", 10));
        articleRequests.add(new ArticleRequestDTO(2, "Rano", 3));
        
        return new ProformaRequestDTO(idProformaRequest, sendingDate, supplier, client, responseDate, amount, pdfRepresentation, articleRequests);
    }
}
