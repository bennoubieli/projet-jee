package projet.ejb.data;


import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table( name = "utilisateur" )
public class Enfant  {

	
	// Champs

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	@Column( name = "nom")
	private String nom;
	@Column( name = "prenom")
	private String prenom;
	@Column( name = "datedenaissance")
	private Date dateDeNaissance;
	@Column( name = "etabfrequente")
	private String etablissement;
	@Column( name = "niveauetude")
	private String niveauEtude;
	@Column( name = "modedepaiement")
	private String modePaiement;
	
	
	
	// Constructeurs
	
	public Enfant() {
	}

	public Enfant(int id, String nom, String etablissement, String niveauetude,String prenom, Date datedenaissance,String modepaiement ) {
		this.id = id;
		this.nom = nom;
		this.modePaiement = modepaiement;
		this.prenom = prenom; 
		this.dateDeNaissance = datedenaissance;
		this.etablissement = etablissement;
		this.niveauEtude=niveauetude;
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

		@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enfant other = (Enfant) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
