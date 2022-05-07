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

import io.swagger.annotations.ApiOperation;
import tn.esprit.Entities.Livreur;
import tn.esprit.Services.ILivreurService;
@CrossOrigin("*")
@RestController
@RequestMapping("/Livreur")
public class LivreurRestController {
	@Autowired
	ILivreurService LivreurService;
	
	// http://localhost:8080/SpringMVC/Livreur/retrieve-all-Livreurs
	
	@GetMapping("/retrieve-all-Livreurs")
	@ResponseBody
	public List<Livreur> getLivreurs() {
	List<Livreur> listLivreurs = LivreurService.retrieveAllLivreurs();
	return listLivreurs;
	}

	//http://localhost:8080/SpringMVC/Livreur/retrieve-Livreur/8

	@GetMapping("/retrieve-Livreur/{Livreur-id}")
	@ResponseBody
	public Livreur retrieveLivreur(@PathVariable("Livreur-id") Long idLivreur) {
	return LivreurService.retrieveLivreur(idLivreur);
	}

	//http://localhost:8080/SpringMVC/Livreur/add-Livreur
	
	@PostMapping("/add-Livreur")
	@ResponseBody
	public Livreur addLivreur(@RequestBody Livreur l)
	{
		Livreur Livreur = LivreurService.addLivreur(l);
	return Livreur;
	}

	//http://localhost:8080/SpringMVC/Livreur/remove-Livreur/{Livreur-id}
	@DeleteMapping("/remove-Livreur/{Livreur-id}")
	@ResponseBody
	public void removeLivreur(@PathVariable("Livreur-id") Long idLivreur) {
		LivreurService.removeLivreur(idLivreur);
	}

	//http://localhost:8080/SpringMVC/Livreur/modify-Livreur
	@PutMapping("/update-Livreur")
	@ResponseBody
	public Livreur updateLivreur(@RequestBody Livreur Livreur) {
	return LivreurService.updateLivreur(Livreur);
	}
	
	// http://localhost:8080/SpringMVC/livreur/accept-Livreur
	  
	   @PutMapping("/accept-Livreur")
	   @ResponseBody
	   public Livreur acceptLivreur(@RequestBody Livreur l) {
	   return LivreurService.AcceptLivreur(l);
	   }
	   
	// http://localhost:8080/SpringMVC/Livreur/getByEmail/{email}
	   @GetMapping("/getByEmail/{email}")
	   @ResponseBody
	   public Livreur getByEmail(@PathVariable("email") String email) {
	   return LivreurService.getByEmail(email);
	   }
	   
	   // http://localhost:8080/SpringMVC/Livreur/show-hired
	    @GetMapping("/show-hired")
	    @ResponseBody
	    public List<Livreur> show() {
	    List<Livreur> listlivreurs = LivreurService.ShowHired();
	    return listlivreurs;
	    }
	    
	    @GetMapping("/findByCity/{Ville}")
	    @ResponseBody
	    List<Livreur> findByCity(@PathVariable("Ville") String Ville){
	    	return LivreurService.findByCity(Ville);
	    }
	    
	 /*   @PutMapping("/sendSMS") 
	    @ResponseBody
		@ApiOperation(value = "SMS notif ")
		public void sendSMSforLivreur(@RequestBody Livreur l) {
	    	LivreurService.NotifyLivreurBySMS(l);
		}*/
		@PutMapping("/AssignLivreurToLivraison/{idLivraison}/{idLivreur}")
		@ResponseBody
		public void AssignLivreurToLivraison(@PathVariable("idLivraison")Long idLivraison,@PathVariable("idLivreur") Long idLivreur) {
		 LivreurService.assignLivreurToLivraison(idLivraison, idLivreur);
		}

}
