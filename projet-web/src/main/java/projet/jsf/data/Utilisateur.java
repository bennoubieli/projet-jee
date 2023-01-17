package projet.jsf.data;

import java.io.Serializable;
<<<<<<< HEAD


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class  Utilisateur implements Serializable
{
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	@NotBlank( message="Le nom doit être renseigné")
	@Size(max=50, message="Valeur trop longue pour le nom : 50 car. maxi" )
	private String nom;
	@NotBlank( message="Le prénom doit être renseigné")
	@Size(max=50, message="Valeur trop longue pour le prénom : 50 car. maxi")
	private String prenom;
	@NotBlank( message="L'adresse e-mail doit être renseignée")
	@Email( message="L'adresse e-mail n'est pas valide.")
	private String email;
	@NotBlank( message="Le mot de passe doit être renseigné")
	@Size(min=5, message="Le mot d passe doit avoir au moins 5 caractères" )
	@Size(max=50, message="Le mot d passe doit avoir au plus 50 caractères")
	private String motDePasse;
	
	private boolean admin;


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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String nmotDePasse) {
		this.motDePasse = nmotDePasse;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	//protection des ressources 
	
}
//creration de la classe dao
=======
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
public class Utilisateur implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Le nom doit être renseigné")
	@Size(max = 50, message = "Valeur trop longue pour le nom : 50 car. maxi")
	private String nom;

	@NotBlank(message = "Le prénom doit être renseigné")
	@Size(max = 50, message = "Valeur trop longue pour le prénom : 50 car. maxi")
	private String prenom;

	@NotBlank(message = "L'adresse mail doit être renseigné")
	@Size(max = 50, message = "Valeur trop longue pour le prénom : 50 car. maxi")
	@Email( message = "Adresse e-mail invalide" )
	private String email;

	@NotBlank(message = "Le mot de passe doit être renseigné")
	@Size(min = 5, message = "Le mot d passe doit avoir au moins 5 caractères")
	@Size(max = 50, message = "Le mot d passe doit avoir au plus 50 caractères")
	private String motDePasse;
	
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotdepasse() {
		return motDePasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motDePasse = motdepasse;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}
}
>>>>>>> branch 'master' of https://github.com/bennoubieli/projet-jee.git
