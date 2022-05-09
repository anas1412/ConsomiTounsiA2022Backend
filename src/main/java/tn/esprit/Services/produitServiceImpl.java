package tn.esprit.Services;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entities.produit;
import tn.esprit.Entities.stock;
import tn.esprit.Entities.User;
import tn.esprit.Repository.UserRepository;
import tn.esprit.Repository.produitRepository;
import tn.esprit.Repository.stockRepository;



@Service
public class produitServiceImpl implements IProduitServices {

	@Autowired
	produitRepository produitrepo ;
	@Autowired
	stockRepository stockRepository;
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


		produit.setCategorieProduit(p.getCategorieProduit());
		produit.setLibelleProduit(p.getLibelleProduit());
		produit.setDescription(p.getDescription());
		produit.setImage(p.getImage());
		produit.setPrix(p.getPrix());
		

		produitrepo.save(p);
	    return p;
		
	}
	

	@Override
	public produit retrieveProduit(Long id) {
		// TODO Auto-generated method stub
		return produitrepo.findById(id).orElse(null);
	}
	
	@Override
	public produit addProduit(produit p,Long idStock, Long idUser) {		
		stock stock = stockRepository.findById(idStock).orElse(null);
		User u = userrepo.findById(idUser).orElse(null);
		
		
		String link = "https://www.youtube.com/embed/";		
		
        String url = p.getImage();
        
        url = url.substring(url.length()-11);
        
        link = link + url;
		       
		p.setStock(stock);
		p.setUser(u);
		p.setDateCreation(new Date());
		p.setImage(link);
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


	@Override
	public List<produit> FindByIdUser(Long id) {
		return (List<produit>) produitrepo.findByIdUser(id);
	}
	
	
	@Override
	public void AssagnProductStock(Long idStock, Long idProduct) {
		
			stock st = stockRepository.findById(idStock).orElse(null);
			produit p = produitrepo.findById(idProduct).orElse(null);
			p.setStock(st); //cle etrangere
			produitrepo.save(p);
				
			
		}


	@Override
	public List<produit> findByIdstock(Long id) {
		// TODO Auto-generated method stub
		return (List<produit>) produitrepo.findByIdstock(id);
	}


		
}
