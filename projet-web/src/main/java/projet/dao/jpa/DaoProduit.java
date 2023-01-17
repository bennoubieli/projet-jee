package projet.dao.jpa;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import maboutique.data.Produit;

@Stateless
@LocalBean
public class DaoProduit {

	// Champs
	@PersistenceContext
	private EntityManager em;
	// Actions
	public int inserer( Produit Produit ) {
	em.persist(Produit);
	em.flush();
	return Produit.getId();
	}
	public void modifier( Produit Produit ) {
	em.merge( Produit );
	}
	public void supprimer( int idProduit ) {
	em.remove( em.getReference( Produit.class, idProduit ));
	}
	public Produit retrouver( int idProduit ) {
	return em.find( Produit.class, idProduit );
	}
	public List<Produit> listerTout() {
	var jpql = "SELECT p FROM Produit p ORDER BY p.nom";
	var query = em.createQuery( jpql, Produit.class );
	return query.getResultList();
	}
	
	

}
