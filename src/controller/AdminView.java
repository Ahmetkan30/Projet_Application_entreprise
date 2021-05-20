package controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


import com.cfl.Util;
import com.cfl.model.Panier;
import com.cfl.model.PanierRepertoire;
import com.cfl.model.Commercant;
import com.cfl.model.CommercantRepository;


@Controller
public class AdminView {

	private final PanierRepertoire panierRepertoire;
	private final CommercantRepository commercantRepository;
	
	public AdminView(PanierRepertoire panierRepertoire, CommercantRepository commercantRepository) {this.panierRepertoire = panierRepertoire; this.commercantRepository=commercantRepository;}
	
	@GetMapping({"/admin"})
	public String view(HttpSession session, ModelMap model) {

		if(!Util.isLoggedAdmin(session)) {
			return "redirect:/";
		}
		
		
		List<Panier> Panier = panierRepertoire.findAll();
		List<Commercant> Commercant = commercantRepository.findAll();
		
		int nombredePanier = 0;
		float totalPrice = 0;
		for (Panier Panier : Commercant) {
			nombredePanier += Panier.getAmount();
			totalPrice += Panier.getPrice();
		}
		
		
		model.addAttribute("Panier", Panier.size());
		model.addAttribute("nombredePanier", nombredePanier);
		model.addAttribute("totalPrice", totalPrice);
		
		
		
		
		return "admin";
	}
}