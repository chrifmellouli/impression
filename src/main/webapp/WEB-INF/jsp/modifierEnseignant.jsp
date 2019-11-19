<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier un enseignant</title>
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
				<form class="form-horizontal" action="ModifierEnseignant/Modifier">
					<fieldset>
						<!-- Form Name -->
						<legend>Modifier Un Enseignant</legend>
						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="id">ID</label>
							<div class="col-md-5">
								<input id="id" name="id" type="text"
									placeholder="ID de l'enseignant" class="form-control input-md"
									required="required" value="${enseignant.idEnseignant}">
							</div>
						</div>
						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="nom">Nom</label>
							<div class="col-md-5">
								<input id="nom" name="nom" type="text"
									placeholder="Nom de l'enseignant" class="form-control input-md"
									required="required" value="${enseignant.nom}">
							</div>
						</div>
						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="prenom">Prenom</label>
							<div class="col-md-5">
								<input id="prenom" name="prenom" type="text"
									placeholder="Prenom de l'enseignant"
									class="form-control input-md" required="required"
									value="${enseignant.prenom}">
							</div>
						</div>
						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="departement">Département</label>
							<div class="col-md-5">
								<input id="departement" name="departement" type="text"
									placeholder="Département de l'enseignant"
									class="form-control input-md" required="required"
									value="${enseignant.departement}">
							</div>
						</div>
						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="login">Login</label>
							<div class="col-md-5">
								<input id="login" name="login" type="text"
									placeholder="Login de l'enseignant"
									class="form-control input-md" required="required"
									value="${enseignant.login}">
							</div>
						</div>
						<!-- Password input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="motdepasse">Mot
								de passe</label>
							<div class="col-md-5">
								<input id="motdepasse" name="motdepasse" type="password"
									placeholder="Mot de passe de l'enseignant"
									class="form-control input-md" required="required"
									value="${enseignant.motDePasse}">
							</div>
						</div>
						<!-- Button (Double) -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="button1id">Submit</label>
							<div class="col-md-8">
								<button id="button1id" name="button1id" class="btn btn-success"
									type="submit">Modifier</button>
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