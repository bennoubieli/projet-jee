package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Utilisateur;


public interface IDaoUtilisateur {

	int			inserer( Utilisateur Utilisateur );

	void 		modifier( Utilisateur Utilisateur );

	void 		supprimer( int idUtilisateur );

	Utilisateur 		retrouver( int idUtilisateur );

	List<Utilisateur> listerTout();

	Utilisateur 		validerAuthentification( String nom, String motDePasse );

	boolean 	verifierUnicitenom( String nom, int idUtilisateur );

}
