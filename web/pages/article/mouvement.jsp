<%@page import="java.util.List"%>
<%@page import="model.article.Article"%>
<%
    List<Article> articles = (List<Article>) request.getAttribute("articles");
%>
<div class="container-fluid">
    <div class="row justify-content-center">
        <div class="card col-md-6">
            <div class="card-body">
                <h5 class="card-title fw-semibold mb-4">Nouveau mouvement de stock</h5>
                <% if (request.getAttribute("error") != null) { %>
                <h6 class="card-title fw-semibold mb-4"> <%= (String) request.getAttribute("error") %> </h6>
                <% } %>
                <form action="./mouvement" class="form" method="post">
                    <div class="form-group mb-2">
                        <label for="form-label">Date</label>
                        <input type="date" name="date" class="form-control mt-2">
                    </div>
                    <div class="form-group mb-2">
                        <label for="form-label">Article</label>
                        <select name="article" id="" class="form-select mt-2">
                            <% for(int i=0;i<articles.size();i++) { %>
                            <option value="<%= articles.get(i).getIdArticle() %>"><%= articles.get(i).getDesignation() %></option>
                            <% } %>
                        </select>
                    </div>
                    <div class="form-group mb-2">
                        <label for="form-label">Type de mouvement</label>
                        <select name="movementType" id="" class="form-select mt-2">
                            <option value="1">Entree</option>
                            <option value="2">Sortie</option>
                        </select>
                    </div>
                    <div class="form-group mb-2">
                        <label for="form-label">Quantite</label>
                        <input type="number" name="quantity" class="form-control mt-2">
                    </div>
                    <div class="form-group mb-2">
                        <label for="form-label">Prix unitaire</label>
                        <input type="number" name="unitPrice" class="form-control mt-2">
                    </div>
                    <input type="submit" class="btn btn-info mt-2 px-5 w-100 py-2 fs-4" value="Valider">
                </form>
            </div>
        </div>
    </div>
</div>