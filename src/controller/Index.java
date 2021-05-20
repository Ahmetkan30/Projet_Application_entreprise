package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cfl.model.Commercant;
import com.cfl.model.CommercantRepertoire;
import com.cfl.model.Utilisateur;

@Controller
public class Index {
	
	private final CommercantRepertoire commercantRepertoire;

	public Index(CommercantRepertoire commercantRepertoire) {this.CommercantRepertoire = commercantRepertoire;}
	
	
	@GetMapping({"/"})
	public String view(HttpSession session, ModelMap model, @RequestParam(required=false) String query) {
		Utilisateur utilisateur = (Utilisateur)session.getAttribute("user");
		model.addAttribute("user", utilisateur);
		List<Commercant> commercant = CommercantRepertoire.findAll();
		
		if(query !=  null) {
			model.addAttribute("query", query);
			for (int i = commercant.size()-1; i >= 0; i--) {
				if(filterEvent(query.split(" "), commercant.get(i))) {
					commercant.remove(i);
				}
			}
		}
		
		model.addAttribute("ListCommercant", commercant);
		return "Accueil";
	}
private boolean filterEvent(String[] query, Commercant commercant) {
		
		for (String string : query) {
			if(commercant.getName().contains(string)
					|| commercant.getName().contains(string)
					|| commercant.getLocal().contains(string)
					|| commercant.getCategorie().toGMTString().contains(string)) {
				return false;
			}
		}
		return true;
	}
}
