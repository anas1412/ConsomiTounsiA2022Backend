package tn.esprit.Controller;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
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

import tn.esprit.Entities.produit;
import tn.esprit.Services.IProduitServices;
import tn.esprit.helpers.ZXingHelper;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/produit")
public class ProduitRestController {

	@Autowired
	IProduitServices produitService;
	
	
	// http://localhost:8080/SpringMVC/produit/retrieve-all-products
	@GetMapping("/retrieve-all-products")
	@ResponseBody
	public List<produit> getProduits() {
	List<produit> listProduits = produitService.retrieveAllProduits();
	return listProduits;
	}

	
	//http://localhost:8080/SpringMVC/produit/retrieve-produit/{produit-id}
	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public produit retrieveProduit(@PathVariable("produit-id") Long produitId) {
	return produitService.retrieveProduit(produitId);
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("produit", produitService.retrieveAllProduits());
		return "produit/index";
	}

	@RequestMapping(value = "barcode/{produit-id}", method = RequestMethod.GET)
	public void barcode(@PathVariable("produit-id") String produitId, HttpServletResponse response) throws Exception {
		response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(ZXingHelper.getBarCodeImage(produitId, 200, 200));
		outputStream.flush();
		outputStream.close();
	}

	
	@RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<produit> listProducts = produitService.listAll(keyword);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("keyword", keyword);
         
        return "index";
    }
	
	//http://localhost:8080/SpringMVC/produit/add-produit
	@PostMapping("/add-produit/{stock-id}/{user-id}")
	@ResponseBody
	public produit addProduit(@RequestBody produit p,@PathVariable("stock-id")Long idStock,@PathVariable("user-id")Long idUser)
	{	
        
		produit Produit = produitService.addProduit(p,idStock,idUser);
	    return Produit;
	}
	
	

	//http://localhost:8080/SpringMVC/produit/remove-produit/{produit-id}
	@DeleteMapping("/remove-produit/{produit-id}")
	@ResponseBody
	public void removeProduit(@PathVariable("produit-id") Long produitId) {
		produitService.deleteProduit(produitId);
	}

	//http://localhost:8080/SpringMVC/produit/modify-produit
	@PutMapping("/modify-produit")
	@ResponseBody
	public produit updateProduit(@RequestBody produit p)
	{	
		produit Produit = produitService.updateProduit(p);
	return Produit;
	}

	
}
