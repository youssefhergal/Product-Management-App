<%--
  Created by IntelliJ IDEA.
  User: youssef-hergal
  Date: 11/25/2023
  Time: 1:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="resources/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="card text-white">
        <div class="card-header text-center bg-primary">Recherche des produits</div>
        <div class="card-body">
            <form action="chercher.do" method="get" class="row g-2">
                <div class="col-md-1">
                    <label for="motCle" class="form-label text-dark">Mot Cle</label>
                </div>
                <div class="col-md-3">
                    <input id="motCle" type="text" name="motCle" class="form-control">
                </div>
                <div class="col-md-4">
                    <button type="submit" class="btn btn-primary">Chercher</button>
                </div>
            </form>

            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>DESIGNATION</th>
                    <th>PRIX</th>
                    <th>QUANTITE</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${model.produits}" var="p">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.designation}</td>
                        <td>${p.prix}</td>
                        <td>${p.quantite}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>

