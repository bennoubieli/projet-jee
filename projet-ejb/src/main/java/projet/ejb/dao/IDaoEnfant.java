package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Enfant;


public interface IDaoEnfant {

	int			inserer( Enfant Enfant );

	void 		modifier( Enfant Enfant );

	void 		supprimer( int idEnfant );

	Enfant 		retrouver( int idEnfant );

	List<Enfant> listerTout();


	boolean 	verifierUnicitenom( String nom, int idEnfant );

}
