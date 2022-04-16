package tn.esprit.Services;

import java.util.List;

import tn.esprit.Entities.paiement;

public interface IPaiementService {

	List<paiement> retrieveAllPaiement();

	paiement updatePaiement(paiement p);

	paiement retrievePaiement(Long id);

	void removePaiement(Long id);

	paiement addPaiement(paiement p, Long idPanier);
	
}