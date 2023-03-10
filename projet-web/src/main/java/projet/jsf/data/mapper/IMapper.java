package projet.jsf.data.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.MappingTarget;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoCours;
import projet.commun.dto.DtoEnfant;
import projet.commun.dto.DtoUtilisateur;
import projet.jsf.data.Compte;
import projet.jsf.data.Cours;
import projet.jsf.data.Enfant;
import projet.jsf.data.Utilisateur;

@Mapper(componentModel = "cdi")
public interface IMapper {

	// Compte

	Compte map(DtoCompte source);

	DtoCompte map(Compte source);

	Compte duplicate(Compte source);

	Compte update(@MappingTarget Compte target, Compte source);

	Utilisateur map(DtoUtilisateur source);

	DtoUtilisateur map(Utilisateur source);

	Utilisateur duplicate(Utilisateur source);

	Utilisateur update(@MappingTarget Utilisateur target, Utilisateur source);
	
	Enfant map(DtoEnfant source);

	DtoEnfant map(Enfant source);

	Enfant duplicate(Enfant source);

	Enfant update(@MappingTarget Enfant target, Enfant source);

	Cours map(DtoCours source);

	DtoCours map(Cours source);

	Cours duplicate(Cours source);

	Cours update(@MappingTarget Cours target, Cours source);


}
