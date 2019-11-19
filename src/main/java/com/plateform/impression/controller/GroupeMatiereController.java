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
import com.plateform.impression.dao.GroupeMatiereDao;
import com.plateform.impression.dao.MatiereDao;
import com.plateform.impression.model.Groupe;
import com.plateform.impression.model.GroupeMatiere;
import com.plateform.impression.model.GroupeMatierePK;
import com.plateform.impression.model.Matiere;

@Controller
public class GroupeMatiereController {

	public static final String HOME_PAGE_GROUPE_MATIERE = "listeGroupeMatieres";
	public static final String GROUPEMATIERES = "groupeMatieres";
	protected GroupeMatiereDao groupeMatiereDao;
	protected MatiereDao matiereDao;
	protected GroupeDao groupeDao;

	@Autowired
	GroupeMatiereController(GroupeMatiereDao groupeMatiereDao, MatiereDao matiereDao, GroupeDao groupeDao) {
		this.groupeMatiereDao = groupeMatiereDao;
		this.matiereDao = matiereDao;
		this.groupeDao = groupeDao;
	}

	@GetMapping(value = "/GroupeMatieres/{id}")
	public String listeGroupeMatieres(@PathVariable int id, ModelMap modelMap) {
		List<GroupeMatiere> groupeMatieres = groupeMatiereDao.findByIdGroupe(id);
		modelMap.addAttribute(GROUPEMATIERES, groupeMatieres);
		Groupe groupe = groupeMatieres.get(0).getGroupeMatierePK().getGroupe();
		modelMap.addAttribute("groupe", groupe);
		return HOME_PAGE_GROUPE_MATIERE;
	}

	@GetMapping(value = "/GroupeMatieres/{id}/ajouterGroupeMatieres")
	public String ajouterGroupeMatieres(@PathVariable int id, ModelMap modelMap) {
		List<GroupeMatiere> groupeMatieres = groupeMatiereDao.findByIdGroupe(id);
		List<Matiere> matieres = matiereDao.findAll();

		for (GroupeMatiere groupeMatiere : groupeMatieres) {
			matieres.remove(groupeMatiere.getGroupeMatierePK().getMatiere());
		}
		modelMap.addAttribute("matieres", matieres);
		Groupe groupe = groupeMatieres.get(0).getGroupeMatierePK().getGroupe();
		modelMap.addAttribute("groupe", groupe);
		return "ajouterGroupeMatieres";
	}

	@PostMapping(value = "/GroupeMatieres/{id}/ajouterGroupeMatieres/Ajouter")
	public String ajouterGroupeMatieres(@PathVariable int id, ServletRequest request, ModelMap modelMap) {
		Matiere matiere = new Matiere();
		try {
			matiere.setIdMatiere(Integer.parseInt(request.getParameter("idmatiere")));
		} catch (NumberFormatException e) {
			return "ERROR500";
		}
		matiere.setDesignation(matiereDao.findById(matiere.getIdMatiere()).getDesignation());
		Groupe groupe = new Groupe();
		try {
			groupe.setIdGroupe(Integer.parseInt(request.getParameter("idgroupe")));
		} catch (NumberFormatException e) {
			return "ERROR500";
		}
		groupe.setDesignation(groupeDao.findById(groupe.getIdGroupe()).getDesignation());
		GroupeMatierePK groupeMatierePK = new GroupeMatierePK();
		groupeMatierePK.setGroupe(groupe);
		groupeMatierePK.setMatiere(matiere);
		GroupeMatiere groupeMatiere = new GroupeMatiere();
		groupeMatiere.setGroupeMatierePK(groupeMatierePK);
		groupeMatiereDao.save(groupeMatiere);
		modelMap.addAttribute(GROUPEMATIERES, groupeMatiereDao.findByIdGroupe(groupe.getIdGroupe()));
		return HOME_PAGE_GROUPE_MATIERE;
	}

	@GetMapping(value = "/GroupeMatieres/{id}/{idMat}/Supprimer")
	public String ajouterGroupeMatieres(@PathVariable int id, @PathVariable int idMat, ModelMap modelMap) {
		Matiere matiere = new Matiere();
		matiere.setIdMatiere(idMat);
		Groupe groupe = new Groupe();
		groupe.setIdGroupe(id);
		GroupeMatierePK groupeMatierePK = new GroupeMatierePK();
		groupeMatierePK.setGroupe(groupe);
		groupeMatierePK.setMatiere(matiere);
		groupeMatiereDao.deleteById(groupeMatierePK);
		modelMap.addAttribute(GROUPEMATIERES, groupeMatiereDao.findByIdGroupe(groupe.getIdGroupe()));
		return HOME_PAGE_GROUPE_MATIERE;
	}
}
