<%@page import="java.util.List"%>
<%@page import="model.article.Article"%>
<%
    List<Article> articles = (List<Article>) request.getAttribute("articles");
    if(request.getParameter("article") != null){
    }
%>
<div class="container-fluid">
    <div class="card">
        <div class="card-body">
            <div class="col-md-8">
                <h5 class="card-title fw-semibold mb-4">Etat de stock</h5>
                <form action="./etat-stock" method="post">
                    <div class="row justify-content-end">
                        <div class="col-md-5 form-group">
                            <label for="">Date Fin</label>
                            <input type="date" name="date" class="mt-2 form-control">
                        </div>
                        <div class="col-md-5 form-group">
                            <label for="article">Article</label>
                            <select name="article" id="article" class="form-select mt-2">
                                <% for(int i=0;i<articles.size();i++) { %>
                                <option value="<%= articles.get(i).getIdArticle() %>"><%= articles.get(i).getDesignation() %></option>
                                <% } %>
                            </select>
                        </div>
                        <div class="col-md-2 form-group d-flex align-items-end">
                            <input type="submit" class="btn btn-primary px-4" value="Valider">
                        </div>
                    </div>
                </form>
            </div>
            <% if(request.getParameter("article") != null && request.getAttribute("reste") !=null && request.getAttribute("prixUnitaire") !=null && request.getAttribute("montant") !=null) {  
                Article article = (Article) request.getAttribute("article");
                double reste = (Double) request.getAttribute("reste");
                double prixUnitaire = (Double) request.getAttribute("prixUnitaire");
                double montant = (Double) request.getAttribute("montant");
            %>
            <table class="table mt-5">
                <thead>
                    <tr>
                        <td>Article</td>
                        <td>Reste</td>
                        <td>Prix Unitaire</td>
                        <td>Montant</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> <%= article.getDesignation() %> </td>
                        <td> <%= reste %> </td>
                        <td> <%= prixUnitaire %> AR</td>
                        <td> <%= montant %> AR</td>
                    </tr>

                    <!--                     LIGNE MONTRANT LE TOTAL 
                                        <tr class="table-primary">
                                            <td></td>
                                            <td></td>
                                            <td>MONTANT TOTAL</td>
                                            <td>60 000 AR</td>
                                        </tr>
                                         LIGNE MONTRANT LE TOTAL -->
                </tbody>
            </table>
            <% } %>
        </div>
    </div>
</div>