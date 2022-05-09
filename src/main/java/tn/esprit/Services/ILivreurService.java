package tn.esprit.Services;

import java.util.List;

import tn.esprit.Entities.Livreur;


public interface ILivreurService {
	
	List<Livreur> retrieveAllLivreurs();

	Livreur addLivreur (Livreur l);

	Livreur updateLivreur (Livreur l);

	Livreur retrieveLivreur (Long idLivreur);

	void removeLivreur (Long idLivreur);
	
	 List<Livreur> findByName(String Nom);
	 
	 List<Livreur> ShowHired();
	 
	 List<Livreur> sortDown();
	 
	 List<Livreur> findByCity(String Ville);
	 
	 Livreur AcceptLivreur(Livreur l);
	 
	 Livreur getByEmail(String email);
	 
	// public String NotifyLivreurBySMS(Livreur l);
	 
	 void assignLivreurToLivraison(Long id,Long idLivreur);
	 

	 
	 
}
