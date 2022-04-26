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

import tn.esprit.Entities.Don;
import tn.esprit.Services.IDonService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/don")
public class DonRestController {
	
	@Autowired
	IDonService donInterface;
	
	@GetMapping("/getAllDon")
	@ResponseBody
	public List<Don> getDons() {
	List<Don> listDon = donInterface.retrieveAllDons();
	return listDon;
	}
	
	
	@GetMapping("/getDon/{id}")
	@ResponseBody
	public Don retrieveDon(@PathVariable("id") Long idDon) {
	return donInterface.retrieveDon(idDon);
	}
	
	@PostMapping("/add-getDon")
	@ResponseBody
	public Don addDon(@RequestBody Don d)
	{
		Don don = donInterface.addDon(d);
	return don;
	}
	
	@DeleteMapping("/remove-don/{idDon-id}")
	@ResponseBody
	public void removeDon(@PathVariable("idDon-id") Long idDon) {
		donInterface.removeDon(idDon);
	}
	
	@PutMapping("/modify-don")
	@ResponseBody
	public Don updateDon(@RequestBody Don d) {
	return donInterface.updateDon(d);
	}


}
