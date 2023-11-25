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
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.article.Article;
import model.article.Category;
import model.article.Unity;
import model.base.Utilisateur;

/**
 *
 * @author To Mamiarilaza
 */
@WebServlet(name = "ArticleServlet", urlPatterns = {"/article"})
public class ArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Utilisateur user = (Utilisateur) request.getSession().getAttribute("utilisateur");
            request.setAttribute("utilisateur", user);
            if (request.getParameter("idArticle") != null) {
                int idArticle = Integer.valueOf(request.getParameter("idArticle"));
                Article concernedArticle = (Article) GenericDAO.findById(Article.class, idArticle, null);
                request.setAttribute("concernedArticle", concernedArticle);

                HttpSession session = request.getSession();
                session.setAttribute("action", "modifier");
            } else {
                // session pour verifier l'action effectuer puisque le formulaire d'insertion et de modification son le meme
                HttpSession session = request.getSession();
                session.setAttribute("action", "aucun");

                Article concernedArticle = new Article();
                concernedArticle.setDesignation("");
                concernedArticle.setCode("");
                request.setAttribute("concernedArticle", concernedArticle);
            }
            // All required assets
            List<String> css = new ArrayList<>();

            List<String> js = new ArrayList<>();

            request.setAttribute("css", css);
            request.setAttribute("js", js);
            int idSociety = user.getSociety().getIdSociety();
            
            List<Article> articles = (List<Article>) GenericDAO.getAll(Article.class, " where id_category in (select id_category from society_category_product where id_society = "+ idSociety +") and status = 1", null);
            List<Category> categorys = (List<Category>) GenericDAO.getAll(Category.class, " where id_category in (select id_category from society_category_product where id_society = "+ idSociety +") and status = 1", null);
            request.setAttribute("categories", categorys);
            List<Unity> unitys = (List<Unity>) GenericDAO.getAll(Unity.class, null, null);
            request.setAttribute("unities", unitys);
            request.setAttribute("articles", articles);

            // Page definition
            request.setAttribute("title", "Article");
            request.setAttribute("contentPage", "./pages/article/article.jsp");

            request.getRequestDispatcher("./template.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String articleName = request.getParameter("articleName");
            String code = request.getParameter("articleCode");
            String description = request.getParameter("description");
            String category = request.getParameter("category");
            String tva = request.getParameter("tva");
            String price = request.getParameter("price");
            String unity = request.getParameter("unity");

            HttpSession session = request.getSession();
            String action = (String) session.getAttribute("action");

            if (action.equals("aucun") && request.getParameter("idArticle") == null || request.getParameter("idArticle").equals(String.valueOf(0))) { // pour l'insertion d'un nouveau article
                Article newArticle = new Article(code, description, articleName, price, category, tva, unity);
                GenericDAO.save(newArticle, null);
            } else { // modification d'un article
                int idArticle = Integer.valueOf(request.getParameter("idArticle"));
                String sql = "update article set code = '" + code + "', description = '" + description + "', designation = '" + articleName + "', price = " + price + ", id_category = " + category + ", tva = " + tva + ", id_unity=" + unity + ", status = 1 where id_article = '"+idArticle+"'";
                GenericDAO.directUpdate(sql, null);
            }
            response.sendRedirect("./article");
        } catch (Exception ex) {
            ex.printStackTrace();
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
