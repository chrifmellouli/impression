package com.plateform.impression.controller;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.plateform.impression.dao.AgentDeTirageDao;
import com.plateform.impression.model.AgentDeTirage;

@Controller
public class AgentDeTirageController {

	public static final String HOME_PAGE_AGENTS = "listeAgentsDeTirage";
	public static final String LOGIN = "login";
	public static final String MOTDEPASSE = "motdepasse";
	public static final String AGENTDETIRAGE= "agentsDeTirages";
	protected AgentDeTirageDao agentDeTirageDao;

	@Autowired
	public AgentDeTirageController(AgentDeTirageDao agentDeTirageDao) {
		this.agentDeTirageDao = agentDeTirageDao;
	}

	@GetMapping(value = "/AgentsDeTirage")
	public String listeAgentsDeTirage(ModelMap modelMap) {
		List<AgentDeTirage> agentsDeTirages = agentDeTirageDao.findAll();
		modelMap.addAttribute(AGENTDETIRAGE, agentsDeTirages);
		return HOME_PAGE_AGENTS;
	}

	@GetMapping(value = "/AgentsDeTirage/ajouterAgentDeTirage")
	public String ajouterAgentDeTirage(ModelMap modelMap) {
		return "ajouterAgentDeTirage";
	}

	@PostMapping(value = "/AgentsDeTirage/ajouterAgentDeTirage/Ajouter")
	public String ajouterAgentDeTirage(ServletRequest request,ModelMap modelMap) {
		AgentDeTirage agentDeTirage = new AgentDeTirage();
		agentDeTirage.setLogin(request.getParameter(LOGIN));
		agentDeTirage.setMotDePasse(request.getParameter(MOTDEPASSE));
		agentDeTirage.setNom(request.getParameter("nom"));
		agentDeTirage.setPrenom(request.getParameter("prenom"));
		agentDeTirageDao.save(agentDeTirage);
		modelMap.addAttribute(AGENTDETIRAGE, agentDeTirageDao.findAll());
		return HOME_PAGE_AGENTS;
	}

	@GetMapping(value = "/AgentsDeTirage/{id}/Supprimer")
	public String supprimerAgentDeTirage(@PathVariable int id,ModelMap modelMap) {
		agentDeTirageDao.deleteById(id);
		modelMap.addAttribute(AGENTDETIRAGE, agentDeTirageDao.findAll());		
		return HOME_PAGE_AGENTS;
	}

	@GetMapping(value = "/AgentsDeTirage/{id}/ModifierAgentDeTirage")
	public String updateAgentDeTirage(@PathVariable int id, ModelMap modelMap) {
		AgentDeTirage agentDeTirage = agentDeTirageDao.findById(id);
		modelMap.addAttribute("agentDeTirage", agentDeTirage);
		return "modifierAgentDeTirage";
	}

	@GetMapping(value = "/AgentsDeTirage/{id}/ModifierAgentDeTirage/Modifier")
	public String updateAgentDeTirage(ServletRequest request, @PathVariable int id,ModelMap modelMap) {
		AgentDeTirage agentDeTirage = agentDeTirageDao.findById(id);
		agentDeTirage.setLogin(request.getParameter(LOGIN));
		agentDeTirage.setMotDePasse(request.getParameter(MOTDEPASSE));
		agentDeTirage.setNom(request.getParameter("nom"));
		agentDeTirage.setPrenom(request.getParameter("prenom"));
		agentDeTirageDao.save(agentDeTirage);
		modelMap.addAttribute(AGENTDETIRAGE, agentDeTirageDao.findAll());		
		return HOME_PAGE_AGENTS;
	}

	@GetMapping(value = "/AgentDeTirage/Authentification")
	public String sAuthentifier(ServletRequest request, ModelMap modelMap) {
		AgentDeTirage agentDeTirage = agentDeTirageDao.findByLoginAndMotDePasse(request.getParameter(LOGIN),
				request.getParameter(MOTDEPASSE));
		if (agentDeTirage == null) {
			modelMap.addAttribute("erreur", "Veuillez vérifier vos paramètres d'authentification");
			return "agentdetirage_cnx";
		} else {
			modelMap.addAttribute("agentDeTirage", agentDeTirage);
			return "tableau_agent";
		}
	}

}
