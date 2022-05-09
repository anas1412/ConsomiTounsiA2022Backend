package tn.esprit.Services;

import java.util.Date;
import java.util.List;

import tn.esprit.Entities.Reclamation;


public interface IReclamationService {
	
	List<Reclamation> retrieveAllReclamations();

	Reclamation addReclamation(Reclamation rec,Long idUser,Long idLivraison);

	Reclamation updateReclamation(Reclamation rec);

	Reclamation retrieveReclamation(Long idReclamation);

	void removeReclamation(Long idReclamation);
	
	void assignReclamationToUser(Long id,Long idReclamation);
	
	void assignReclamationToLivraison(Long idLivraison,Long idReclamation);
	
	void traiterReclamation1();
	
	void traiterReclamation2();
	
	void traiterReclamation3();
	
	
}
