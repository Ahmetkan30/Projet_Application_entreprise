package model;
import java.util.Date;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.*;

@Entity
public class Commercant implements Serializable {

	public static final float prixTours = .5f;
	public static final float prixLyon = .75f;
	public static final float prixParis = .7f;
	
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
    @Column(nullable = false)
	private String name;
    
    @Column(nullable = false)
	private String local;
    
    @Column(nullable = false)
	private String categorie;
    
    @Column(nullable = false)
	private Float priix;
	

    
    protected Commercant() {
    	
    }
    public Commercant(String name, String local, String categorie, Float priix) {
		this.name = name;
		this.local = local;
		this.categorie = categorie;
		this.priix = priix;

	}
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return local;
	}

	public void setLocation(String local) {
		this.local = local;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie ) {
		this.categorie = categorie;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Float getPriix() {
		return priix;
	}

	public void setPriix(Float priix) {
		this.priix = priix;
	}
}