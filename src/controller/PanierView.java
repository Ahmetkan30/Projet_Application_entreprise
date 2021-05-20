package controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cfl.model.Panier;
import com.cfl.model.PanierRepertoire;
import com.cfl.model.Utilisateur;

@Controller
public class PanierView {

	private final PanierRepertoire panierRepertoire;
	
	public PanierView(PanierRepertoire panierRepertoire) {
		this.panierRepertoire = panierRepertoire;}
	
	@GetMapping({"/Panier"})
	public String view(HttpSession session) {
		Utilisateur utilisateur = (Utilisateur)session.getAttribute("Utilisateur");
		if(utilisateur == null || utilisateur.getIsAdmin()) {
			return "redirect:/";
		}
		return "Panier";
	}
	
	
	@PostMapping({"/acheterPanier"})
	public String view(HttpSession session, ModelMap model) {

		List<Panier> panier = (List<Panier>)session.getAttribute("Panier");
		if(panier == null || panier.size() <= 0) {
			return "redirect:/Panier";
		}
		
		for (Panier Panier : panier) {
			ticketRepository.save(Panier);
		}

		session.setAttribute("Panier", null);
		
		return "redirect:/Panier";
	}
	
	
	@PostMapping({"/annulerPanier"})
	public String view(HttpSession session, ModelMap model,
			@RequestParam Integer id) {
		if(id == null) {
			return "redirect:/Panier";
		}
		
		List<Panier> panier = (List<Panier>)session.getAttribute("panier");
		if(panier == null || panier.size() <= 0) {
			return "redirect:/Panier";
		}
		
		if(id < 0 || id >= panier.size()) {
			return "redirect:/Panier";
		}
		
		panier.remove((int)id);
		session.setAttribute("Panier", panier);
		
		return "redirect:/Panier";
	}
}