package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Entities.Cagnotte;
import tn.esprit.Services.ICagnotteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cagnotte")
public class CagnotteRestController {
	
	@Autowired
	ICagnotteService cagnotteInterface;
	
	@GetMapping("/getAllCagnotte")
	@ResponseBody
	public List<Cagnotte> getCagnottes() {
	List<Cagnotte> listCagnotte = cagnotteInterface.retrieveAllCagnottes();
	return listCagnotte;
	}
	
	@GetMapping("/getCagnotte/{id}")
	@ResponseBody
	public Cagnotte retrieveCagnotte(@PathVariable("id") Long idCagnotte) {
	return cagnotteInterface.retrieveCagnotte(idCagnotte);
	}
	
	@PostMapping("/add-getCagnotte")
	@ResponseBody
	public Cagnotte addCagnottet(@RequestBody Cagnotte c)
	{
		Cagnotte cagnotte = cagnotteInterface.addCagnotte(c);
	return cagnotte;
	}
	
	@DeleteMapping("/remove-cagnotte/{idCagnotte-id}")
	@ResponseBody
	public void removeCagnotte(@PathVariable("idCagnotte-id") Long idCagnotte) {
		cagnotteInterface.removeCagnotte(idCagnotte);
	}
	
	@PutMapping("/modify-cagnotte")
	@ResponseBody
	public Cagnotte updateCagnotte(@RequestBody Cagnotte c) {
	return cagnotteInterface.updateCagnotte(c);
	}
	
	@PutMapping("/modify-somme")
	@ResponseBody
	public Cagnotte updateSomme(@RequestBody Cagnotte c) {
	return cagnotteInterface.updateSomme(c);
	}

}
