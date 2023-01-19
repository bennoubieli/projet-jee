package projet.commun.dto;


import java.io.Serializable;
import java.sql.Date;



@SuppressWarnings("serial")
public class DtoEnfant implements Serializable  {

	
	// Champs
	private Integer id;
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private String etablissement;
	private String niveauEtude;
	private String modePaiement;
	
		
	
	// Constructeurs
	
	public DtoEnfant() {
	}

	public DtoEnfant(int id, String nom, String etablissement, String niveauetude,String prenom, Date datedenaissance,String modepaiement ) {
		this.id = id;
		this.nom = nom;
		this.modePaiement = modepaiement;
		this.prenom = prenom; 
		this.dateDeNaissance = datedenaissance;
		this.etablissement = etablissement;
		this.niveauEtude=niveauetude;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
	
	
	// Getters & setters
	
	}
