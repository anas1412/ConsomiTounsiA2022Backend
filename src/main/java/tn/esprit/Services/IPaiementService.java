package tn.esprit.Services;

import java.util.List;

import tn.esprit.Entities.paiement;
import tn.esprit.Entities.panierProduit;

public interface IPaiementService {

	List<paiement> retrieveAllPaiement();
	
	List<paiement> retrievePaiementByUser(Long id);

	paiement retrievePaiement(Long id);

	paiement addPaiement(paiement pa, Long id);

	List<panierProduit> detailPanier(Long paiement_id);
	
}