/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.communication;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import generalisation.utils.GenericUtil;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author To Mamiarilaza
 */
@DBTable(name = "proforma_request_dto", sequenceName = "seq_proforma_request_dto")
public class ProformaRequestDTO {
    // Field
    @DBField(name = "id_proforma_request_supplier", isPrimaryKey = true)
    int idProformaRequestSupplier;
    @DBField(name = "id_proforma_request_client")
    int idProformaRequestClient;
    @DBField(name = "sending_date")
    LocalDate sendingDate;
    @DBField(name = "id_supplier_info", isForeignKey = true)
    SupplierInfo supplier;
    @DBField(name = "id_client_info", isForeignKey = true)
    ClientInfo client;
    @DBField(name = "responseDate")
    LocalDate responseDate;
    @DBField(name = "amount")
    double amount;      
    @DBField(name = "pdf_representation")
    String pdfRepresentation;
    @DBField(name = "etat")
    int etat;
    List<ArticleRequestDTO> articleRequests;
    
    // Getter and setter

    public int getIdProformaRequestSupplier() {
        return idProformaRequestSupplier;
    }

    public void setIdProformaRequestSupplier(int idProformaRequestSupplier) {
        this.idProformaRequestSupplier = idProformaRequestSupplier;
    }

    public int getIdProformaRequestClient() {
        return idProformaRequestClient;
    }

    public void setIdProformaRequestClient(int idProformaRequestClient) {
        this.idProformaRequestClient = idProformaRequestClient;
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
    public void setSupplier(String supplier) throws Exception {
        if(supplier.trim().equals("") && supplier == null) {
            throw new Exception("Le fournisseur ne doit pas etre null");
        }
        SupplierInfo supplierFinding = new SupplierInfo();
        try {
            supplierFinding = GenericDAO.findById(SupplierInfo.class, Integer.valueOf(supplier), null);
        } catch(Exception e) {
            if(supplierFinding == null) {
                      throw new Exception("Aucune fournisseur n'a ete trouve");
            }
        }
        this.setSupplier(supplierFinding);
    }

    public ClientInfo getClient() {
        return client;
    }
    public void setClient(ClientInfo client) {
        this.client = client;
    }
    public void setClient(String client) throws Exception {
        if(client.trim().equals("") && (client == null)) {
            throw new Exception("Le client ne doit pas etre null");
        }
        ClientInfo clientInfo = new ClientInfo();
        try {
            clientInfo = GenericDAO.findById(ClientInfo.class, Integer.valueOf(client), null);
        } catch(Exception e) {
            throw new Exception("Aucun client n'a ete trouve");
        }
        this.setClient(clientInfo);
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
    public void setAmount(String amount) throws Exception {
        if(amount.trim().equals("") || amount == null) {
            throw new Exception("La quantite ne doit pas etre null");
        }
        double amountParsed;
        try {
            amountParsed = Double.valueOf(amount);
        } catch(Exception e) {
            throw new Exception("Impossible de convertir en double, la quantite doit etre un nombre");
        }
        this.setAmount(amountParsed);
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

    public int getEtat() {
        return etat;
    }
    public void setEtat(int etat) {
        this.etat = etat;
    }
    
    // Constructor

    public ProformaRequestDTO(int idProformaRequestSupplier, int idProformaRequestClient, LocalDate sendingDate, SupplierInfo supplier, ClientInfo client, LocalDate responseDate, double amount, String pdfRepresentation, int etat, List<ArticleRequestDTO> articleRequests) {
        this.idProformaRequestSupplier = idProformaRequestSupplier;
        this.idProformaRequestClient = idProformaRequestClient;
        this.sendingDate = sendingDate;
        this.supplier = supplier;
        this.client = client;
        this.responseDate = responseDate;
        this.amount = amount;
        this.pdfRepresentation = pdfRepresentation;
        this.etat = etat;
        this.articleRequests = articleRequests;
    }

    public ProformaRequestDTO(String supplier, String client, String amount) throws Exception {
        try {
            this.setIdProformaRequestClient(1);
            this.setEtat(1);
            this.setPdfRepresentation("Pdf representation");
            this.setResponseDate(LocalDate.now());
            this.setSendingDate(LocalDate.now());
            this.setSupplier(supplier);
            this.setClient(client);
            this.setAmount(amount);
        } catch(Exception e) {
            throw e;
        }
    }
    // method
    public static ProformaRequestDTO getProformaRequestExample() {
        int idProformaRequestSupplier = 1;
        int idProformaRequestClient = 1;
        LocalDate sendingDate = LocalDate.now();
        SupplierInfo supplier = new SupplierInfo(1, "Leader price", "Tanjombato", "+261 23 532 65", "leaderPrice@gmail.com");
        ClientInfo client = new ClientInfo("Milk Shop", "Andoharanofotsy", "+261 32 125 32", "milkShop@gmail.com");
        LocalDate responseDate = null;
        double amount = 0;
        String pdfRepresentation = null;
        List<ArticleRequestDTO> articleRequests = new ArrayList<>();
        articleRequests.add(new ArticleRequestDTO(0, 1, "Savony", 10));
        articleRequests.add(new ArticleRequestDTO(0, 2, "Rano", 3));
        
        return new ProformaRequestDTO(idProformaRequestSupplier, idProformaRequestClient, sendingDate, supplier, client, responseDate, amount, pdfRepresentation, 1, articleRequests);
    }
    
    //Sauver une demande 
    public void saveRequest(String supplier, String client, String amount, List<ArticleRequestDTO> articlesRequest) throws Exception {
        ProformaRequestDTO proformaRequest = new ProformaRequestDTO(supplier, client, amount);
        GenericDAO.save(proformaRequest, null);
        for(int i = 0; i < articlesRequest.size(); i++) {
            articlesRequest.get(i).setIdProformaRequestSupplier(proformaRequest.getIdProformaRequestSupplier());
            GenericDAO.save(articlesRequest.get(i), null);
        }
    }
}
