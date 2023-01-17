package projet.jsf.model.standard
;

import java.io.Serializable;


import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.dao.jpa.DaoUtilisateur;
import projet.jsf.data.Utilisateur;
import projet.jsf.util.UtilJsf;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class ModelUtilisateur implements Serializable {

	// Champs
	private List<Utilisateur> liste;
	private Utilisateur courant;
	@Inject
	private DaoUtilisateur daoUtilisateur;

	public List<Utilisateur> getListe() {
		if (liste == null) {
			liste = daoUtilisateur.listerTout();
		}
		return liste;
	}

	public Utilisateur getCourant() {
		if (courant == null) {
			courant = new Utilisateur();
		}
		return courant;
	}

	// Actions
	public String actualiserCourant() {
		if (courant != null) {
			courant = daoUtilisateur.retrouver(courant.getId());
			if (courant == null) {
				UtilJsf.messageError("L'utilisateur demandé n'existe pas");
				return "liste";
			}
		}
		return null;
	}

	public String validerMiseAJour() {
		if (courant.getId() == null) {
			daoUtilisateur.inserer(courant);
		} else {
			daoUtilisateur.modifier(courant);
		}
		UtilJsf.messageInfo("Mise à jour effectuée avec succès.");
		return "liste";
	}

	public String supprimer(Utilisateur item) {
		daoUtilisateur.supprimer(item.getId());
		liste = null;
		UtilJsf.messageInfo("Suppression effectuée avec succès.");
		return "liste";
	}
	

}
