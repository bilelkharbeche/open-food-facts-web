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
<title>Open Food Fact</title>
<script>
function selectMarques(){
	document.location.href="http://localhost:8080/OFFW/rechercher?marqueSelect="+ document.forms[0].catSelect.value;
}
</script>
</head>
<body>

	<div class="container-fluid text-center mt-5">
		<div class="row">
			<form
				class="col-sm-4 mx-auto border shadow p-3 mb-5 bg-white rounded"
				method="POST" action="http://localhost:8080/OFFW/rechercher">
				<div class="form-group">
					<select class="custom-select mr-sm-2" id="categorie"
						name="catSelect" onchange="selectMarques()">

						<%
							List<Categorie> listeCat = (List<Categorie>) request.getAttribute("categorie");
							Integer marqueSelect = (Integer)request.getAttribute("marqueSelect");
							for (Categorie cate : listeCat) {
								if (cate.getId()==marqueSelect) {
						%>
									<option value="<%=cate.getId()%>" selected><%=cate.getNom()%></option>
							<%
								}
								else { %>
									<option value="<%=cate.getId()%>"><%=cate.getNom()%></option>
							<%	}
							}
						%>
					</select>
				</div>

				<div class="form-group">
					<select class="custom-select mr-sm-2" id="marque"
						name="marqueSelect">

						<%
							List<Marque> listeMarque = (List<Marque>) request.getAttribute("marque");
							if (listeMarque!=null) {
								for (Marque marque : listeMarque) {
							%>
								<option value="<%=marque.getId()%>"><%=marque.getNom()%></option>
							<%
								}
							}
							%>
					</select>
				</div>

				<div class="form-group">
					<input type="text" class="form-control" id="nomProduit"
						placeholder="nom du produit">						
				</div>
				
				<div class="form-group">
					<div class="form-row">
						<div class="col">
							<input type="text" class="form-control"
								placeholder="Protéine minimum">
						</div>
						<div class="col">
							<input type="text" class="form-control"
								placeholder="Protéine maximum"> 
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="form-row">
						<div class="col">
							<input type="text" class="form-control"
								placeholder="Graisse minimum">
						</div>
						<div class="col">
							<input type="text" class="form-control"
								placeholder="Graisse maximum">
						</div>
					</div>
				</div>
				<input type="submit" class="btn btn-outline-success" id="bouton"
					name="rechercher" value="Rechercher">
			</form>
		</div>
	</div>

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