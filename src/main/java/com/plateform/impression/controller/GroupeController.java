package com.plateform.impression.controller;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.plateform.impression.dao.GroupeDao;
import com.plateform.impression.model.Groupe;

@Controller
public class GroupeController {

	public static final String HOME_PAGE_GROUPES = "listeGroupes";
	public static final String GROUPES = "groupes";
	protected GroupeDao groupeDao;

	@Autowired
	GroupeController(GroupeDao groupeDao) {
		this.groupeDao = groupeDao;
	}

	@GetMapping(value = "/Groupes")
	public String listeGroupes(ModelMap modelMap) {
		List<Groupe> groupes = groupeDao.findAll();
		modelMap.addAttribute(GROUPES, groupes);
		return HOME_PAGE_GROUPES;
	}

	@GetMapping(value = "/Groupes/ajouterGroupe")
	public String ajouterGroupe(ModelMap modelMap) {
		return "ajouterGroupe";
	}

	@PostMapping(value = "/Groupes/ajouterGroupe/Ajouter")
	public String ajouterGroupe(ServletRequest request, ModelMap modelMap) {
		Groupe groupe = new Groupe();
		groupe.setDesignation(request.getParameter("designation"));
		try {
			groupe.setNombreEtudiants(Integer.parseInt(request.getParameter("nombredesetudiants")));
		} catch (NumberFormatException e) {
			groupe.setNombreEtudiants(0);
		}
		groupeDao.save(groupe);
		modelMap.addAttribute(GROUPES, groupeDao.findAll());
		return HOME_PAGE_GROUPES;
	}

	@GetMapping(value = "Groupes/{id}/Supprimer")
	public String supprimerGroupe(@PathVariable int id, ModelMap modelMap) {
		groupeDao.deleteById(id);
		modelMap.addAttribute(GROUPES, groupeDao.findAll());
		return HOME_PAGE_GROUPES;
	}

	@GetMapping(value = "Groupes/{id}/ModifierGroupe")
	public String updateGroupe(@PathVariable int id, ModelMap modelMap) {
		Groupe groupe = groupeDao.findById(id);
		modelMap.addAttribute("groupe", groupe);
		return "modifierGroupe";
	}

	@GetMapping(value = "Groupes/{id}/ModifierGroupe/Modifier")
	public String updateGroupeupdateGroupe(ServletRequest request, @PathVariable int id, ModelMap modelMap) {
		Groupe groupe = groupeDao.findById(id);
		groupe.setDesignation(request.getParameter("designation"));
		try {
			groupe.setNombreEtudiants(Integer.parseInt(request.getParameter("nombredesetudiants")));
		} catch (NumberFormatException e) {
			groupe.setNombreEtudiants(0);
		}
		groupeDao.save(groupe);
		modelMap.addAttribute(GROUPES, groupeDao.findAll());
		return HOME_PAGE_GROUPES;
	}

}
