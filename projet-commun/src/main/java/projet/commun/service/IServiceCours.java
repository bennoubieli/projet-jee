package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoCours;
import projet.commun.exception.ExceptionValidation;


public interface IServiceCours {
	
	int				inserer( DtoCours dtoCours ) throws ExceptionValidation;

	void			modifier( DtoCours dtoCours ) throws ExceptionValidation; 

	void			supprimer( int idCours ) throws ExceptionValidation;

	DtoCours 		retrouver( int idCours ) ;

	List<DtoCours>	listerTout() ;

}
