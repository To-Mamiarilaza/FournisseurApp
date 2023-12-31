/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.article;

import generalisation.GenericDAO.GenericDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.article.Article;
import model.base.Utilisateur;
import model.mouvement.EtatStock;

/**
 *
 * @author To Mamiarilaza
 */
@WebServlet(name = "EtatStockServlet", urlPatterns = {"/etat-stock"})
public class EtatStockServlet extends HttpServlet {

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
            request.setAttribute("css", css);
            request.setAttribute("js", js);
            List<Article> articles = (List<Article>) GenericDAO.getAll(Article.class, " where id_category in (select id_category from society_category_product where id_society = "+ idSociety +") and status = 1", null);
            request.setAttribute("articles", articles);
            // Page definition
            request.setAttribute("title", "Article");
            request.setAttribute("contentPage", "./pages/article/etatStock.jsp");

            request.getRequestDispatcher("./template.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            LocalDate date = LocalDate.parse(request.getParameter("date"));
            int idArticle = Integer.valueOf(request.getParameter("article"));
            Article article = (Article) GenericDAO.findById(Article.class, idArticle, null);
            EtatStock es = new EtatStock(article, date);

            request.setAttribute("article", article);
            request.setAttribute("reste", es.getReste());
            request.setAttribute("montant", es.getMontant());
            request.setAttribute("prixUnitaire", es.getPUMP());

            // All required assets
            List<String> css = new ArrayList<>();

            List<String> js = new ArrayList<>();

            request.setAttribute("css", css);
            request.setAttribute("js", js);
            List<Article> articles = (List<Article>) GenericDAO.getAll(Article.class, " where status = 1", null);
            request.setAttribute("articles", articles);
            // Page definition
            request.setAttribute("title", "Article");
            request.setAttribute("contentPage", "./pages/article/etatStock.jsp");

            Utilisateur user = (Utilisateur) request.getSession().getAttribute("utilisateur");
            request.setAttribute("utilisateur", user);

            request.getRequestDispatcher("./template.jsp").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
