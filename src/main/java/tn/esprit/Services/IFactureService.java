package tn.esprit.Services;

import java.util.List;

import tn.esprit.Entities.facture;

public interface IFactureService {

	List<facture> retrieveAllFacture();

	facture updateFacture(facture f);

	facture retrieveFacture(Long id);

	void removeFacture(Long id);

	void imprimerFacture(Long factureId);

	facture addFacture(facture f, Long idPaiement);
	
}