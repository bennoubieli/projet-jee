package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoEnfant;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceEnfant;
import projet.ejb.dao.IDaoEnfant;
import projet.ejb.data.Enfant;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceEnfant implements IServiceEnfant {

	// Champs
	@Inject
	private IMapperEjb mapper;
	
	@Inject
	private IDaoEnfant daoEnfant;

	// Actions

	@Override
	public int inserer(DtoEnfant dtoEnfant) throws ExceptionValidation {
		verifierValiditeDonnees(dtoEnfant);
		int id = daoEnfant.inserer(mapper.map(dtoEnfant));
		return id;
	}

	@Override
	public void modifier(DtoEnfant dtoEnfant) throws ExceptionValidation {
		verifierValiditeDonnees(dtoEnfant);
		daoEnfant.modifier(mapper.map(dtoEnfant));
	}

	@Override
	public void supprimer(int idEnfant) throws ExceptionValidation {
		daoEnfant.supprimer(idEnfant);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoEnfant retrouver(int idEnfant) {
		return mapper.map(daoEnfant.retrouver(idEnfant));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoEnfant> listerTout() {
		List<DtoEnfant> liste = new ArrayList<>();
		for (Enfant Enfant : daoEnfant.listerTout()) {
			liste.add(mapper.map(Enfant));
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoEnfant dtoEnfant) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoEnfant.getNom() == null || dtoEnfant.getNom().isEmpty()) {
			message.append("\nLe Nom est absent.");
		} else if (dtoEnfant.getNom().length() < 3) {
			message.append("\nLe Nom est trop court.");
		} else if (dtoEnfant.getNom().length() > 25) {
			message.append("\nLe Nom est trop long.");
		} else if (!daoEnfant.verifierUnicitenom(dtoEnfant.getNom(), dtoEnfant.getId())) {
			message.append("\nLe Nom " + dtoEnfant.getNom() + " est déjà utilisé.");
		}

		
		if (dtoEnfant.getEtablissement() == null || dtoEnfant.getEtablissement().isEmpty()) {
			message.append("\nL'etablissement est absente.");
		}
		if (dtoEnfant.getNiveauEtude() == null || dtoEnfant.getNiveauEtude().isEmpty()) {
			message.append("\nLe niveau est absente.");
		}
		if (dtoEnfant.getPrenom() == null || dtoEnfant.getPrenom().isEmpty()) {
			message.append("\nLe prenom est absente.");
		}
		if (dtoEnfant.getModePaiement() == null || dtoEnfant.getModePaiement().isEmpty()) {
			message.append("\nLe mode de paiement est absente.");
		}
		if (dtoEnfant.getDateDeNaissance() == null || dtoEnfant.getDateDeNaissance().toString().isEmpty()) {
			message.append("\nLa date de naissance est absente.");
		}



		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
