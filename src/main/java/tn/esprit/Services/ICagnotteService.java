package tn.esprit.Services;

import java.util.List;

import tn.esprit.Entities.Cagnotte;

public interface ICagnotteService {

	
	List<Cagnotte> retrieveAllCagnottes();

	Cagnotte addCagnotte(Cagnotte c);
	Cagnotte addCagnotteUser(Cagnotte c, Long idUser);

	Cagnotte updateCagnotte(Cagnotte c);

	Cagnotte retrieveCagnotte(Long id);

	void removeCagnotte(Long id);
	Cagnotte updateSomme(Cagnotte c);
	
}
