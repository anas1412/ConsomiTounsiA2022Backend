package tn.esprit.Services;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entities.categorieP;
import tn.esprit.Entities.produit;
import tn.esprit.Entities.stock;
import tn.esprit.Entities.User;
import tn.esprit.Repository.UserRepository;
import tn.esprit.Repository.categoriePRepository;
import tn.esprit.Repository.produitRepository;
import tn.esprit.Repository.stockRepository;



@Service
public class produitServiceImpl implements IProduitServices {

	@Autowired
	produitRepository produitrepo ;
	@Autowired
	stockRepository stockRepository;
	@Autowired
	categoriePRepository caterepo ;
	@Autowired
	UserRepository userrepo ;

	@Override
	public List<produit> retrieveAllProduits() {
		// TODO Auto-generated method stub
		return (List<produit>) produitrepo.findAll();
	}
	

	@Override
	public produit updateProduit(produit p) {
		produit produit = produitrepo.findById(p.getIdProduit()).get();

		
		produit.setCodeProduit(p.getCodeProduit());
		produit.setLibelleProduit(p.getLibelleProduit());
		produit.setDescription(p.getDescription());
		produit.setImage(p.getImage());
		produit.setPrix(p.getPrix());
		
		//p.setDateCreation(new Date());
		produitrepo.save(p);
	    return p;
		
	}
	

	@Override
	public produit retrieveProduit(Long id) {
		// TODO Auto-generated method stub
		return produitrepo.findById(id).orElse(null);
	}
	
	
	@Override
	public produit addProduit(produit p, Long idCategorieProduit, Long idStock, Long idUser) {		
		stock stock = stockRepository.findById(idStock).orElse(null);
		categorieP cp = caterepo.findById(idCategorieProduit).orElse(null);
		User u = userrepo.findById(idUser).orElse(null);
		p.setCategorieP(cp);
		p.setStock(stock);
		p.setUser(u);
		p.setDateCreation(new Date());
		produitrepo.save(p);
	    return p;		
	}
	

	@Override
	public void deleteProduit(Long id) {
		// TODO Auto-generated method stub
		produitrepo.deleteById(id);
		
	}


	@Override
	public List<produit> listAll(String keyword) {
		if (keyword != null) {
			return produitrepo.search(keyword);
		}
		return (List<produit>) produitrepo.findAll();
	}
	
		
}
