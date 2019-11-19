package com.plateform.impression.controller;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.plateform.impression.dao.EnseignantDao;
import com.plateform.impression.model.Enseignant;

@Controller
public class EnseignantController {

	public static final String HOME_PAGE_ENSEIGNANTS = "listeEnseignants";
	public static final String LOGIN = "login";
	public static final String MOTDEPASSE = "motdepasse";
	public static final String ENSEIGNANTS = "enseignants";
	protected EnseignantDao enseignantDao;

	@Autowired
	EnseignantController(EnseignantDao enseignantDao) {
		this.enseignantDao = enseignantDao;
	}

	@GetMapping(value = "/Enseignants")
	public String listeEnseignants(ModelMap modelMap) {
		List<Enseignant> enseignants = enseignantDao.findAll();
		modelMap.addAttribute(ENSEIGNANTS, enseignants);
		return HOME_PAGE_ENSEIGNANTS;
	}

	@GetMapping(value = "/Enseignants/ajouterEnseignant")
	public String ajouterEnseignant(ModelMap modelMap) {
		return "ajouterEnseignant";
	}

	@PostMapping(value = "/Enseignants/ajouterEnseignant/Ajouter")
	public String ajouterEnseignant(ServletRequest request,ModelMap modelMap) {
		Enseignant enseignant = new Enseignant();
		enseignant.setLogin(request.getParameter(LOGIN));
		enseignant.setMotDePasse(request.getParameter(MOTDEPASSE));
		enseignant.setNom(request.getParameter("nom"));
		enseignant.setPrenom(request.getParameter("prenom"));
		enseignant.setDepartement(request.getParameter("departement"));
		enseignantDao.save(enseignant);
		modelMap.addAttribute(ENSEIGNANTS, enseignantDao.findAll());		
		return HOME_PAGE_ENSEIGNANTS;
	}

	@GetMapping(value = "/Enseignants/{id}/Supprimer")
	public String supprimerEnseignant(@PathVariable int id,ModelMap modelMap) {
		enseignantDao.deleteById(id);
		modelMap.addAttribute(ENSEIGNANTS, enseignantDao.findAll());		
		return HOME_PAGE_ENSEIGNANTS;
	}

	@GetMapping(value = "/Enseignants/{id}/ModifierEnseignant")
	public String updateEnseignant(@PathVariable int id, ModelMap modelMap) {
		Enseignant enseignant = enseignantDao.findById(id);
		modelMap.addAttribute("enseignant", enseignant);
		return "modifierEnseignant";
	}

	@GetMapping(value = "/Enseignants/{id}/ModifierEnseignant/Modifier")
	public String updateEnseignant(ServletRequest request, @PathVariable int id,ModelMap modelMap) {
		Enseignant enseignant = enseignantDao.findById(id);
		enseignant.setLogin(request.getParameter(LOGIN));
		enseignant.setMotDePasse(request.getParameter(MOTDEPASSE));
		enseignant.setNom(request.getParameter("nom"));
		enseignant.setPrenom(request.getParameter("prenom"));
		enseignant.setDepartement(request.getParameter("departement"));
		enseignantDao.save(enseignant);
		modelMap.addAttribute(ENSEIGNANTS, enseignantDao.findAll());		
		return HOME_PAGE_ENSEIGNANTS;
	}

	@GetMapping(value = "/Enseignant/Authentification")
	public String sAuthentifier(ServletRequest request, ModelMap modelMap) {
		Enseignant enseignant = enseignantDao.findByLoginAndMotDePasse(request.getParameter(LOGIN),
				request.getParameter(MOTDEPASSE));
		if (enseignant == null) {
			modelMap.addAttribute("erreur", "Veuillez vérifier vos paramètres d'authentification");
			return "enseignant_cnx";
		} else {
			modelMap.addAttribute("enseignant", enseignant);
			return "tableau_ens";
		}
	}

}
