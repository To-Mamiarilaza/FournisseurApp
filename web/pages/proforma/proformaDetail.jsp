<%@page import=" model.proforma.ProformaRequest "%>
<!--  Header End -->
<% if(request.getAttribute("proformaRequest") != null) { 
ProformaRequest proformaRequest = (ProformaRequest)request.getAttribute("proformaRequest");
%>
<div class="container-fluid">
  <div class="card">
    <div class="card-body">
      <div class="row">
        <div class="col-md-12">
          <p><%=proformaRequest.getDateSendingFormatted() %></p>
        </div>
        <div class="col-md-6">
          <h5 class="card-title fw-semibold mb-4">Fournisseur</h5>
          <p class="mb-1">Nom : <strong class="mx-2"><%=proformaRequest.getSociety().getSociety() %></strong></p>
          <p class="mb-1">Adresse : <strong class="mx-2"><%=proformaRequest.getSociety().getSocietyAdresse() %></strong></p>
          <p class="mb-1">Contact du responsable : <strong class="mx-2"><%=proformaRequest.getSociety().getResponsableContact() %></strong></p>
          <p class="mb-1">Mail : <strong class="mx-2"><%=proformaRequest.getSociety().getMail() %></strong></p>
        </div>
        <div class="col-md-6">
          <h5 class="card-title fw-semibold mb-4">Client</h5>
          <p class="mb-1">Mail : <strong class="mx-2"><%=proformaRequest.getMailClient() %></strong></p>
        </div>
        <table class="table mt-5">
          <thead>
            <tr class="table-primary">
              <td class="py-2">Designation</td>
              <td class="py-2">Quantite</td>
              <td class="py-2">Quantite dispo</td>
              <td class="py-2">Prix Unitaire</td>
              <td class="py-2">TVA</td>
              <td class="py-2">Montant TVA</td>
              <td class="py-2">Montant HT</td>
              <td class="py-2">Montant TTC</td>
            </tr>
          </thead>
          <tbody>
            <tr>
            <% for(int i = 0; i < proformaRequest.getArticleQuantity().size(); i++) { %>
              <td class="py-2"><%=proformaRequest.getArticleQuantity().get(i).getArticle().getDesignation() %></td>
              <td class="py-2"><%=proformaRequest.getArticleQuantity().get(i).getQuantity() %></td>
              <td class="py-2"><%=proformaRequest.getArticleQuantity().get(i).getQuantityDispo() %></td>
              <td class="py-2"><%=proformaRequest.getArticleQuantity().get(i).getUnitPriceString() %></td>
              <td class="py-2"><%=proformaRequest.getArticleQuantity().get(i).getTVAString() %></td>
              <td class="py-2"><%=proformaRequest.getArticleQuantity().get(i).getMontantTVAString() %></td>
              <td class="py-2"><%=proformaRequest.getArticleQuantity().get(i).getMontantHTString() %></td>
              <td class="py-2"><%=proformaRequest.getArticleQuantity().get(i).getMontantTTCString() %></td>
            </tr>
            <% } %>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td class="py-2">TOTAL</td>
                <td class="py-2"><%= proformaRequest.getMontanTVATotalString() %></td>
                <td class="py-2"><%= proformaRequest.getMontantHTTotalString() %></td>
                <td class="py-2"><%= proformaRequest.getMontantTTCTotalString() %></td>
            </tr>
          </tbody>
        </table>
        <h6 class="mt-4">Arrête le présent proforma à  la somme de : <strong><%=proformaRequest.getMontantTotalLetter() %></strong></h6>
        <div class="mt-3">
          <a href="./PdfProformaRequest" class="btn btn-primary">Envoyer le proforma</a>
        </div>
      </div>
    </div>
  </div>
</div>
<% } %>