package tn.esprit.Services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entities.User;
import tn.esprit.Entities.panier;
import tn.esprit.Entities.panierProduit;
import tn.esprit.Repository.PanierProduitRepository;
import tn.esprit.Repository.PanierRepository;
import tn.esprit.Repository.UserRepository;
import tn.esprit.Services.panierProduitServiceImpl;


@Service 
public class panierServiceImpl implements IPanierService{
	@Autowired
	PanierRepository PanierRepo;
	
	@Autowired
	PanierProduitRepository PanierProduitRepo;
	
	@Autowired
	UserRepository UserRepo;
	
	

	@Override
	public List<panier> retrieveAllPanier() {
		// TODO Auto-generated method stub
		return (List<panier>) PanierRepo.findAll();
	}
	

	@Override
	public panier retrievePanier(Long idPanier) {
		// TODO Auto-generated method stub
		return PanierRepo.findById(idPanier).orElse(null);
	}

	@Override
	public panier addPanier(panier p, Long id) {
		// TODO Auto-generated method stub
		User u = UserRepo.findById(id).orElse(null);
		p.setUser(u);
		PanierRepo.save(p);
		return p;
	}


	@Override
	public void removePanier(Long idPanier) {
		// TODO Auto-generated method stub
		PanierRepo.deleteById(idPanier);
		
	}


	@Override
	public panier addToPanier(panier p, Long IdPanierProduit) {
		// TODO Auto-generated method stub

		panierProduit pp = PanierProduitRepo.findById(IdPanierProduit).orElse(null);
		pp.setPanier(p);
		PanierRepo.save(p);
		return p;
	}


	@Override
	public void removeFromPanier(panier p, Long IdPanierProduit) {
		// TODO Auto-generated method stub
		PanierProduitRepo.deleteById(IdPanierProduit);
	}

	
}