package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.esprit.Entities.Livraison;
import tn.esprit.Services.ILivraisonService;
@CrossOrigin("*")
@RestController
@RequestMapping("/Livraison")
public class LivraisonRestController {
	@Autowired
	ILivraisonService LivraisonService;
	
	// http://localhost:8080/SpringMVC/Livraison/retrieve-all-Livraisons
	@GetMapping("/retrieve-all-Livraisons")
	@ResponseBody
	public List<Livraison> getLivraisons() {
	List<Livraison> listLivraisons = LivraisonService.retrieveAllLivraisons();
	return listLivraisons;
	}

	//http://localhost:8080/SpringMVC/Livraison/retrieve-Livraison/8
	@GetMapping("/retrieve-Livraison/{Livraison-id}")
	@ResponseBody
	public Livraison retrieveLivraison(@PathVariable("Livraison-id") Long idLivraison) {
	return LivraisonService.retrieveLivraison(idLivraison);
	}

	@PostMapping("/add-Livraison/{Facture-id}/{Livreur-id}")
	@ResponseBody
	public Livraison addLivraison(@RequestBody Livraison liv,@PathVariable("Facture-id") Long idFacture,@PathVariable("Livreur-id")Long idLivreur) {
	Livraison livraison = LivraisonService.addLivraison(liv,idFacture,idLivreur);
	return livraison;
	}

	@PostMapping("/update-Livraison")
	@ResponseBody
	public Livraison updateLivraison(@RequestBody Livraison liv) {
	Livraison livraison = LivraisonService.updateLivraison(liv);
	return livraison;
	}

	 // http://localhost:8080/SpringMVC/Livraison/count-delivered
	@GetMapping("/count-delivered")
	@ResponseBody
	public int countDelivered() {
	int x1 = LivraisonService.CountDelivered();
	return x1;
	}
	
	// http://localhost:8080/SpringMVC/Livraison/count-undelivered
			@GetMapping("/count-undelivered")
			@ResponseBody
			public int countUndelivered() {
			int x2 = LivraisonService.CountUndelivered();
			return x2;
			}
			
			// http://localhost:8080/SpringMVC/Livraison/deliver-livraison/{idLivraison}
			   @PutMapping("/deliver-livraison/{idLivraison}")
			   @ResponseBody
			   public Livraison deliverLivraison(@PathVariable("idLivraison") Long idLivraison) {
			   return LivraisonService.deliverLivraison(idLivraison);
			   }
			   
			// http://localhost:8080/SpringMVC/Livraison/GetLivraisonByIdLivreur/{livreur-id}
				 @GetMapping("/GetLivraisonByIdLivreur/{livreur-id}")
				 @ResponseBody
				 public List<Livraison> GetLivraisonByIdLivreur(@PathVariable("livreur-id") Long idLivreur) {
					 List<Livraison> listlivraisons = LivraisonService.FindByIdLivreur(idLivreur);
						return listlivraisons;			 
					 }
				 
					//http://localhost:8080/SpringMVC/Livraison/remove-Livraison/{Livraison-id}
					@DeleteMapping("/remove-Livraison/{Livraison-id}")
					@ResponseBody
					public void removeLivraison(@PathVariable("Livraison-id") Long idLivraison) {
						LivraisonService.removeLivraison(idLivraison);
					}
	}



