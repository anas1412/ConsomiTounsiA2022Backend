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

import lombok.extern.java.Log;
import tn.esprit.Entities.Reclamation;

import tn.esprit.Services.IReclamationService;

@RestController
@RequestMapping("/Reclamation")
public class ReclamationRestController {
	@Autowired
	IReclamationService ReclamationService;
	
	// http://localhost:8080/SpringMVC/Reclamation/retrieve-all-Reclamations
	@GetMapping("/retrieve-all-Reclamations")
	@ResponseBody
	public List<Reclamation> getReclamationrs() {
	List<Reclamation> listReclamations = ReclamationService.retrieveAllReclamations();
	return listReclamations;
	}

	//http://localhost:8080/SpringMVC/Reclamation/retrieve-Reclamation/8
	@GetMapping("/retrieve-Reclamation/{Reclamation-id}")
	@ResponseBody
	public Reclamation retrieveReclamation(@PathVariable("Reclamation-id") Long idReclamation) {
	return ReclamationService.retrieveReclamation(idReclamation);
	}
	// http://localhost:8080/SpringMVC/Reclamation/add-Reclamation
	@PostMapping("/add-Reclamation/{User-id}/{Livraison-id}")
	@ResponseBody
	public Reclamation addReclamation(@RequestBody Reclamation rec,@PathVariable("User-id") Long id,@PathVariable("Livraison-id")Long idLivraison) {
	Reclamation reclamation = ReclamationService.addReclamation(rec,id,idLivraison);
	return reclamation;
	
	}

	//http://localhost:8080/SpringMVC/Reclamation/remove-Reclamation/{Reclamation-id}
	@DeleteMapping("/remove-Reclamation/{Reclamation-id}")
	@ResponseBody
	public void removeReclamation(@PathVariable("Reclamation-id") Long idReclamation) {
	ReclamationService.removeReclamation(idReclamation);
	}

	@PostMapping("/update-Reclamation/{User-id}/{Livraison-id}")
	@ResponseBody
	public Reclamation updateReclamation(@RequestBody Reclamation rec,@PathVariable("User-id") Long id,@PathVariable("Livraison-id")Long idLivraison) {
	Reclamation reclamation = ReclamationService.updateReclamation(rec,id,idLivraison);
	return reclamation;
	}


}
