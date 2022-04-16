package tn.esprit.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entities.paiement;
import tn.esprit.Entities.panier;
import tn.esprit.Entities.panierProduit;
import tn.esprit.Entities.produit;
import tn.esprit.Repository.PaiementRepository;
import tn.esprit.Repository.PanierRepository;


@Service 
public class paiementServiceImpl implements IPaiementService{
	
	@Autowired
	PaiementRepository PaiementRepo;
	
	@Autowired
	PanierRepository PanierRepo;
	
	@Override
	public List<paiement> retrieveAllPaiement() {
		// TODO Auto-generated method stub
		return (List<paiement>) PaiementRepo.findAll();
	}

	@Override
	public paiement addPaiement(paiement p, Long idPanier) {
		// TODO Auto-generated method stub
		panier pa = PanierRepo.findById(idPanier).orElse(null);
		p.setPanier(pa);
		
		p.setNature(p.getNature());
		p.setSomme_total(p.getSomme_total());
		p.setDate(new Date());
		PaiementRepo.save(p);
		return p;
	}

	@Override
	public paiement updatePaiement(paiement p) {
		// TODO Auto-generated method stub
		paiement pa = PaiementRepo.findById(p.getIdPaiement()).get();
		p.setNature(pa.getNature());
		p.setSomme_total(pa.getSomme_total());
		
		return PaiementRepo.save(pa);
	}

	@Override
	public paiement retrievePaiement(Long idPaiement) {
		// TODO Auto-generated method stub
		return PaiementRepo.findById(idPaiement).orElse(null);
	}

	@Override
	public void removePaiement(Long idPaiement) {
		// TODO Auto-generated method stub
		PaiementRepo.deleteById(idPaiement);
	}

	
}