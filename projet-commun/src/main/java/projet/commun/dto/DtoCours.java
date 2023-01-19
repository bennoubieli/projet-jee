package projet.commun.dto;


import java.io.Serializable;
import java.sql.Date;



@SuppressWarnings("serial")
public class DtoCours implements Serializable  {

	
	// Champs
	private Integer id;
	private String nom;
	private String creneaudisponible;
	
	
		
	
	// Constructeurs
	
	public DtoCours() {
	}

	public DtoCours(int id, String nom, String creneaudisponible ) {
		this.id = id;
		this.nom = nom;
		this.creneaudisponible = creneaudisponible;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCreneaudisponible() {
		return creneaudisponible;
	}

	public void setCreneaudisponible(String creneaudisponible) {
		this.creneaudisponible = creneaudisponible;
	}
	
	// Getters & setters
	
	}
