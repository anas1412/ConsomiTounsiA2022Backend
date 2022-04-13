package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Entities.produit;
import tn.esprit.Services.IProduitServices;

@RestController
@RequestMapping("/produit")
public class ProduitRestController {

	@Autowired
	IProduitServices produitService;
	
	
	// http://localhost:8080/SpringMVC/produit/retrieve-all-products
	@GetMapping("/retrieve-all-products")
	@ResponseBody
	public List<produit> getProduits() {
	List<produit> listProduits = produitService.retrieveAllProduits();
	return listProduits;
	}

	
	//http://localhost:8080/SpringMVC/produit/retrieve-produit/{produit-id}
	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public produit retrieveProduit(@PathVariable("produit-id") Long produitId) {
	return produitService.retrieveProduit(produitId);
	}

	
	//http://localhost:8080/SpringMVC/produit/add-produit
	@PostMapping("/add-produit/{categorie-id}/{stock-id}/{user-id}")
	@ResponseBody
	public produit addProduit(@RequestBody produit p,@PathVariable("categorie-id") Long idCategorie,@PathVariable("stock-id")Long idStock,@PathVariable("user-id")Long idUser)
	{	
		produit Produit = produitService.addProduit(p,idCategorie,idStock,idUser);
	    return Produit;
	}
	

	//http://localhost:8080/SpringMVC/produit/remove-produit/{produit-id}
	@DeleteMapping("/remove-produit/{produit-id}")
	@ResponseBody
	public void removeProduit(@PathVariable("produit-id") Long produitId) {
		produitService.retrieveProduit(produitId);
	}

	//http://localhost:8080/SpringMVC/produit/modify-produit
	@PostMapping("/modify-produit/{produit-id}/{stock-id}/{categorie-id}")
	@ResponseBody
	public produit updateProduit(@RequestBody produit p,@PathVariable("produit-id") Long produitId,@PathVariable("categorie-id") Long idCategorie,@PathVariable("stock-id")Long idStock)
	{	
		produit Produit = produitService.updateProduit(p,produitId,idCategorie,idStock);
	return Produit;
	}

	
}
