/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.proforma;

import generalisation.GenericDAO.GenericDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.article.Article;
import model.base.Utilisateur;
import model.proforma.ProformaRequest;

/**
 *
 * @author To Mamiarilaza
 */
@WebServlet(name = "ProformaRequestServlet", urlPatterns = {"/proforma-request"})
public class ProformaRequestServlet extends HttpServlet {

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
            out.println("<title>Servlet ProformaRequest</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProformaRequest at " + request.getContextPath() + "</h1>");
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
            //recuperer la session utilisateur
            HttpSession session = request.getSession();
            Utilisateur user = (Utilisateur)session.getAttribute("utilisateur");
            //Liste des articles
            List<Article> articles = (List<Article>) GenericDAO.getAll(Article.class, " where id_category in (select id_category from society_category_product where id_society = "+ user.getSociety().getIdSociety() +") and status = 1", null);
            request.setAttribute("articles", articles);
            
            //Lancement du session demande proforma
            ProformaRequest proformaRequest = new ProformaRequest();
            session.setAttribute("proformaRequest", proformaRequest);
            
            // All required assets
            List<String> css = new ArrayList<>();

            List<String> js = new ArrayList<>();
            js.add("./assets/js/proforma/proforma.js");

            request.setAttribute("css", css);
            request.setAttribute("js", js);

            // Page definition
            request.setAttribute("title", "Demandes de proformas");
            request.setAttribute("contentPage", "./pages/proforma/proformaRequest.jsp");

            request.getRequestDispatcher("./template.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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
