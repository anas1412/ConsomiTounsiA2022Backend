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

import tn.esprit.Entities.Reclamation;
import tn.esprit.Entities.panierProduit;
import tn.esprit.Services.IPanierProduitService;
import tn.esprit.helpers.ZXingHelper;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/panierProduit")
public class PanierProduitRestController {
	
	@Autowired
	IPanierProduitService panierProduitService;
	
		// http://localhost:8080/SpringMVC/panierproduit/retrieve-all-panierproduit
		@GetMapping("/retrieve-all-panierproduit")
		@ResponseBody
		public List<panierProduit> getPanierProduit() {
		List<panierProduit> listPanierProduit = panierProduitService.retrieveAllPanierProduit();
		return listPanierProduit;
		}

		//http://localhost:8080/SpringMVC/panierproduit/retrieve-panierproduit/{panierproduit-id}
		@GetMapping("/retrieve-panierproduit/{panierproduit-id}")
		@ResponseBody
		public panierProduit retrievePanierProduit(@PathVariable("panierProduit-id") Long panierProduitId) {
		return panierProduitService.retrievePanierProduit(panierProduitId);
		}
		
		@RequestMapping(method = RequestMethod.GET)
		public String index(ModelMap modelMap) {
			modelMap.put("panierProduit", panierProduitService.retrieveAllPanierProduit());
			return "panierproduit/index";
		}
		
		//http://localhost:8080/SpringMVC/panierproduit/add-panierproduit/
		@PostMapping("/add-panierproduit/{panierproduit-id}/{Produit-id}/{Panier-id}/{User-id}/")
		@ResponseBody
		public panierProduit addPanierProduit(@RequestBody panierProduit p,@PathVariable("Produit-id") Long idProduit,@PathVariable("Panier-id")Long idPanier, @PathVariable("User-id")Long id){
			panierProduit PanierProduit = panierProduitService.addPanierProduit(p,idProduit,idPanier,id);
		    return PanierProduit;
		}
		
		//http://localhost:8080/SpringMVC/panierproduit/remove-panierproduit/{panierproduit-id}
		@DeleteMapping("/remove-panierproduit/{panierproduit-id}")
		@ResponseBody
		public void removePanierProduit(@PathVariable("panierproduit-id") Long panierProduitId) {
			panierProduitService.retrievePanierProduit(panierProduitId);
		}

		//http://localhost:8080/SpringMVC/panierproduit/update-panierproduit
		@PutMapping("/update-panierproduit")
		@ResponseBody
		public panierProduit updatePanierProduit(@RequestBody panierProduit p){	
			panierProduit PanierProduit = panierProduitService.updatePanierProduit(p);
			return PanierProduit;
		}
		
}

