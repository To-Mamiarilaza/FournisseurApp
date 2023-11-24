<div class="container-fluid">
  <div class="row justify-content-center">
    <div class="card col-md-6">
      <div class="card-body">
        <h5 class="card-title fw-semibold mb-4">Nouvelle mouvement de stock</h5>
        <form action="" class="form">
          <div class="form-group mb-2">
            <label for="form-label">Date</label>
            <input type="date" name="date" class="form-control mt-2">
          </div>
          <div class="form-group mb-2">
            <label for="form-label">Article</label>
            <select name="article" id="" class="form-select mt-2">
              <option value="">Savon</option>
              <option value="">Cache bouche</option>
            </select>
          </div>
          <div class="form-group mb-2">
            <label for="form-label">Type de mouvement</label>
            <select name="movementType" id="" class="form-select mt-2">
              <option value="">Entree</option>
              <option value="">Sortie</option>
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