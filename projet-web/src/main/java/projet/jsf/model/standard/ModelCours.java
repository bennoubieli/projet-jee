package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoCours;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceCours;
import projet.jsf.data.Cours;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelCours implements Serializable {

	
	// Champs
	
	private List<Cours>	liste;
	
	private Cours			courant;
	
	@EJB
	private IServiceCours	serviceCours;
	
	@Inject
	private IMapper			mapper;

	
	// Getters 
	
	public List<Cours> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoCours dto : serviceCours.listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}
	
		public Cours getCourant() {
			if ( courant == null ) {
				courant = new Cours();
			}
			return courant;
		}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			DtoCours dto = serviceCours.retrouver( courant.getId() ); 
			if ( dto == null ) {
				UtilJsf.messageError( "Le Cours demandé n'existe pas" );
				return "test/liste";
			} else {
				courant = mapper.map( dto );
			}
		}
		return null;
	}
	
	
	// Actions
	
	public String validerMiseAJour() {
		try {
			if ( courant.getId() == null) {
				serviceCours.inserer( mapper.map(courant) );
			} else {
				serviceCours.modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Cours item ) {
		try {
			serviceCours.supprimer( item.getId() );
			liste.remove(item);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
	
}
