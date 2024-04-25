<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<meta http-equiv="Content-Type"  charset="utf-8">
<title>Produit</title>
</head>
<body>
<div class="container ">
	<div class="card bg-primary text-white">
   <div class="card-header ">
   recherche les produit
   </div>
   <div class="card-body bg-white">
   <form action="chercher.do" method="get">
   <label style="color:black">Mot cle</label>
   <input type="text" name="motCle"/>
   <button type="submit" class="btn btn-primary">Chercher</button>
   </form>
  <table class="table">
    <thead>
        <tr>
            <th>ID</th>
            <th>Designation</th>
            <th>Prix</th>
            <th>Quantite</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="produit" items="${produit.produits}">
            <tr>
                <td>${produit.id}</td>
                <td>${produit.designation}</td>
                <td>${produit.prix}</td>
                <td>${produit.quantite}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

   </div>
</div>
</div>

</body>
</html>