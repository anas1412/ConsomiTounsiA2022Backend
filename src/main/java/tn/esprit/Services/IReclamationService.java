package tn.esprit.Services;

import java.util.List;

import tn.esprit.Entities.Reclamation;


public interface IReclamationService {
	
	List<Reclamation> retrieveAllReclamations();

	Reclamation addReclamation(Reclamation rec,Long id,Long idLivraison);

	Reclamation updateReclamation(Reclamation rec,Long id,Long idLivraison);

	Reclamation retrieveReclamation(Long idReclamation);

	void removeReclamation(Long idReclamation);
}
