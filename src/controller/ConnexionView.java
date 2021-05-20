package controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cfl.model.Utilisateur;
import com.cfl.model.UtilisateurRepertoire;

@Controller
public class ConnexionView {

	private final UtilisateurRepertoire utilisateurRepertoire;

	public LoginView(UtilisateurRepertoire utilisateurRepertoire) {this.utilisateurRepertoire = utilisateurRepertoire;}
	
	@GetMapping({"/Connexion"})
	public String view() {
		return "Connexion";
	}
	
	@PostMapping({"/Connexion"})
	public String view(HttpSession session, ModelMap model,
			@RequestParam(required=false) String username,
			@RequestParam(required=false) String password) {
		if(username == null || password == null) {
			model.addAttribute("error", "Tout les champs doivent être remplis.");
			return "Connexion";
		}
		
		List<Utilisateur> matchingUsers = utilisateurRepertoire.findByUsername(username);
		if(matchingUsers.size() < 1) {
			model.addAttribute("error", "Pseudonyme invalide.");
			return "login";
		}
		
		Utilisateur utilisateur = matchingUsers.get(0);
		
		if(!password.equals(utilisateur.getPassword())){
			model.addAttribute("error", "Mot de passe incorrect.");
			return "login";
		}
		
		session.setAttribute("user", utilisateur);
		return "redirect:/";
	}
	

	
	@GetMapping({"/logout"})
	public String view(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}