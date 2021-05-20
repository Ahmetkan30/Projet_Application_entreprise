package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cfl.model.Commercant;
import com.cfl.model.CommercantRepertoire;
import com.cfl.model.Panier;
import com.cfl.model.Utilisateur;

@Controller
public class CommercantView {

	private final CommercantRepertoire commercantRepertoire;

	public CommercantView(CommercantRepertoire commercantRepertoire) {this.commercantRepertoire = commercantRepertoire;}
	
	@GetMapping({"/Commercant"})
	public String view(HttpSession session, ModelMap model, @RequestParam(required=false) Long id) {
		
		if(id == null) {
			return "redirect:/";
		}
		
		Optional<Commercant> commercant = CommercantRepertoire.findById(id);
		if(commercant.isEmpty()) {
			return "redirect:/";
		}

		model.addAttribute("Commercant", commercant.get());
		return "Commercant";
	}
	
	
	
	@PostMapping({"/Commercant"})
	public String view(HttpSession session, ModelMap model, 
			@RequestParam Long id,
			@RequestParam String name,
			@RequestParam String priix,
			@RequestParam String local,
			@RequestParam(required = false) String categorie){
		
		if(id == null || name == null || priix == null || local == null || categorie == null) {
			return "redirect:/";
		}
		

		Utilisateur utilisateur = (Utilisateur)session.getAttribute("user");
		if(utilisateur == null) {
			return "redirect:/";
		}
		
		Optional<Commercant> opcommercantRepertoire = commercantRepertoire.findById(id);
		if(commercantRepertoire.isEmpty()) {
			return "redirect:/";
		}
		
		Panier panier = new Panier(utilisateur, name, priix,local,categorie);
		
		List<Panier> panier = (List<Panier>) session.getAttribute("cart");
		if(panier == null) {
			panier = new ArrayList<Panier>();
		}
		panier.add(panier);
		session.setAttribute("panier", panier);
		
		model.addAttribute("Utilisateur", utilisateur);
		return "Utilisateur";
	}
}