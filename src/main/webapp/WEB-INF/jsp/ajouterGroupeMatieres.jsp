<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter une matiere pour groupe</title>
<link href="/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
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
											type="submit" class="form-control input-md"
											value="Déconnexion" />
									</fieldset>
								</form>
							</td>
						</tr>
					</table>
				</div>
				<hr>
				<form class="form-horizontal"
					action="/GroupeMatieres/${groupe.idGroupe}/ajouterGroupeMatieres/Ajouter"
					method="post">
					<fieldset>
						<!-- Form Name -->
						<legend>Ajouter Une Matiere pour le groupe
							${groupe.designation}</legend>
						<div class="form-group">
							<label class="col-md-4 control-label" for="designation">Matière</label>
							<div class="col-md-4">
								<select id="idmatiere" name="idmatiere" class="form-control">
									<c:forEach items="${matieres}" var="matiere">
										<option value="${matiere.idMatiere}">${matiere.designation}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<input style="display: none;" name="idgroupe" id="idgroupe"
							value="${groupe.idGroupe}" />
						<!-- Button (Double) -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="button1id">Submit</label>
							<div class="col-md-8">
								<button id="button1id" name="button1id" class="btn btn-success"
									type="submit">Ajouter</button>
								<button id="button2id" name="button2id" class="btn btn-danger"
									type="reset">Annuler</button>
							</div>
						</div>

					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/jquery.min.js"></script>
</body>
</html>