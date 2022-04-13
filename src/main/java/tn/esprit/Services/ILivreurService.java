package tn.esprit.Services;

import java.util.List;

import tn.esprit.Entities.Livreur;


public interface ILivreurService {
	
	List<Livreur> retrieveAllLivreurs();

	Livreur addLivreur (Livreur l);

	Livreur updateLivreur (Livreur l);

	Livreur retrieveLivreur (Long idLivreur);

	void removeLivreur (Long idLivreur);
}
