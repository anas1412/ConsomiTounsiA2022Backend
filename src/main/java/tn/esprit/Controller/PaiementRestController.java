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


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/paiement")
public class PaiementRestController {
	
	@Autowired
	IPaiementService paiementService;
	
	@Autowired
	IPanierProduitService PanierProdService;
	
			@RequestMapping(method = RequestMethod.GET)
			public String index(ModelMap modelMap) {
				modelMap.put("paiement", paiementService.retrieveAllPaiement());
				return "paiement/index";
			}
			
			//done
			//http://localhost:8080/SpringMVC/paiement/add-paiement/{user-id}
			@PostMapping("/add-paiement/{user-id}")
			@ResponseBody
			public paiement addPaiement(@RequestBody paiement p, @PathVariable("user-id") Long userId){	
				paiement Paiement = paiementService.addPaiement(p,userId);
			    return Paiement;
			}
			
			//done
			// http://localhost:8080/SpringMVC/paiement/retrieve-all-paiement
			@GetMapping("/retrieve-all-paiement")
			@ResponseBody
			public List<paiement> getPaiement() {
			List<paiement> listPaiement = paiementService.retrieveAllPaiement();
			return listPaiement;
			}
			
			//done
			//http://localhost:8080/SpringMVC/paiement/retrieve-paiement/{paiement-id}
			@GetMapping("/retrieve-paiement/{paiement-id}")
			@ResponseBody
			public paiement retrievePaiement(@PathVariable("paiement-id") Long paiementId) {
			return paiementService.retrievePaiement(paiementId);
			}
			
			
			// http://localhost:8080/SpringMVC/paiement/retrieve-paiement-produits/{paiement-id}
			@GetMapping("/retrieve-paiement-produits/{paiement-id}")
			@ResponseBody
			public List<panierProduit> getPanierParPaiement(@PathVariable("paiement-id") Long paiementId) {
				List<panierProduit> produits = PanierProdService.detailPanier(paiementId);
				return produits;
			}
			
			
			
			
			//http://localhost:8080/SpringMVC/paiement/retrieve-paiements-by-user/{user-id}
			@GetMapping("/retrieve-paiements-by-user/{user-id}")
			@ResponseBody
			public List<paiement> retrievePaiementsByUser(@PathVariable("user-id") Long usertId) {
			return paiementService.retrievePaiementByUser(usertId);
			}
			
			
}
