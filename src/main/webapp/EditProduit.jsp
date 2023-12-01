
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter Produit</title>
    <link rel="stylesheet" href="resources/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container col-md-8 col-md-offset-2">
    <div class="card text-white">
        <div class="card-header text-center bg-primary">Ajouter produit</div>
        <div class="card-body">
            <form action="UpdateProduit.php" method="post">

                <div class="form-group">
                    <label for="id" class="control-label text-dark">Id</label>
                    <input type="text" id="id" name="id"  value="${produit.id}" class="form-control"/>
                    <span></span>
                </div>

                <div class="form-group">
                    <label for="designation" class="control-label text-dark">Désignation</label>
                    <input type="text" id="designation" name="designation"  value="${produit.designation}" class="form-control"/>
                    <span></span>
                </div>

                <div class="form-group">
                    <label for="quantite" class="control-label text-dark">Quantite</label>
                    <input type="text" id="quantite"value="${produit.quantite}" name="quantite" class="form-control"/>
                    <span></span>
                </div>

                <div class="form-group">
                    <label for="prix" class="control-label text-dark">Prix</label>
                    <input type="text" id="prix" name="prix" value="${produit.prix}" class="form-control"/>
                    <span></span>
                </div>
                <button type="submit" class="btn btn-primary">Ajouter</button>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
