package projet.jsf.data;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class  Enfant implements Serializable
{
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	@NotBlank( message="Le nom doit être renseigné")
	private String nom;
	@NotBlank( message="Le prénom doit être renseigné")
	private String prenom;
	@NotBlank( message="L'adresse e-mail doit être renseignée")
	@Email( message="La date n'est pas valide.")
	private Date dateDeNaissance;
	@NotBlank( message="Le mot de passe doit être renseigné")
	private String motDePasse;
	@NotBlank( message="Le nom doit être renseigné")
	private String etablissement;
	@NotBlank( message="Le prénom doit être renseigné")
	private String niveauEtude;
	@NotBlank( message="Le nom doit être renseigné")
	private String modePaiement;
	
	
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
//	
	public String getMotDePasse() {
		return motDePasse;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}
	public String getNiveauEtude() {
		return niveauEtude;
	}
	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}
	public String getModePaiement() {
		return modePaiement;
	}
	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
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