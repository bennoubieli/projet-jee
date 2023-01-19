package projet.ejb.data.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoEnfant;
import projet.commun.dto.DtoUtilisateur;
import projet.ejb.data.Compte;
import projet.ejb.data.Enfant;
import projet.ejb.data.Utilisateur;

 
@Mapper( componentModel = "cdi" )
public interface IMapperEjb {  
	
	static final IMapperEjb INSTANCE = Mappers.getMapper( IMapperEjb.class );
	
	
	// Compte
	
	Compte map( DtoCompte source );
	
	DtoCompte map( Compte source );
	
	// Utilisateur
	
		Utilisateur map( DtoUtilisateur source );
		
		DtoUtilisateur map( Utilisateur source );
		
		// Utilisateur
		
			Enfant map( DtoEnfant source );
			
			DtoEnfant map( Enfant source );
			
		
}
