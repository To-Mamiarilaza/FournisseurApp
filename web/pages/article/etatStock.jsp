<div class="container-fluid">
    <div class="card">
        <div class="card-body">
            <div class="col-md-8">
                <h5 class="card-title fw-semibold mb-4">Etat de stock</h5>
                <form action="">
                    <div class="row justify-content-end">
                        <div class="col-md-5 form-group">
                            <label for="">Date Fin</label>
                            <input type="date" name="date" class="mt-2 form-control">
                        </div>
                        <div class="col-md-5 form-group">
                            <label for="">Article</label>
                            <input type="text" name="article" class="mt-2 form-control">
                        </div>
                        <div class="col-md-2 form-group d-flex align-items-end">
                            <input type="submit" class="btn btn-primary px-4" value="Valider">
                        </div>
                    </div>
                </form>
            </div>

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
                        <td>Cache bouche</td>
                        <td>30</td>
                        <td>300</td>
                        <td>60 000 AR</td>
                    </tr>

                    <!-- LIGNE MONTRANT LE TOTAL -->
                    <tr class="table-primary">
                        <td></td>
                        <td></td>
                        <td>MONTANT TOTAL</td>
                        <td>60 000 AR</td>
                    </tr>
                    <!-- LIGNE MONTRANT LE TOTAL -->
                </tbody>
            </table>
        </div>
    </div>
</div>