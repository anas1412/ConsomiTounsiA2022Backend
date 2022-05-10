package tn.esprit.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entities.User;
import tn.esprit.Entities.paiement;
import tn.esprit.Entities.panierProduit;
import tn.esprit.Entities.produit;
import tn.esprit.Entities.stock;
import tn.esprit.Repository.PaiementRepository;
import tn.esprit.Repository.PanierProduitRepository;
import tn.esprit.Repository.UserRepository;
import tn.esprit.Repository.produitRepository;
import tn.esprit.Repository.stockRepository;


@Service 
public class paiementServiceImpl implements IPaiementService{
	
	@Autowired
	PanierProduitRepository PanierProdRepo;
	
	@Autowired
	UserRepository UserRepo;
	
	@Autowired
	PaiementRepository PaiRepo;
	
	@Autowired
	stockRepository StockRepo;
	
	@Override
	public List<paiement> retrieveAllPaiement() {
		// TODO Auto-generated method stub
		return (List<paiement>) PaiRepo.findAll();
	}

	@Override
	public paiement addPaiement(paiement pa, Long id) {
		// TODO Auto-generated method stub
		User u = UserRepo.findById(id).orElse(null);
		List<panierProduit> produits = PanierProdRepo.findByUser(u);
		pa.setNature(pa.getNature());
		pa.setSommetotal(pa.getSommetotal());
		pa.setDate(new Date());
		pa.setCard(pa.getCard());
		pa.setCvc(pa.getCvc());
		pa.setExp(pa.getExp());
		pa.setUser(u);
		pa.setProduits(produits);
		PaiRepo.save(pa);
		return pa;
	}

	@Override
	public paiement retrievePaiement(Long idPaiement) {
		// TODO Auto-generated method stub
		return PaiRepo.findById(idPaiement).orElse(null);
	}
	
	
	@Override
	public List<paiement> retrievePaiementByUser(Long id) {
		// TODO Auto-generated method stub
		User u = UserRepo.findById(id).orElse(null);
		return PaiRepo.findByUser(u);
	}
	
	@Override
	public List<panierProduit> detailPanier(Long paiement_id) {
		paiement p = PaiRepo.findById(paiement_id).get();
		List<panierProduit> panier = p.getProduits();
		return panier;
	}

	
}