package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoEnfant;
import projet.ejb.data.Enfant;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoEnfant implements IDaoEnfant {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(Enfant Enfant) {
		em.persist(Enfant);
		em.flush();
		return Enfant.getId();
	}

	@Override
	public void modifier(Enfant Enfant) {
		em.merge( Enfant );
	}

	@Override
	public void supprimer(int idEnfant) {
		em.remove( retrouver(idEnfant) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Enfant retrouver(int idEnfant) {
		return em.find( Enfant.class, idEnfant );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Enfant> listerTout() {
		em.clear();
		var jpql = "SELECT e FROM Enfant e ORDER BY e.nom, e.prenom";
		var query = em.createQuery( jpql, Enfant.class );
		return query.getResultList();
	}



	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public boolean verifierUnicitenom( String nom, int idEnfant )  {
	    var jpql = "SELECT COUNT(e) FROM Enfant e WHERE e.nom=:nom AND e.id <> :idEnfant ";
	    var query = em.createQuery( jpql, Long.class );
	    query.setParameter( "nom", nom );
	    query.setParameter( "idEnfant", idEnfant );
        return query.getSingleResult() == 0;
	}

	
	
}
