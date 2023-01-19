package projet.jsf.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class Utilisateur implements Serializable {


	private Integer id;

	@NotBlank(message = "Le nom doit être renseigné")
	@Size(max = 50, message = "Valeur trop longue pour le nom : 50 car. maxi")
	private String nom;

	@NotBlank(message = "Le prénom doit être renseigné")
	@Size(max = 50, message = "Valeur trop longue pour le prénom : 50 car. maxi")
	private String prenom;

	@NotBlank(message = "L'adresse mail doit être renseigné")
	@Size(max = 50, message = "Valeur trop longue pour le prénom : 50 car. maxi")
	@Email(message = "Adresse e-mail invalide")
	private String email;

	@NotBlank(message = "Le mot de passe doit être renseigné")
	@Size(min = 5, message = "Le mot d passe doit avoir au moins 5 caractères")
	@Size(max = 50, message = "Le mot d passe doit avoir au plus 50 caractères")
	private String motDePasse;

	private String roles;

	private int paiement; 
	
	private List<Enfant>	enfants = new ArrayList<>();
	
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

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	
	public int getPaiement() {
		return paiement;
	}

	public void setPaiement(int paiement) {
		this.paiement = paiement;
	}

	
	public List<Enfant> getEnfants() {
		return enfants;
	}

	public void setEnfants(List<Enfant> enfants) {
		this.enfants = enfants;
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
