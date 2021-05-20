package controller;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cfl.Util;
import com.cfl.model.Commercant;
import com.cfl.model.CommercantRepertoire;
public class CommercantEditView {
	
	private final CommercantRepertoire commercantRepertoire;
	
	public CommercantEditView(CommercantRepertoire commercantRepertoire) {
		this.commercantRepertoire= commercantRepertoire;
	}
	@GetMapping({"/admin/editcommercant"})
	public String view(HttpSession session, ModelMap model,
			@RequestParam(required=false) Long id) {
		if(!Util.isLoggedAdmin(session)) {return "redirect:/";
		}
		
		Commercant	defaultCommercant = new Commercant("","","","","");
		if(id == null) {
					model.addAttribute("Commercant", defaultCommercant);
					return "editcommercant";
				}
		Optional<model.Commercant> commercant = commercantRepertoire.findById(id);
		
		if(commercant.isEmpty()) {
			model.addAttribute("Commercant", model.addAttribute("Commercant", defaultCommercant));
			return "editcommercant";
		}
		model.addAttribute("Commercant",commercant.get());
		return "editCommercant";
		
	}
	@PostMapping({"/admin/editCommercant"})
	public String view(HttpSession session, ModelMap model,
			@RequestParam(required=false) Long id,
			@RequestParam(required=false) String name,
			@RequestParam(required=false) String local,
			@RequestParam(required=false) String categorie,
			@RequestParam(required=false) Float priix) {
		if(id == null) {
			Commercant commercant = new Commercant(id, name, local, categorie,
					priix);
			CommercantRepertoire.save(commercant);
			return "redirect:/admin";
		}
		if(name == null || local == null || categorie == null || priix == null) {
			System.out.println("Aucun argument a était trouver:"+name+"\n"+local+"\n"+categorie+"\n"+priix);
			return "redirect:/admin";
		}
		Optional<Commercant> opCommercant = commercantRepertoire.findById(id);
		if(opEvent.isEmpty()) {
			return "redirect:/admin";
		}
		
		Commercant commercant = opCommercant.get();
		commercant.setName(name);
		commercant.setLocation(local);
		commercant.setCategorie(categorie);
		commercant.setPriix(priix);
		CommercantRepertoire.save(commercant);
		
		return "redirect:/admin";
	}
	@GetMapping({"/admin/deletecommercant"})
	public String view(HttpSession session, 
			@RequestParam Long id) {
		
		if(!Util.isLoggedAdmin(session)) {return "redirect:/";}
		
		if(id == null) {
			return "redirect:/admin";
		}
		
		CommercantRepertoire.deleteById(id);
		return "redirect:/";
	}
}

