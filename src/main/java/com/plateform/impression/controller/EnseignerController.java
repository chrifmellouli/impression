package com.plateform.impression.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.plateform.impression.dao.EnseignantDao;
import com.plateform.impression.dao.EnseignerDao;
import com.plateform.impression.dao.GroupeDao;
import com.plateform.impression.dao.GroupeMatiereDao;
import com.plateform.impression.dao.MatiereDao;
import com.plateform.impression.model.Enseignant;
import com.plateform.impression.model.Enseigner;

@Controller
public class EnseignerController {

	public static final String HOME_PAGE_ENSEIGNER = "listeEnseignement";
	public static final String ENSEIGNERS = "enseigners";
	protected EnseignerDao enseignerDao; 
	protected EnseignantDao enseignantDao;
	protected GroupeMatiereDao groupeMatiereDao;
	protected MatiereDao matiereDao;
	protected GroupeDao groupeDao;

	@Autowired
	EnseignerController(EnseignerDao enseignerDao, EnseignantDao enseignantDao, GroupeMatiereDao groupeMatiereDao, MatiereDao matiereDao,
			GroupeDao groupeDao) {
		super();
		this.enseignerDao = enseignerDao;
		this.enseignantDao = enseignantDao;
		this.groupeMatiereDao = groupeMatiereDao;
		this.matiereDao = matiereDao;
		this.groupeDao = groupeDao;
	}

	@GetMapping(value = "/Enseignements/{id}")
	public String listeGroupeMatieres(@PathVariable int id, ModelMap modelMap) {
		List<Enseigner> enseigners = enseignerDao.findByIdEnseignant(id);
		modelMap.addAttribute(ENSEIGNERS,enseigners);
		Enseignant enseignant = enseigners.get(0).getEnseignerPK().getEnseignant();
		modelMap.addAttribute("enseignant",enseignant);
		return HOME_PAGE_ENSEIGNER;
	}
}
