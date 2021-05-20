package model;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class Panier implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Utilisateur utili;
	
	@Column
	private String Commercant;

	@Column(nullable = false)
	private Float prix;

	@Column(nullable = false)
	private String categorie;
	
	@Column(nullable = false)
	private String local;
	
    @Column(nullable = false, length = 1024)
    private String description;
    
	protected Panier() {
		
	}
	
	public Panier( Utilisateur utili, String commercant, Float prix, String categorie, String local, String description ) {
		
		this.utili= utili;
		this.Commercant = commercant;
		this.prix = prix;
		this.categorie = categorie;
		this.local = local;
		this.description = description;
	}
	
	public Utilisateur getUtili() {
			return utili;
	}
	
	public void setUtili(Utilisateur utili) {
			this.utili= utili;
	}
	
	public String getCommercant() {
		return Commercant;
	}
	
	public void setCommercant(String commercant) {
		this.Commercant=commercant;
	}
	
	public Float getPrix() {
		return prix;
	}
	
	public void setPrix(Float prix) {
		this.prix=prix;
	}
	
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie ) {
		this.categorie = categorie;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public float getPriix() {
		float price = Commercant.getPriix();
		float totalPrice = 0;
		
		switch (local) {
		case "Lyon":
			totalPrice += price * Commercant.prixLyon;
			break;
		case "Tours":
			totalPrice += price * Commercant.prixTours;
			break;
		case "Paris":
			totalPrice += price * Commercant.prixParis;
			break;
		default:
			totalPrice += price;
			break;
		}

		
		totalPrice *= prix;
		totalPrice = Math.round(totalPrice*100)/100;
		
		return totalPrice;
	}
	public String getFormatedLieux() {
		String formatedLieux = "Tours";
		switch (local) {
		case "Lyon":
			formatedLieux = "Lyon";
			break;
		case "Marseille":
			formatedLieux = "Marseille";
			break;
		case "Paris":
			formatedLieux = "Paris";
			break;
		default:
			break;
		}
		return formatedLieux;
	}

	
	
	
	
	
	
	
	
}