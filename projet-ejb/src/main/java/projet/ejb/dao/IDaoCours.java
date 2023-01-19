package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Cours;


public interface IDaoCours {

	int			inserer( Cours Cours );

	void 		modifier( Cours Cours );

	void 		supprimer( int idCours );

	Cours 		retrouver( int idCours );

	List<Cours> listerTout();


	boolean 	verifierUnicitenom( String nom, int idCours );

}
