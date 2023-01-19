package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoCours;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceCours;
import projet.ejb.dao.IDaoCours;
import projet.ejb.data.Cours;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceCours implements IServiceCours {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoCours daoCours;

	// Actions

	@Override
	public int inserer(DtoCours dtoCours) throws ExceptionValidation {
		verifierValiditeDonnees(dtoCours);
		int id = daoCours.inserer(mapper.map(dtoCours));
		return id;
	}

	@Override
	public void modifier(DtoCours dtoCours) throws ExceptionValidation {
		verifierValiditeDonnees(dtoCours);
		daoCours.modifier(mapper.map(dtoCours));
	}

	@Override
	public void supprimer(int idCours) throws ExceptionValidation {
		daoCours.supprimer(idCours);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoCours retrouver(int idCours) {
		return mapper.map(daoCours.retrouver(idCours));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoCours> listerTout() {
		List<DtoCours> liste = new ArrayList<>();
		for (Cours Cours : daoCours.listerTout()) {
			liste.add(mapper.map(Cours));
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoCours dtoCours) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();



		if (dtoCours.getNom() == null || dtoCours.getNom().isEmpty()) {
			message.append("\nLe nOM  est absente.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
