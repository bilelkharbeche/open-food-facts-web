<%@ page language="java" pageEncoding="UTF-8"
	import="java.util.List, java.util.ArrayList, fr.diginamic.modele.*, fr.diginamic.controllers.*, fr.diginamic.dao.*, fr.diginamic.exception.*"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Open Food Fact Item</title>
</head>
<body>

	<table class="table table-dark mx-auto col-sm-6">
		<thead>
			<tr>
				<th scope="col">Nom du Produit</th>
				<th scope="col">Graisse (g)</th>
				<th scope="col">Sucre (g)</th>
				<th scope="col">Fibre (g)</th>
				<th scope="col">Protéine (g)</th>
				<th scope="col">Sel (g)</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Produit> listeProduit = (List<Produit>) request.getAttribute("produit");

				for (Produit produit : listeProduit) {
			%>
			<tr>
				<td><%=produit.getNom()%></td>
				<td><%=produit.getGraisse()%></td>
				<td><%=produit.getSucre()%></td>
				<td><%=produit.getFibre()%></td>
				<td><%=produit.getProteine()%></td>
				<td><%=produit.getSel()%></td>
				<%
					}
				%>
			
		</tbody>
	</table>



	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>