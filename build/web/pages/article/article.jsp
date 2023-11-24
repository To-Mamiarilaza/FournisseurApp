<!--  Header End -->
<div class="container-fluid">
    <div class="row mt-5">
        <div class="col-md-8">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title fw-semibold mb-4">Liste des articles</h5>
                    <div class="row">
                        <table class="table table-striped align-middle">
                            <thead>
                                <tr>
                                    <td>ID Article</td>
                                    <td>Nom</td>
                                    <td>Categorie</td>
                                    <td>Prix</td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>#1</td>
                                    <td>Savon</td>
                                    <td>Produits hygiénique</td>
                                    <td>12 000 AR</td>
                                    <td><a href="#" class="btn btn-info btn-sm">Modifier</a></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title fw-semibold mb-4">Nouvelle article</h5>
                    <form action="" class="form">
                        <div class="form-group mb-2">
                            <label for="form-label">Nom de l'article</label>
                            <input type="text" name="articleName" class="form-control mt-2">
                        </div>
                        <div class="form-group mb-2">
                            <label for="form-label">Description</label>
                            <input type="text" name="description" class="form-control mt-2">
                        </div>
                        <div class="form-group mb-2">
                            <label for="form-label">Categorie</label>
                            <select name="categorie" id="" class="form-select mt-2">
                                <option value="">Produits hygienique</option>
                                <option value="">Fourniture de bureau</option>
                            </select>
                        </div>
                        <div class="form-group mb-2">
                            <label for="form-label">Prix HT de l'article</label>
                            <input type="number" name="articlePrice" class="form-control mt-2">
                        </div>
                        <input type="submit" class="btn btn-info mt-2 px-5 w-100 py-2 fs-4" value="Valider">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>