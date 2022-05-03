package tn.esprit.Services;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entities.User;
import tn.esprit.Entities.panierProduit;
import tn.esprit.Entities.produit;
import tn.esprit.Repository.PanierProduitRepository;
import tn.esprit.Repository.UserRepository;
import tn.esprit.Repository.produitRepository;
@Service
public class panierProduitServiceImpl implements IPanierProduitService{
	
	@Autowired
	PanierProduitRepository PanierProdRepo;
	
	@Autowired
	UserRepository UserRepo;
	
	@Autowired
	produitRepository ProduitRepo;


	@Override
	public panierProduit addProduit(Long idProduit, int quantity, Long id) {
		// TODO Auto-generated method stub
		produit p = ProduitRepo.findById(idProduit).get();
		User u = UserRepo.findById(id).get();
		int addedQte = quantity;
		
		panierProduit pp = PanierProdRepo.findByUserAndProduit(u, p);
		if (pp != null) {
			addedQte = pp.getQuantity() + quantity;
			pp.setQuantity(addedQte);
			pp.setSomme(pp.getSomme()+(p.getPrix()*quantity));
		}else {
			pp = new panierProduit();
			pp.setQuantity(quantity);
			pp.setProduit(p);
			pp.setUser(u);
			pp.setSomme(p.getPrix()*quantity);
		}
		PanierProdRepo.save(pp);
	    return pp;
	}

	
	@Override
	public void removeProduit(User user,Long idProduit) {
		// TODO Auto-generated method stub
		produit p = ProduitRepo.findById(idProduit).get();
		//User u = UserRepo.findById(id).get();
		PanierProdRepo.deleteByUserAndProduit(user.getId(),idProduit);
	}

	@Override
	public panierProduit updateQte(panierProduit pp) {
		// TODO Auto-generated method stub
		panierProduit pproduit = PanierProdRepo.findById(pp.getIdPanierProduit()).get();
		produit p = ProduitRepo.findById(pp.getProduit().getIdProduit()).get();
		
		pproduit.setQuantity(pp.getQuantity());
		pproduit.setSomme(p.getPrix()*pp.getQuantity());
		PanierProdRepo.save(pp);
	    return pp;
	}

	
	@Override
	public List<panierProduit> detailPanier(Long user_id) {
		User u = UserRepo.findById(user_id).get();
		List<panierProduit> panier = PanierProdRepo.findByUser(u);
		return panier;
	}

	
}
