<%@page import="java.util.List"%>
<%@page import="model.article.Category"%>
<%@page import="model.article.Article"%>
<%@page import="model.article.Unity"%>
<%
    List<Article> articles = (List<Article>) request.getAttribute("articles");
    List<Category> categories = (List<Category>) request.getAttribute("categories");
    List<Unity> unities = (List<Unity>) request.getAttribute("unities");
    Article article = (Article) request.getAttribute("concernedArticle");
%>

<!--  Header End -->
<div class="container-fluid">
    <div class="row mt-5">
        <% if(articles.size() > 0) { %>
        <div class="col-md-8">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title fw-semibold mb-4">Liste des articles</h5>
                    <div class="row">
                        <table class="table table-striped align-middle">
                            <thead>
                                <tr>
                                    <td>#</td>
                                    <td>Nom</td>
                                    <td>Categorie</td>
                                    <td>Prix</td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody>
                                <% for(int i=0; i<articles.size(); i++) { %>
                                <tr>
                                    <td><%= articles.get(i).getIdArticle() %></td>
                                    <td><%= articles.get(i).getDesignation() %></td>
                                    <td><%= articles.get(i).getCategory().getDesignation() %></td>
                                    <td><%= articles.get(i).getPrice() %> AR</td>
                                    <td><a href="./article?idArticle=<%= articles.get(i).getIdArticle() %>" class="btn btn-info btn-sm">Modifier</a></td>
                                </tr>
                                <% } %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <% } %>
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title fw-semibold mb-4">Nouvelle article</h5>
                    <form action="./article" class="form" method="post">
                        <div class="form-group mb-2">
                            <label for="form-label">Nom de l'article</label>
                            <input type="text" name="articleName" class="form-control mt-2" value="<%= article.getDesignation() %>">
                        </div>
                        <div class="form-group mb-2">
                            <label for="form-label">code</label>
                            <input type="text" name="articleCode" class="form-control mt-2" value="<%= article.getCode() %>">
                        </div>
                        <div class="form-group mb-2">
                            <label for="form-label">Description</label>
                            <textarea id="id" name="description" rows="5" cols="10" class="form-control mt-2" value="<%= article.getDescription() %>"></textarea>
                        </div>
                        <div class="form-group mb-2">
                            <label for="form-label">Categorie</label>
                            <select name="category" id="" class="form-select mt-2">
                                <% for(int i=0;i<categories.size(); i++) { %>
                                <option value="<%= categories.get(i).getIdCategory() %>"> <%= categories.get(i).getDesignation() %> </option>
                                <% } %>
                            </select>
                        </div>
                        <div class="form-group mb-2">
                            <label for="form-label">Unité</label>
                            <select name="unity" id="" class="form-select mt-2">
                                <% for(int i=0;i<unities.size(); i++) { %>
                                <option value="<%= unities.get(i).getIdUnity() %>"> <%= unities.get(i).getName() %> </option>
                                <% } %>
                            </select>
                        </div>
                            <input type="hidden" name="idArticle" value="<%= article.getIdArticle() %>">
                        <div class="form-group mb-2">
                            <label for="form-label">TVA de l'article</label>
                            <input type="number" name="tva" class="form-control mt-2" value="<%= article.getTva() %>">
                        </div>
                        <div class="form-group mb-2">
                            <label for="form-label">Prix HT de l'article</label>
                            <input type="number" name="price" class="form-control mt-2" value="<%= article.getPrice() %>">
                        </div>
                        <input type="submit" class="btn btn-info mt-2 px-5 w-100 py-2 fs-4" value="Valider">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>