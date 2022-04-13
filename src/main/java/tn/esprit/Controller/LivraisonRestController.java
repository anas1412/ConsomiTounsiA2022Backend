package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.esprit.Entities.Livraison;
import tn.esprit.Services.ILivraisonService;

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

	@PostMapping("/update-Livraison/{Facture-id}/{Livreur-id}")
	@ResponseBody
	public Livraison updateLivraison(@RequestBody Livraison liv,@PathVariable("Facture-id") Long idFacture,@PathVariable("Livreur-id")Long idLivreur) {
	Livraison livraison = LivraisonService.updateLivraison(liv,idFacture,idLivreur);
	return livraison;
	}


	}



