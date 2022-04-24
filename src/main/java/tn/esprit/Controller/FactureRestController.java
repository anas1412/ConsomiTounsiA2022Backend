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

import tn.esprit.Entities.facture;
import tn.esprit.Services.IFactureService;
import tn.esprit.helpers.ZXingHelper;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/facture")
public class FactureRestController {

	@Autowired
	IFactureService factureService;
				//works all
				// http://localhost:8080/SpringMVC/facture/retrieve-all-facture
				@GetMapping("/retrieve-all-facture")
				@ResponseBody
				public List<facture> getFacture() {
				List<facture> listFacture = factureService.retrieveAllFacture();
				return listFacture;
				}

				//http://localhost:8080/SpringMVC/facture/retrieve-facture/{facture-id}
				@GetMapping("/retrieve-facture/{facture-id}")
				@ResponseBody
				public facture retrieveFacture(@PathVariable("facture-id") Long factureId) {
				return factureService.retrieveFacture(factureId);
				}
	
				@RequestMapping(method = RequestMethod.GET)
				public String index(ModelMap modelMap) {
					modelMap.put("facture", factureService.retrieveAllFacture());
					return "facture/index";
				}
				
				//http://localhost:8080/SpringMVC/facture/add-facture
				@PostMapping("/add-facture/{Paiement-id}")
				@ResponseBody
				public facture addFacture(@RequestBody facture f,@PathVariable("Paiement-id") Long idPaiement){	
					facture Facture = factureService.addFacture(f,idPaiement);
				    return Facture;
				}
				
				//http://localhost:8080/SpringMVC/facture/remove-facture/{facture-id}
				@DeleteMapping("/remove-facture/{facture-id}")
				@ResponseBody
				public void removeFacture(@PathVariable("facture-id") Long factureId) {
					factureService.retrieveFacture(factureId);
				}

				//http://localhost:8080/SpringMVC/facture/update-facture
				@PutMapping("/update-facture")
				@ResponseBody
				public facture updateFacture(@RequestBody facture f){	
					facture Facture = factureService.updateFacture(f);
					return Facture;
				}
				
}
