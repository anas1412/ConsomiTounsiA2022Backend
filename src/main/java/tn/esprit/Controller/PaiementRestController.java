package tn.esprit.Controller;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Entities.paiement;
import tn.esprit.Entities.panierProduit;
import tn.esprit.Services.IPaiementService;
import tn.esprit.Services.IPanierProduitService;
import tn.esprit.helpers.ZXingHelper;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/paiement")
public class PaiementRestController {
	
	@Autowired
	IPaiementService paiementService;
	
			// http://localhost:8080/SpringMVC/paiement/retrieve-all-paiement
			@GetMapping("/retrieve-all-paiement")
			@ResponseBody
			public List<paiement> getPaiement() {
			List<paiement> listPaiement = paiementService.retrieveAllPaiement();
			return listPaiement;
			}
			
			//http://localhost:8080/SpringMVC/paiement/retrieve-paiement/{paiement-id}
			@GetMapping("/retrieve-paiement/{paiement-id}")
			@ResponseBody
			public paiement retrievePaiement(@PathVariable("paiement-id") Long paiementId) {
			return paiementService.retrievePaiement(paiementId);
			}
	
			@RequestMapping(method = RequestMethod.GET)
			public String index(ModelMap modelMap) {
				modelMap.put("paiement", paiementService.retrieveAllPaiement());
				return "paiement/index";
			}
			
			//http://localhost:8080/SpringMVC/paiement/add-paiement
			@PostMapping("/add-paiement/{Panier-id}/")
			@ResponseBody
			public paiement addPaiement(@RequestBody paiement p,@PathVariable("Panier-id") Long idPanier){	
				paiement Paiement = paiementService.addPaiement(p,idPanier);
			    return Paiement;
			}
			
			//http://localhost:8080/SpringMVC/paiement/remove-paiement/{paiement-id}
			@DeleteMapping("/remove-paiement/{paiement-id}")
			@ResponseBody
			public void removePaiement(@PathVariable("paiement-id") Long paiementId) {
				paiementService.removePaiement(paiementId);
			}

			//http://localhost:8080/SpringMVC/paiement/update-paiement
			@PutMapping("/update-paiement")
			@ResponseBody
			public paiement updatePaiement(@RequestBody paiement p){	
				paiement Paiement = paiementService.updatePaiement(p);
				return Paiement;
			}
			
}
