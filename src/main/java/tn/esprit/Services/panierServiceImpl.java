package tn.esprit.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entities.User;
import tn.esprit.Entities.panier;
import tn.esprit.Entities.panierProduit;
import tn.esprit.Repository.PanierProduitRepository;
import tn.esprit.Repository.PanierRepository;
import tn.esprit.Repository.UserRepository;


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
	public panier updatePanier(panier p) {
		// TODO Auto-generated method stub		
		return PanierRepo.save(p);
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
		
		panier pa = PanierRepo.findById(p.getIdPanier()).get();
		p.setDate(new Date());
		p.setNbrArticle(pa.getNbrArticle());
		p.setSomme_total(pa.getSomme_total());
		PanierRepo.save(p);
		return p;
	}


	@Override
	public void removePanier(Long idPanier) {
		// TODO Auto-generated method stub
		PanierRepo.deleteById(idPanier);
		
	}

	@Override
	public panier addPanier(panier p) {
		// TODO Auto-generated method stub
		return null;
	}

	
}