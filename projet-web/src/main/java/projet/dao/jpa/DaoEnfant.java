package projet.dao.jpa;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.jsf.data.Enfant;

@Stateless
@LocalBean
public class DaoEnfant {

	// Champs
	@PersistenceContext
	private EntityManager em;
	// Actions
	public int inserer( Enfant enfant ) {
	em.persist(enfant);
	em.flush();
	return enfant.getId();
	}
	public void modifier( Enfant enfant ) {
	em.merge( enfant );
	}
	public void supprimer( int idEnfant ) {
	em.remove( em.getReference( Enfant.class, idEnfant ));
	}
	public Enfant retrouver( int idEnfant ) {
	return em.find( Enfant.class, idEnfant );
	}
	public List<Enfant> listerTout() {
	var jpql = "SELECT e FROM Enfant e ORDER BY e.nom";
	var query = em.createQuery( jpql, Enfant.class );
	return query.getResultList();
	}
	
	

}
