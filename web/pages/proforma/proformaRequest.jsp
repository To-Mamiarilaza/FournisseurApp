<%@page import=" java.util.ArrayList "%>
<%@page import=" model.article.Article "%>
<!--  Header End -->
<div class="container-fluid">
    <div class="row justify-content-center">
        <div class="col-lg-10 d-flex align-items-stretch">
            <div class="card w-100">
                <div class="card-body p-4">
                    <h5 class="card-title fw-semibold mb-4">Envoyer proforma</h5>
                    <form action="./proforma-detail" method="POST">
                        <div class="col-md-7 mb-4">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Mail du client" name="email">
                            </div>
                            <div class="form-group mt-4">
                                <div class="row">
                                    <div class="col-md-5">
                                         <% if(request.getAttribute("articles") != null) { 
                                            ArrayList<Article> articles = (ArrayList<Article>)request.getAttribute("articles");
                                        %>
                                        <select name="article" class="form-select" id="articleInput">
                                            <% for(int i = 0; i < articles.size(); i++) { %>
                                            <option value="<%=articles.get(i).getIdArticle() %>"><%=articles.get(i).getDesignation() %></option>
                                            <% } %>
                                        </select>
                                        <% } %>
                                    </div>
                                    <div class="col-md-5">
                                        <input type="number" class="form-control" name="quantity" id="quantiteInput">
                                    </div>
                                    <div class="col-md-2">
                                        <input onclick="addNewArticle()" type="button" class="btn btn-info" value="Ajouter">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table text-nowrap mb-0 align-middle" id="articleList">
                                <tbody>
                                    
                                </tbody>
                            </table>
                        </div>
                        <input type="submit" class="btn btn-primary px-5 mx-3 my-4" value="Envoyer">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>