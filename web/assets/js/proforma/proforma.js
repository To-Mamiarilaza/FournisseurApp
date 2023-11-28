function getArticleTemplate(article, quantity) {
    return `
         <tr class="article">
            <td>`+article+`</td>
            <td>`+quantity+`</td>
            <td>
                <a type="button" onclick="deleteProforma(this)" class="text-danger">
                    Annuler
                </a>
            <td>
        </tr>
    `;
}


// fonction pour ajouter une nouvelle question
function addNewArticle() {
    var articleValue = $('#articleInput').val();
    var quantiteValue = $('#quantiteInput').val();
    
    // envoyer une ajax vers le controller
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/FournisseurApp/ProformaArticleInsertion',
        data: {
            article: articleValue,
            quantity: quantiteValue
        },
        dataType: 'text',
        success: function (response) {
              var responseJson = JSON.parse(response);
              if(responseJson.error != null) {
                  console.log(responseJson.error);
              } else {
                  console.log(responseJson);
                  if(responseJson.exist == true) {
                      updateTableListArticle(responseJson.article, responseJson.quantity);
                  } else {
                      
                        // add template to the quiz container
                        var articleList = $('#articleList');
                        var articleTemplate = $(getArticleTemplate(responseJson.article, responseJson.quantity));
                        articleList.append(articleTemplate);
                        articleTemplate.attr('id', responseJson.code);        // Redonner l'ID aux nouvelles éléments
                  }
              }
        },
        error: function (response) {
            console.log("ERREUR , voici la reponse");
            console.log("TEXT : " + response);
            var jsonResponse = JSON.parse(response);
            console.log("JSON : " + jsonResponse);
        }
    });
}

//Fonction pour changer les valeurs du table article ajoutes
function updateTableListArticle(article, quantity) {
    // Obtenez la référence de l'élément table par son ID
    var articleList = document.getElementById('articleList');

    // Vérifiez si l'élément avec l'ID spécifié existe
    if (articleList) {
        // Obtenez toutes les lignes de la table (éléments tr)
        var rows = articleList.getElementsByTagName('tr');
console.log(rows.length);
        // Parcourez toutes les lignes de la table
        for (var i = 0; i < rows.length; i++) {
            // Obtenez toutes les cellules de la ligne actuelle (éléments td)
            var cells = rows[i].getElementsByTagName('td');
            console.log(article);
            console.log("Tissu"+cells[1].textContent);
            if(cells[0].textContent == article) {
                console.log(article);
                console.log(cells[0].textContent);
                cells[1].textContent = quantity;
            }
        }
    } else {
        console.log("L'élément avec l'ID 'articleList' n'a pas été trouvé.");
    }
}


// fonction pour supprimé un article ajoute
function deleteProforma(bouton) {
    var article = bouton.closest('.article');
    var id = article.id;
    console.log(id);
    // Ensuite supprimé du session
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FournisseurApp/DeleteProforma',
        data: {
            code: id
        },
        success: function (reponse) {
            article.remove();
        },
        error: function () {
            alert("Une erreur est survenue lors du suppression !");
        }
    });
}