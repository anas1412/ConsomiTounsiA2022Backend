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

import tn.esprit.Entities.panierProduit;
import tn.esprit.Services.IPanierProduitService;
import tn.esprit.helpers.ZXingHelper;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/panierproduit")
public class PanierProduitRestController {
	
	@Autowired
	IPanierProduitService PanierProduitService;
	
	
		//works
		// http://localhost:8080/SpringMVC/panierproduit/retrieve-all-panierproduit
		@GetMapping("/retrieve-all-panierproduit")
		@ResponseBody
		public List<panierProduit> getPanierProduit() {
		List<panierProduit> listPanierProduit = PanierProduitService.retrieveAllPanierProduit();
		return listPanierProduit;
		}

		//works
		//http://localhost:8080/SpringMVC/panierproduit/retrieve-panierproduit/{panierproduit-id}
		@GetMapping("/retrieve-panierproduit/{panierProduit-id}")
		@ResponseBody
		public panierProduit retrievePanierProduit(@PathVariable("panierProduit-id") Long panierProduitId) {
		return PanierProduitService.retrievePanierProduit(panierProduitId);
		}
		
		@RequestMapping(method = RequestMethod.GET)
		public String index(ModelMap modelMap) {
			modelMap.put("panierProduit", PanierProduitService.retrieveAllPanierProduit());
			return "panierproduit/index";
		}
		
		//works
		//http://localhost:8080/SpringMVC/panierproduit/add-panierproduit/{Produit-id}/
		@PostMapping("/add-panierproduit/{Produit-id}")
		@ResponseBody
		public panierProduit addPanierProduit(@RequestBody panierProduit p, @PathVariable("Produit-id") Long idProduit){
			panierProduit PanierProduit = PanierProduitService.addPanierProduit(p,idProduit);
		    return PanierProduit;
		}
		
		//works
		//http://localhost:8080/SpringMVC/panierproduit/remove-panierproduit/{panierproduit-id}
		@DeleteMapping("/remove-panierproduit/{panierproduit-id}")
		@ResponseBody
		public void removePanierProduit(@PathVariable("panierproduit-id") Long panierProduitId) {
			PanierProduitService.removePanierProduit(panierProduitId);
		}

		//works
		//http://localhost:8080/SpringMVC/panierproduit/update-panierproduit/{panierproduit-id}/
		@PutMapping("/update-panierproduit/")
		@ResponseBody
		public panierProduit updatePanierProduit(@RequestBody panierProduit p){	
			panierProduit PanierProduit = PanierProduitService.updatePanierProduit(p);
			return PanierProduit;
		}
		
}

