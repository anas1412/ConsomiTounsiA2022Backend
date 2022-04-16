package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
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

import tn.esprit.Entities.categorieP;
import tn.esprit.Services.ICategorieServices;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/categorie")
public class CategorieRestController {

	@Autowired
	ICategorieServices categorieService;
	
	
	// http://localhost:8080/SpringMVC/categorie/retrieve-all-categories
	@GetMapping("/retrieve-all-categories")
	@ResponseBody
	public List<categorieP> getCategories() {
	List<categorieP> listCategories = categorieService.retrieveAllCategorieProduits();
	return listCategories;
	}

	//http://localhost:8080/SpringMVC/categorie/retrieve-categorie/{categorie-id}
	@GetMapping("/retrieve-categorie/{categorie-id}")
	@ResponseBody
	public categorieP retrieveStock(@PathVariable("categorie-id") Long categorieId) {
	return categorieService.retrieveCategorieProduit(categorieId);
	}

	
	//http://localhost:8080/SpringMVC/categorie/add-categorie
	@PostMapping("/add-categorie")
	@ResponseBody
	public categorieP addStock(@RequestBody categorieP cp)
	{
		categorieP categorieP = categorieService.addCategorieProduit(cp);
	return categorieP;
	}

	
	//http://localhost:8080/SpringMVC/categorie/remove-categorie/{categorie-id}
	@DeleteMapping("/remove-categorie/{categorie-id}")
	@ResponseBody
	public void removeCategorie(@PathVariable("categorie-id") Long categorieId) {
		categorieService.removeCategorieProduit(categorieId);
	}

	
	//http://localhost:8080/SpringMVC/categorie/modify-categorie
	@PutMapping("/modify-categorie")
	@ResponseBody
	public categorieP modifyCategorie(@RequestBody categorieP categorieP) {
	return categorieService.addCategorieProduit(categorieP);
	}
	
	@RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<categorieP> listCategories = categorieService.listAll(keyword);
        model.addAttribute("listCategories", listCategories);
        model.addAttribute("keyword", keyword);
         
        return "index";
    }
	
}