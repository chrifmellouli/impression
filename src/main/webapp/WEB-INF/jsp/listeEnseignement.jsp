<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste deEnseignement pour un enseignant</title>
<link href="/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<hr>
				<h3 class="text-danger text-center">Tableau d'administration</h3>
				<hr>
				<div class="table-responsive">
					<table id="mytable" class="table table-bordred table-striped">
						<tr>
							<td>
								<form action="/Enseignants">
									<fieldset>
										<label for="sub"></label> <input name="sub" id="sub"
											type="submit" class="form-control input-md"
											value="Enseignants" />
									</fieldset>
								</form>
							</td>
							<td>
								<form action="/AgentsDeTirage">
									<fieldset>
										<label for="sub"></label> <input name="sub" id="sub"
											type="submit" class="form-control input-md"
											value="Agents de tirage" />
									</fieldset>
								</form>
							</td>
							<td>
								<form action="/Matieres">
									<fieldset>
										<label for="sub"></label> <input name="sub" id="sub"
											type="submit" class="form-control input-md" value="Matieres" />
									</fieldset>
								</form>
							</td>
							<td>
								<form action="/Groupes">
									<fieldset>
										<label for="sub"></label> <input name="sub" id="sub"
											type="submit" class="form-control input-md" value="Groupes" />
									</fieldset>
								</form>
							</td>
							<td>
								<form action="/">
									<fieldset>
										<label for="sub"></label> <input name="sub" id="sub"
											type="submit" class="form-control input-md" value="D�connexion" />
									</fieldset>
								</form>
							</td>								
						</tr>
					</table>
				</div>
				<hr>
				<form action="/Enseignements/${enseignant.idEnseignant}/ajouterGroupeMatieres">
					<div class="form-group">
						<br>
						<hr>
						<label for="sub">Liste Des Matieres Pour Le Enseignant ${enseignant.nom} ${enseignant.prenom}</label> <input name="sub"
							id="sub" type="submit" class="btn btn-success btn-xs"
							value="Ajouter" />
					</div>
				</form>
				<div class="table-responsive">
					<table id="mytable" class="table table-bordred table-striped">
						<thead>
							<th>Mati�res</th>
							<th>Groupe</th>
							<th>Annee Universitaire</th>
							<th></th>
						</thead>
						<tbody>
							<c:forEach items="${enseigners}" var="enseigner">
								<tr>
									<td>${enseigner.enseignerPK.groupeMatiere.groupeMatierePK.matiere.designation}</td>
									<td>${enseigner.enseignerPK.groupeMatiere.groupeMatierePK.groupe.designation}</td>
									<td>${enseigner.anneeUniversitaire}</td>									
									<td>
										<form
											action="/Enseignements/${enseignant.idEnseignant}/${enseigner.enseignerPK.groupeMatiere.groupeMatierePK.matiere.idMatiere}/${enseigner.enseignerPK.groupeMatiere.groupeMatierePK.groupe.idGroupe}/Supprimer">
											<p data-placement="top" data-toggle="tooltip" title="Delete">
												<button class="btn btn-danger btn-xs" type="submit">
													Delete</button>
											</p>
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<script src="/js/1.9.1/jquery.min.js"></script>
</body>
</html>