package com.plateform.impression.controller;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.plateform.impression.dao.AdministrateurDao;
import com.plateform.impression.model.Administrateur;

@Controller
public class AdministrateurController {

	protected AdministrateurDao administrateurDao;

	@Autowired
	AdministrateurController(AdministrateurDao administrateurDao) {
		this.administrateurDao = administrateurDao;
	}

	@GetMapping(value = "/Administrateur/Authentification")
	public String sAuthentifier(ServletRequest request, ModelMap modelMap) {
		Administrateur administrateur = administrateurDao.findByLoginAndMotDePasse(request.getParameter("login"),
				request.getParameter("motdepasse"));
		if (administrateur == null) {
			modelMap.addAttribute("erreur", "Veuillez vérifier vos paramètres d'authentification");
			return "administrateur_cnx";
		} else {
			modelMap.addAttribute("administrateur", administrateur);
			return "tableau_admin";
		}
	}

}
