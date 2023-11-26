<!--  Header End -->
<div class="container-fluid">
    <div class="row justify-content-center">
        <div class="col-lg-10 d-flex align-items-stretch">
            <div class="card w-100">
                <div class="card-body p-4">
                    <h5 class="card-title fw-semibold mb-4">Envoyer proforma</h5>
                    <form action="./proforma-detail">
                        <div class="col-md-7 mb-4">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Mail du client" name="email">
                            </div>
                            <div class="form-group mt-4">
                                <div class="row">
                                    <div class="col-md-5">
                                        <select name="" class="form-select" id="">
                                            <option value="">Cache bouche</option>
                                            <option value="">Brosse à dent</option>
                                        </select>
                                    </div>
                                    <div class="col-md-5">
                                        <input type="number" class="form-control">
                                    </div>
                                    <div class="col-md-2">
                                        <input type="button" class="btn btn-info" value="Ajouter">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table text-nowrap mb-0 align-middle">
                                <thead class="text-dark fs-4">
                                    <tr>
                                        <th class="border-bottom-0">
                                            <h6 class="fw-semibold mb-0">Article</h6>
                                        </th>
                                        <th class="border-bottom-0">
                                            <h6 class="fw-semibold mb-0">Quantite</h6>
                                        </th>
                                        <th class="border-bottom-0">
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="border-bottom-0 py-0">
                                            <h6 class="fw-semibold mb-0">Cache bouche</h6>
                                        </td>
                                        <td class="border-bottom-0 py-0">
                                            <h6 class="fw-semibold mb-1">30</h6>
                                        </td>
                                        <td class="border-bottom-0 py-0">
                                            <h6 class="fw-semibold mb-0 fs-4"><a href="../../article-mapping"
                                                    class="btn btn-danger btn-sm">Annuler</a></h6>
                                        </td>
                                    </tr>
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