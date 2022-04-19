package tn.esprit.Services;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entities.User;
import tn.esprit.Entities.panier;
import tn.esprit.Entities.panierProduit;
import tn.esprit.Entities.produit;
import tn.esprit.Repository.PanierProduitRepository;
import tn.esprit.Repository.PanierRepository;
import tn.esprit.Repository.UserRepository;
import tn.esprit.Repository.produitRepository;
@Service
public class panierProduitServiceImpl implements IPanierProduitService{
	
	@Autowired
	PanierProduitRepository PanierProduitRepo;
	
	@Autowired
	UserRepository UserRepo;
	
	@Autowired
	produitRepository ProduitRepo;
	
	@Autowired
	PanierRepository PanierRepo;
	
	@Override
	public List<panierProduit> retrieveAllPanierProduit() {
		// TODO Auto-generated method stub
		return (List<panierProduit>) PanierProduitRepo.findAll();
	}

	@Override
	public panierProduit addPanierProduit(panierProduit pp, Long idProduit) {
		// TODO Auto-generated method stub
		
		produit p = ProduitRepo.findById(idProduit).orElse(null);
		pp.setProduit(p);
		
		int q = pp.getQte();
		pp.setQte(q);
		
		float s = p.getPrix();
		pp.setSomme(s*q);
		
		PanierProduitRepo.save(pp);
		return pp;
	}
	
	@Override
	public panierProduit updatePanierProduit(panierProduit pp) {
		// TODO Auto-generated method stub
		panierProduit panierproduit = PanierProduitRepo.findById(pp.getIdPanierProduit()).get();
		int q = pp.getQte();
		panierproduit.setQte(q);
		
		float p = pp.getProduit().getPrix();
		panierproduit.setSomme(p*q);
		return PanierProduitRepo.save(pp);
	}
		
	@Override
	public panierProduit retrievePanierProduit(Long idPanierProduit) {
		// TODO Auto-generated method stub
		return PanierProduitRepo.findById(idPanierProduit).orElse(null);
	}
	
	@Override
	public void removePanierProduit(Long idPanierProduit) {
		// TODO Auto-generated method stub
		PanierProduitRepo.deleteById(idPanierProduit);
		
	}
	
}
