
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
    <link rel="stylesheet" href="resources/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container mt-4 col-offset-2">
    <div class="card text-dark">
        <div class="card-header text-center bg-primary">Confirmation</div>
        <div class="card-body">
            <dl class="row">
                <dt class="col-sm-3">Id</dt>
                <dd class="col-sm-9">${produit.id}</dd>

                <dt class="col-sm-3">Designation</dt>
                <dd class="col-sm-9">${produit.designation}</dd>

                <dt class="col-sm-3">Prix</dt>
                <dd class="col-sm-9">${produit.prix}</dd>

                <dt class="col-sm-3">Quantite</dt>
                <dd class="col-sm-9">${produit.quantite}</dd>
            </dl>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
