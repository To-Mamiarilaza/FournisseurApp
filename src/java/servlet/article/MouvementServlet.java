/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.article;

import generalisation.GenericDAO.GenericDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.article.Article;
import model.base.Utilisateur;
import model.mouvement.Mouvement;

/**
 *
 * @author To Mamiarilaza
 */
@WebServlet(name = "MovementServlet", urlPatterns = {"/mouvement"})
public class MouvementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // All required assets
            List<String> css = new ArrayList<>();

            List<String> js = new ArrayList<>();
            Utilisateur user = (Utilisateur) request.getSession().getAttribute("utilisateur");
            request.setAttribute("utilisateur", user);

            int idSociety = user.getSociety().getIdSociety();
            List<Article> articles = (List<Article>) GenericDAO.getAll(Article.class, " where id_category in (select id_category from society_category_product where id_society = " + idSociety + ") and status = 1", null);
            request.setAttribute("articles", articles);
            request.setAttribute("css", css);
            request.setAttribute("js", js);

            // Page definition
            request.setAttribute("title", "Mouvement de stock");
            request.setAttribute("contentPage", "./pages/article/mouvement.jsp");

            request.getRequestDispatcher("./template.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String date = request.getParameter("date");
            int idArticle = Integer.valueOf(request.getParameter("article"));
            int mouvementType = Integer.valueOf(request.getParameter("movementType"));
            double quantite = Double.valueOf(request.getParameter("quantity"));
            double unitPrice = Double.valueOf(request.getParameter("unitPrice"));

            Article article;
            article = (Article) GenericDAO.findById(Article.class, idArticle, null);

            Mouvement move = new Mouvement(LocalDate.parse(date), article, mouvementType, quantite, unitPrice, 1);
            try {
                GenericDAO.save(move, null);
                response.sendRedirect("./mouvement");
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", e.getMessage());
                response.sendRedirect("./mouvement");
            }
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
            response.sendRedirect("./mouvement");
        }
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
