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

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import tn.esprit.Entities.User;
import tn.esprit.Entities.facture;
import tn.esprit.Entities.panierProduit;
import tn.esprit.Repository.UserRepository;
import tn.esprit.Services.IPanierProduitService;
import tn.esprit.helpers.ZXingHelper;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/panierproduit")
public class PanierProduitRestController {
	
	@Autowired
	IPanierProduitService PanierProdService;
	
	@Autowired
	UserRepository UserRepo;
	
	
	
		//http://localhost:8080/SpringMVC/panierproduit/addToPanier/{produit-id}/{qte}/{user-id}
		@PostMapping("/addToPanier/{produit-id}/{qte}/{user-id}")
		public panierProduit addToPanier(@PathVariable("produit-id") Long produitId, @PathVariable("qte") int quantity, @PathVariable("user-id") Long userId) {
			panierProduit pp = PanierProdService.addProduit(produitId,quantity,userId);
			return pp ;
		}
		
		// http://localhost:8080/SpringMVC/panierproduit/getPanier/{user-id}
		@GetMapping("/getPanier/{user-id}")
		@ResponseBody
		public List<panierProduit> getPanier(@PathVariable("user-id") long userid) {
			List<panierProduit> panier = PanierProdService.detailPanier(userid);
			return panier;
		}
		
		// http://localhost:8080/SpringMVC/panierproduit/getPanierProduit/{panierproduit-id}
		@GetMapping("/getPanierProduit/{panierproduit-id}")
		@ResponseBody
		public panierProduit getPanierProduit(@PathVariable("panierproduit-id") long ppid) {
					panierProduit pp = PanierProdService.retrievePanierProduit(ppid);
					return pp;
				}
		
		// http://localhost:8080/SpringMVC/panierproduit/updateQuantity/
		@PutMapping("/updateQuantity")
		//@ResponseBody
		public panierProduit updateQuantity(
				@RequestBody panierProduit pp
				) {
			PanierProdService.updateQte(pp);
			return pp;
		}
		
		
		//http://localhost:8080/SpringMVC/panierproduit/removeFromPanier/{user-id}/{produit-id}
		@DeleteMapping("/removeFromPanier/{user-id}/{produit-id}")
		@ResponseBody
		public void removeFromPanier(@PathVariable("user-id") Long userId,
				@PathVariable("produit-id") Long produitId) {
				User u = UserRepo.findById(userId).get();
				PanierProdService.removeProduit(u,produitId);
		}
		
		
}

