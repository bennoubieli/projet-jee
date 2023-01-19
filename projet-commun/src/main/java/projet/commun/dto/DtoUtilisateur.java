package projet.commun.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class DtoUtilisateur implements Serializable  {

	
	// Champs
	
	private int			id;
	
	private String		nom;
	
	private String prenom;
	
	private String		motDePasse;
	
	private String		email;
	
	private String roles ;
	
	
	// Constructeurs
	
	public DtoUtilisateur() {
	}

	public DtoUtilisateur(int id, String nom, String motDePasse, String email,String prenom ,String role) {
		this.id = id;
		this.nom = nom;
		this.motDePasse = motDePasse;
		this.email = email;
		this.prenom = prenom; 
		this.roles = role;
	}
	
	
	// Getters & setters

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	
	}
