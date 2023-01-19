package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cours")
public class Cours {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idcours")
	private int id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "creneaudispo")
	private String creneaudispo;

	public Cours() {
	}

	public Cours(int id, String nom, String creneaudispo) {
		this.id = id;
		this.nom = nom;
		this.creneaudispo = creneaudispo;

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

	public String getCreneaudispo() {
		return creneaudispo;
	}

	public void setCreneaudispo(String creneaudispo) {
		this.creneaudispo = creneaudispo;
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
		Cours other = (Cours) obj;
		return id == other.id;
	}

	
}
