<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un groupe</title>
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
											type="submit" class="form-control input-md" value="Déconnexion" />
									</fieldset>
								</form>
							</td>								
						</tr>
					</table>
				</div>
				<hr>
				<form class="form-horizontal" action="/Groupes/ajouterGroupe/Ajouter"
					method="post">
					<fieldset>
						<!-- Form Name -->
						<legend>Ajouter Un Groupe</legend>
						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="designation">Designation</label>
							<div class="col-md-5">
								<input id="designation" name="designation" type="text"
									placeholder="Designation du groupe" class="form-control input-md"
									required="required">
							</div>
						</div>
						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="nombredesetudiants">Nombre des étudiants</label>
							<div class="col-md-5">
								<input id="nombredesetudiants" name="nombredesetudiants" type="text"
									placeholder="Nombre des etudiants du groupe"
									class="form-control input-md" required="required">
							</div>
						</div>
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