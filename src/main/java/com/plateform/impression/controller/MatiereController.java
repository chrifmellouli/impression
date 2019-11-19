package com.plateform.impression.controller;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.plateform.impression.dao.MatiereDao;
import com.plateform.impression.model.Matiere;

@Controller
public class MatiereController {

	public static final String HOME_PAGE_MATIERES = "listeMatieres";
	public static final String MATIERES = "matieres";
	protected MatiereDao matiereDao;

	@Autowired
	MatiereController(MatiereDao matiereDao) {
		this.matiereDao = matiereDao;
	}

	@GetMapping(value = "/Matieres")
	public String listeMatieres(ModelMap modelMap) {
		List<Matiere> matieres = matiereDao.findAll();
		modelMap.addAttribute(MATIERES, matieres);
		return HOME_PAGE_MATIERES;
	}

	@GetMapping(value = "/Matieres/ajouterMatiere")
	public String ajouterMatiere(ModelMap modelMap) {
		return "ajouterMatiere";
	}

	@PostMapping(value = "/Matieres/ajouterMatiere/Ajouter")
	public String ajouterMatiere(ServletRequest request, ModelMap modelMap) {
		Matiere matiere = new Matiere();
		matiere.setDesignation(request.getParameter("designation"));
		try {
			matiere.setNombreDesEtudiants(Integer.parseInt(request.getParameter("nombredesetudiants")));
		} catch (NumberFormatException e) {
			matiere.setNombreDesEtudiants(0);
		}
		matiereDao.save(matiere);
		modelMap.addAttribute(MATIERES, matiereDao.findAll());
		return HOME_PAGE_MATIERES;
	}

	@GetMapping(value = "/Matieres/{id}/Supprimer")
	public String supprimerMatiere(@PathVariable int id, ModelMap modelMap) {
		matiereDao.deleteById(id);
		modelMap.addAttribute(MATIERES, matiereDao.findAll());
		return HOME_PAGE_MATIERES;
	}

	@GetMapping(value = "/Matieres/{id}/ModifierMatiere")
	public String updateMatiere(@PathVariable int id, ModelMap modelMap) {
		Matiere matiere = matiereDao.findById(id);
		modelMap.addAttribute("matiere", matiere);
		return "modifierMatiere";
	}

	@GetMapping(value = "/Matieres/{id}/ModifierMatiere/Modifier")
	public String updateMatiere(ServletRequest request, @PathVariable int id, ModelMap modelMap) {
		Matiere matiere = matiereDao.findById(id);
		matiere.setDesignation(request.getParameter("designation"));
		try {
			matiere.setNombreDesEtudiants(Integer.parseInt(request.getParameter("nombredesetudiants")));
		} catch (NumberFormatException e) {
			matiere.setNombreDesEtudiants(0);
		}
		matiereDao.save(matiere);
		modelMap.addAttribute(MATIERES, matiereDao.findAll());
		return HOME_PAGE_MATIERES;
	}

}
