package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cfl.model.Utilisateur;
import com.cfl.model.UtilisateurRepertoire;

@Controller
public class RegisterView {

	private final UtilisateurRepertoire utilisateurRepertoire;

	public RegisterView(UtilisateurRepertoire utilisateurRepertoire) {this.utilisateurRepertoire = utilisateurRepertoire;}
	
	
	@GetMapping({"/Enregistrer"})
	public String view() {
		return "Enregistrer";
	}
	
	
	@PostMapping({"/Enregistrer"})
	public String view(HttpSession session, ModelMap model,
			@RequestParam String username,
			@RequestParam String password,
			@RequestParam String confpassword) {
		
		if(username == null || password == null || confpassword == null) {
			model.addAttribute("error", "Tout les champs doivent être remplis.");
			return "Enregistrer";
		}
		
		if(!password.equals(confpassword)) {
			model.addAttribute("error", "Les mots de passes rentré doivent être les mêmes.");
			return "Enregistrer";
		}
		
		List<Utilisateur> matchingUsers = utilisateurRepertoire.findByUsername(username);
		if(matchingUsers.size() > 0) {
			model.addAttribute("error", "Pseudonyme indisponible.");
			return "Enregistrer";
		}
		
		Utilisateur user = new User(username, password, false);
		utilisateurRepertoire.save(user);
		session.setAttribute("user", user);
		return "redirect:/";
	}
	
}