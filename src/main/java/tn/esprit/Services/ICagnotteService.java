package tn.esprit.Services;

import java.util.List;

import tn.esprit.Entities.Cagnotte;

public interface ICagnotteService {

	
	List<Cagnotte> retrieveAllCagnottes();

	Cagnotte addCagnotte(Cagnotte c);

	Cagnotte updateCagnotte(Cagnotte c);

	Cagnotte retrieveCagnotte(Long id);

	void removeCagnotte(Long id);
}
