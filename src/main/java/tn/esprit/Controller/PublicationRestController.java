package tn.esprit.Controller;

import java.util.HashMap;
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
import tn.esprit.Entities.Publication;
import tn.esprit.Services.PublicationService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/publication")

public class PublicationRestController {

	@Autowired
	PublicationService publicationService;
    
	// http://localhost:8089/SpringMVC/publication/retrieve-all-publications
	@GetMapping("/retrieve-all-publications")
	@ResponseBody
	public List<Publication> findAll() {
		List<Publication> listPublications = publicationService.findAll();
		return listPublications;
	}
	// http://localhost:8089/SpringMVC/publication/find-publication/{publication-id}
	@GetMapping("/find-publication/{publication-id}")
	@ResponseBody
	public Publication findPublication(@PathVariable("publication-id") Long idPublication) {

		return publicationService.findOne(idPublication);
	}
	
	//http://localhost:8089/SpringMVC/publication/add-publication/{user-id}
	@PostMapping("/add-publication/{id}")
	@ResponseBody
	public Publication addPublication(@RequestBody Publication publication, @PathVariable("id") Long id ) {

		return publicationService.add(publication,id);
	}
	
	//http://localhost:8089/SpringMVC/publication/remove-publication/{publication-id}
	@DeleteMapping("/remove-publication/{publication-id}")
	@ResponseBody
	public void delete(@PathVariable("publication-id") Long idPublication) {
		publicationService.delete(idPublication);
	}
	
	//http://localhost:8089/SpringMVC/publication/modify-publication
	@PutMapping("/update-publication")
	@ResponseBody
	public Publication updatePublication(@RequestBody Publication publication) {
		return publicationService.updatePublication(publication);
	}
	
	@GetMapping("/retrieve-all-publications-ordered")
	public List<Publication> retrieveOrderedByDate(){
		List<Publication> listPublications = publicationService.retrieveOrderedByDate();
		return listPublications;
	}
	
	@GetMapping("/retrieve-publication/user/{id}")
	public List<Publication> retrievePublicationsByUser(@PathVariable("id") Long id) {
		return publicationService.getPublicationsByUser(id);
	}
	
	@GetMapping("/sortbycomments/user/{user-id}")
	public HashMap<String, Long> SortByComments(@PathVariable("user-id") Long userId) {
		return publicationService.SortByComments(userId);
	}
	
	@GetMapping("/sortbyreactions/user/{user-id}")
	public HashMap<String, Long> SortByReaction(@PathVariable("user-id") Long userId) {
		return publicationService.SortByReaction(userId);
	}
	
	@ApiOperation(value = "sort admins by preferences ")
	@GetMapping("/userPreferences/user/{user-id}")
	public HashMap<String, Long> userPreferences(@PathVariable("user-id") Long userId) {
		return publicationService.userPreferences(userId);
	}
	

	
}
