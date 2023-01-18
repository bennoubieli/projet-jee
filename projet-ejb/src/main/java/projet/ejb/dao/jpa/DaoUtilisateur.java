package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoUtilisateur;
import projet.ejb.data.Utilisateur;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoUtilisateur implements IDaoUtilisateur {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(Utilisateur Utilisateur) {
		em.persist(Utilisateur);
		em.flush();
		return Utilisateur.getId();
	}

	@Override
	public void modifier(Utilisateur Utilisateur) {
		em.merge( Utilisateur );
	}

	@Override
	public void supprimer(int idUtilisateur) {
		em.remove( retrouver(idUtilisateur) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Utilisateur retrouver(int idUtilisateur) {
		return em.find( Utilisateur.class, idUtilisateur );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Utilisateur> listerTout() {
		em.clear();
		var jpql = "SELECT u FROM Utilisateur u ORDER BY u.nom, u.prenom";
		var query = em.createQuery( jpql, Utilisateur.class );
		return query.getResultList();
	}


	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Utilisateur validerAuthentification( String nom, String motDePasse )  {
	    var jpql = "SELECT u FROM Utilisateur u WHERE u.nom=:nom AND u.motDePasse = :motDePasse ";
	    var query = em.createQuery( jpql, Utilisateur.class );
	    query.setParameter( "nom", nom );
	    query.setParameter( "motDePasse", motDePasse );
	    try {
	        return query.getSingleResult();
	    } catch ( NoResultException e ) {
	        return null;
	    }
	}


	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public boolean verifierUnicitenom( String nom, int idUtilisateur )  {
	    var jpql = "SELECT COUNT(u) FROM Utilisateur u WHERE u.nom=:nom AND u.id <> :idUtilisateur ";
	    var query = em.createQuery( jpql, Long.class );
	    query.setParameter( "nom", nom );
	    query.setParameter( "idUtilisateur", idUtilisateur );
        return query.getSingleResult() == 0;
	}

	
	
}
