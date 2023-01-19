package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoCours;
import projet.ejb.data.Cours;

@Stateless
@Local
@TransactionAttribute(MANDATORY)
public class DaoCours implements IDaoCours {

	// Champs

	@PersistenceContext
	private EntityManager em;

	// Actions

	@Override
	public int inserer(Cours Cours) {
		em.persist(Cours);
		em.flush();
		return Cours.getId();
	}

	@Override
	public void modifier(Cours Cours) {
		em.merge(Cours);
	}

	@Override
	public void supprimer(int idCours) {
		em.remove(retrouver(idCours));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public Cours retrouver(int idCours) {
		return em.find(Cours.class, idCours);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<Cours> listerTout() {
		em.clear();
		var jpql = "SELECT c FROM Cours c ORDER BY c.nom";
		var query = em.createQuery(jpql, Cours.class);
		return query.getResultList();
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public boolean verifierUnicitenom(String nom, int idCours) {
		var jpql = "SELECT COUNT(c) FROM Cours c WHERE c.nom=:nom AND c.id <> :idCours ";
		var query = em.createQuery(jpql, Long.class);
		query.setParameter("nom", nom);
		query.setParameter("idCours", idCours);
		return query.getSingleResult() == 0;
	}

}
