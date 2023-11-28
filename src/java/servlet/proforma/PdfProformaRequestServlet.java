/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.proforma;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import model.proforma.ProformaRequest;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.rendering.PDFRenderer;
import service.util.DisplayUtil;
import service.util.EmailSender;
import static service.util.EmailSender.sendEmail;
import service.util.PDFRealisationUtil;

/**
 *
 * @author chalman
 */
@WebServlet(name = "PdfProformaRequestServlet", urlPatterns = {"/PdfProformaRequest"})
public class PdfProformaRequestServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PdfProformaRequestServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PdfProformaRequestServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            ProformaRequest proformaRequest = (ProformaRequest)session.getAttribute("proformaRequest");
            // Bien remplir ces données et tout doit aller automatiquement
            String dateSending = proformaRequest.getDateSendingFormatted();
            String underTitle1 = "Fournisseur";
            String nameSupplier = proformaRequest.getSociety().getSociety();
            String adressSupplier = proformaRequest.getSociety().getSocietyAdresse();
            String contactResponsable = proformaRequest.getSociety().getResponsableContact();
            String mailSupplier = proformaRequest.getSociety().getMail();
            String underTitle2 = "Client";
            String mailClient = proformaRequest.getMailClient();
          
            try (PDDocument document = new PDDocument()) {
                PDPage page = new PDPage(PDRectangle.A4);
                document.addPage(page);

                try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                    PDFRealisationUtil outil = new PDFRealisationUtil();

                    //Date
                    contentStream.setNonStrokingColor(150, 150, 150); // Gris sombre
                    contentStream.setFont(PDType1Font.HELVETICA, 10);
                    outil.writeText(contentStream, 30, 830, proformaRequest.getDateSendingFormatted());
                    
                    // Header
                           contentStream.setNonStrokingColor(0, 0, 0); // Noir
                    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
                    outil.writeText(contentStream, 30, 810, underTitle1);
                    
                    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
                    outil.writeText(contentStream, 350, 810, underTitle2);
                    
                    //Description du contenu
                    int dynamicY = 790;     // pour que la hauteur s'adapte en fonction du nombres de ligne
                    int lineHeight = 20;

                    //Fournisseur description
                    contentStream.setNonStrokingColor(150, 150, 150); // Gris sombre
                    contentStream.setFont(PDType1Font.HELVETICA, 10);
                    outil.writeText(contentStream, 30, dynamicY, "Nom : ");
                    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
                    outil.writeText(contentStream, 100, dynamicY, nameSupplier);
                    
                    //Client description
                    contentStream.setFont(PDType1Font.HELVETICA, 10);
                    outil.writeText(contentStream, 350, dynamicY, "Mail : ");
                    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
                    outil.writeText(contentStream, 400, dynamicY, mailClient);
                    dynamicY -= lineHeight;
                    
                    //Fournisseur description
                    contentStream.setFont(PDType1Font.HELVETICA, 10);
                    outil.writeText(contentStream, 30, dynamicY, "Adresse : ");
                    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
                    outil.writeText(contentStream, 100, dynamicY, adressSupplier);
                    dynamicY -= lineHeight;
                    
                    contentStream.setFont(PDType1Font.HELVETICA, 10);
                    outil.writeText(contentStream, 30, dynamicY, "Contact du responsable : ");
                    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
                    outil.writeText(contentStream, 150, dynamicY, contactResponsable);;
                    dynamicY -= lineHeight;
                    
                    contentStream.setFont(PDType1Font.HELVETICA, 10);
                    outil.writeText(contentStream, 30, dynamicY, "Mail : ");
                    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
                    outil.writeText(contentStream, 100, dynamicY, mailSupplier);;
                    dynamicY -= lineHeight;
                    dynamicY -= lineHeight;
                    dynamicY -= lineHeight;
                    
                    contentStream.setNonStrokingColor(135, 206, 250); // Bleu clair
                     // Définir les coordonnées et les dimensions du rectangle
                    float x = 20;
                    float y = dynamicY - 20;
                    float width = 550;
                    float height = 40;

                    // Dessiner et colorer le rectangle
                    contentStream.fillRect(x, y, width, height);
                    
                    //Liste des articles quantite
                      contentStream.setNonStrokingColor(0, 0, 0); // Noir
                    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
                    outil.writeText(contentStream, 30, dynamicY, "Designation");
                    outil.writeText(contentStream, 110, dynamicY, "Quantite");
                    outil.writeText(contentStream, 160, dynamicY, "Qte dispo");
                    outil.writeText(contentStream, 220, dynamicY, "Prix unitaire");
                    outil.writeText(contentStream, 290, dynamicY, "TVA");
                    outil.writeText(contentStream, 330, dynamicY, "Montant TVA");
                    outil.writeText(contentStream, 400, dynamicY, "Montant HT");
                    outil.writeText(contentStream, 470, dynamicY, "Montant TTC");

                    dynamicY -= lineHeight;
                    dynamicY -= lineHeight;
                    contentStream.setNonStrokingColor(150, 150, 150); // Gris sombre
                    for(int i = 0; i < proformaRequest.getArticleQuantity().size(); i++) {
                    contentStream.setFont(PDType1Font.HELVETICA, 9);
                    outil.writeText(contentStream, 30, dynamicY, proformaRequest.getArticleQuantity().get(i).getArticle().getDesignation());
                    outil.writeText(contentStream, 110, dynamicY, String.valueOf(proformaRequest.getArticleQuantity().get(i).getQuantity()));
                    outil.writeText(contentStream, 160, dynamicY, String.valueOf(proformaRequest.getArticleQuantity().get(i).getQuantityDispo()));
                    outil.writeText(contentStream, 220, dynamicY, DisplayUtil.formatMoney(proformaRequest.getArticleQuantity().get(i).getArticle().getPrice(), "AR"));
                    outil.writeText(contentStream, 290, dynamicY, DisplayUtil.formatMoney(proformaRequest.getArticleQuantity().get(i).getArticle().getTva(), "%"));
                    outil.writeText(contentStream, 330, dynamicY, proformaRequest.getArticleQuantity().get(i).getMontantTVAString());
                    outil.writeText(contentStream, 400, dynamicY, proformaRequest.getArticleQuantity().get(i).getMontantHTString());
                    outil.writeText(contentStream, 470, dynamicY, proformaRequest.getArticleQuantity().get(i).getMontantTTCString());

                    contentStream.drawLine(20, dynamicY - 20, 570, dynamicY-20);
                    dynamicY -= lineHeight;
                    dynamicY -= lineHeight;
                    }

                    outil.writeText(contentStream, 280, dynamicY, "TOTAL");
                    outil.writeText(contentStream, 330, dynamicY, proformaRequest.getMontanTVATotalString());
                    outil.writeText(contentStream, 400, dynamicY, proformaRequest.getMontantHTTotalString());
                    outil.writeText(contentStream, 470, dynamicY, proformaRequest.getMontantTTCTotalString());
                    contentStream.drawLine(20, dynamicY - 20, 570, dynamicY-20);
                    dynamicY -= lineHeight;
                    dynamicY -= lineHeight;
                    dynamicY -= lineHeight;
                    dynamicY -= lineHeight;
                    dynamicY -= lineHeight;

                    contentStream.setNonStrokingColor(0, 0, 0); // noir
                    //Prix total
                     contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
                    outil.writeText(contentStream, 30, dynamicY, "Arrete le present proforma a la somme de :");
                    contentStream.setFont(PDType1Font.HELVETICA, 10);
                    outil.writeText(contentStream, 240, dynamicY, String.valueOf(proformaRequest.getMontantTotalLetter())+" AR");
                    dynamicY -= lineHeight;
                    
                }

                //Sauvegarder le proforma request
                proformaRequest.save();

                // Pour le persistance de données
                    String persistanceDirectory = getServletContext().getRealPath("").replace("build\\web\\", "web\\");
                    
                // Exportation en pdf
                    document.save(getServletContext().getRealPath("/proformaRequestPdf/PROF00" + proformaRequest.getIdProformaRequest() + ".pdf"));
                    document.save(persistanceDirectory + "\\proformaRequestPdf\\PROF00" + proformaRequest.getIdProformaRequest() + ".pdf");
                    String path = persistanceDirectory + "\\proformaRequestPdf\\PROF00" + proformaRequest.getIdProformaRequest() + ".pdf";
                
                //Envoye par email
                    String[] recipients = {proformaRequest.getMailClient()};
                    EmailSender.sendEmail(recipients, "Demande de proforma", "Voici le proforma contenant les articles detailles que vous avez demande", path);
        
                //Suppression des sessions
                    session.removeAttribute("proformaRequest");
                    
                
                // Affichage a l'écran
                document.save(response.getOutputStream());

                //conn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("Error", e.getMessage());
            response.sendRedirect("./proforma-request");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
