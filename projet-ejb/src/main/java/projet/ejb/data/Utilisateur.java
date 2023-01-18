package projet.ejb.data;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table( name = "utilisateur" )
public class Utilisateur  {

	
	// Champs

	@Id
	@GeneratedValue( strategy = IDENTITY)
	@Column( name = "idutilisateur")
	private int			id;
	
	@Column( name = "nom")
	private String		nom;
	
	@Column( name = "prenom")
	private String		prenom;
	
	@Column( name = "motdepasse")
	private String		motDePasse;
	
	@Column( name = "email")
	private String		email;
	
	
	@Column( name = "role")
	private List<String> roles = new ArrayList<>();	
	
	
	// Constructeurs
	
	public Utilisateur() {
	}

	public Utilisateur(int id, String nom,String prenom, String motDePasse, String email) {
		this.id = id;
		this.nom = nom;
		this.motDePasse = motDePasse;
		this.email = email;
		this.prenom = prenom;

	}
	
		
	// Getters & setters
	
	    
	// equals() et hashcode()

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
