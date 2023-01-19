package projet.jsf.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class Cours implements Serializable {


	private Integer id;

	@NotBlank(message = "Le nom doit être renseigné")
	@Size(max = 50, message = "Valeur trop longue pour le nom : 50 car. maxi")
	private String nom;

	private String creneaudispo;
	
	
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
		return Objects.equals(id, other.id);
	}
}
