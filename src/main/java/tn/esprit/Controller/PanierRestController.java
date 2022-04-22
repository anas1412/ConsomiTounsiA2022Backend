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
import tn.esprit.Entities.panier;
import tn.esprit.Services.IPanierService;
import tn.esprit.helpers.ZXingHelper;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/panier")
public class PanierRestController {
	
	@Autowired
	IPanierService panierService;
	//works
	// http://localhost:8080/SpringMVC/panier/retrieve-all-panier
		@GetMapping("/retrieve-all-panier")
		@ResponseBody
		public List<panier> getPanier() {
		List<panier> listPanier = panierService.retrieveAllPanier();
		return listPanier;
		}

		//http://localhost:8080/SpringMVC/panier/retrieve-panier/{panier-id}
		@GetMapping("/retrieve-panier/{panier-id}")
		@ResponseBody
		public panier retrievePanier(@PathVariable("panier-id") Long panierId) {
		return panierService.retrievePanier(panierId);
		}
		
		@RequestMapping(method = RequestMethod.GET)
		public String index(ModelMap modelMap) {
			modelMap.put("panier", panierService.retrieveAllPanier());
			return "panier/index";
		}
		
		//http://localhost:8080/SpringMVC/panier/add-panier
		@PostMapping("/add-panier/{User-id}")
		@ResponseBody
		public panier addPanier(@RequestBody panier p, @PathVariable("User-id")Long id){	
			panier Panier = panierService.addPanier(p,id);
		    return Panier;
		}
		
		//http://localhost:8080/SpringMVC/panier/remove-panier/{panier-id}
		@DeleteMapping("/remove-panier/{panier-id}")
		@ResponseBody
		public void removePanier(@PathVariable("panier-id") Long panierId) {
			panierService.removePanier(panierId);
		}
		
		//http://localhost:8080/SpringMVC/panier/add-to-panier
		@PostMapping("/add-to-panier/{Panier-id}/{ProduitPanier-id}")
		@ResponseBody
		public panier addToPanier(@RequestBody panier p, @PathVariable("ProduitPanier-id")Long IdProduitPanier){	
			panier Panier = panierService.addToPanier(p,IdProduitPanier);
			return Panier;
		}
		
		//http://localhost:8080/SpringMVC/panier/remove-from-panier
		@DeleteMapping("/remove-from-panier/{Panier-id}/{ProduitPanier-id}")
		@ResponseBody
		public void removeFromPanier(@RequestBody panier p, @PathVariable("ProduitPanier-id")Long IdProduitPanier){
			panierService.removeFromPanier(p,IdProduitPanier);
		}
				
				
		
}
