package projet.dao.jpa;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.jsf.data.Cours;

@Stateless
@LocalBean
public class DaoCours {

	// Champs
	@PersistenceContext
	private EntityManager em;
	// Actions
	public int inserer( Cours Cours ) {
	em.persist(Cours);
	em.flush();
	return Cours.getId();
	}
	public void modifier( Cours Cours ) {
	em.merge( Cours );
	}
	public void supprimer( int idCours ) {
	em.remove( em.getReference( Cours.class, idCours ));
	}
	public Cours retrouver( int idCours ) {
	return em.find( Cours.class, idCours );
	}
	public List<Cours> listerTout() {
	var jpql = "SELECT c FROM Cours c ORDER BY c.nom";
	var query = em.createQuery( jpql, Cours.class );
	return query.getResultList();
	}
	
	

}
