package projet.jsf.model.standard;

import javax.ejb.EJB;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoCompte;
import projet.commun.service.IServiceConnexion;
import projet.dao.jpa.DaoUtilisateur;
import projet.jsf.data.Compte;
import projet.jsf.data.Utilisateur;
import projet.jsf.util.CompteActif;
import projet.jsf.util.UtilJsf;


@RequestScoped
@Named
public class ModelConnexion {

	// Champs

	private Compte			courant;

	@Inject
	private CompteActif		compteActif;
	@Inject
	private ModelInfo		modelInfo;
	@EJB
	private IServiceConnexion serviceConnexion;

	
	private Utilisateur utilisateurActif;

	@Inject
	private DaoUtilisateur daoUtilisateur;


	// Getters 
	
	public Compte getCourant() {
		if ( courant == null ) {
			courant = new Compte();
		}
		return courant;
	}

	
	// Actons
	
	public String connect() {
	    
	    DtoCompte dto = serviceConnexion.sessionUtilisateurOuvrir( courant.getPseudo(), courant.getMotDePasse() );
	    
	    if ( dto != null ){
	    	
//		    try {
//			    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//				( (HttpServletRequest) ec.getRequest() ).login( courant.getPseudo(), courant.getMotDePasse() );
//			} catch (ServletException e) {
//				throw new RuntimeException( e );
//			}

	        compteActif.setPseudo( dto.getPseudo() );
	        compteActif.setRoles( dto.getRoles() );
	        
	    	modelInfo.setTitre( "Bienvenue" );
	    	modelInfo.setTexte( "Vous êtes connecté en tant que '" + courant.getPseudo() +"'.");
		    return "info";

	    } else {
	        UtilJsf.messageError( "Pseudo ou mot de passe invalide." );
	    	return null;
	    }
	}	
	
	public boolean isLoggedIn() {
		return utilisateurActif != null;
	}

	public String login() {
		utilisateurActif = daoUtilisateur.authentifier(compteActif.getEmail(), compteActif.getMotDePasse());
		if (utilisateurActif != null) {
			UtilJsf.messageInfo("Connexion réussie.");
			
			return "home";
		} else {
			UtilJsf.messageError("Identifiant ou mot de passe invalide.");
			return "login";
		}
	}

	public String logout() {
		UtilJsf.sessionInvalidate();
		UtilJsf.messageInfo("Vous avez été déconnecté");
		return "login";
	}
}
