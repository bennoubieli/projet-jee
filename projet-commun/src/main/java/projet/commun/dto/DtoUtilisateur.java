package projet.commun.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class DtoUtilisateur implements Serializable  {

	
	// Champs
	
	private int			id;
	
	private String		nom;
	
	private String		motDePasse;
	
	private String		email;
	
	private List<String> roles = new ArrayList<>();
	
	
	// Constructeurs
	
	public DtoUtilisateur() {
	}

	public DtoUtilisateur(int id, String nom, String motDePasse, String email ) {
		this.id = id;
		this.nom = nom;
		this.motDePasse = motDePasse;
		this.email = email;
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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	
	public boolean isInRole( String role ) {
		
		if ( role != null ) {
			for ( String r : roles ) {
				if ( r.equals(role) ) {
					return true;
				}
			}
		}
		return false;
	}
}
