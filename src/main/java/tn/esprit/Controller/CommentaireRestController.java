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




import tn.esprit.Entities.Commentaire;
import tn.esprit.Services.CommentaireService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/commentaire")
public class CommentaireRestController {
	@Autowired
	CommentaireService 	commentaireService ;
	
	//http://localhost:8089/SpringMVC/commentaire/add-commenatire/{publication-id}/{user-id}

	@PostMapping("/add-commentaire/{publication-id}/{id}")
	public Commentaire addCommentaire(@RequestBody Commentaire comment, @PathVariable("publication-id") Long idPublication,
			@PathVariable("id") Long id) {
		
		return commentaireService.addCommentaire(id, idPublication, comment);
	}

	
	@DeleteMapping("/delete-commentaire/{commentaire-id}")
	public void deleteCommentaire(@PathVariable("commentaire-id") Long commentaireId) {
		commentaireService.deleteCommentaire(commentaireId);
	}

	@PutMapping("/update-commentaire")
	public Commentaire updateCommentaire(@RequestBody Commentaire commentaire) {
		return commentaireService.updateCommentaire(commentaire);
	}

	// http://localhost:8087/SpringMVC/commentaire/find-all-comments
	/*@GetMapping("/find-all-comments")
	public List<Commentaire> findAll() {
		List<Commentaire> listCommentaires = commentaireService.retrieveAllCommentaires();
		return listCommentaires;
	}*/
	
	@GetMapping("/retrieve-publicationcomments/{publication-id}") 
	public List<Commentaire> retrieveAllCommentaires(@PathVariable("publication-id") Long publicationId) {
		
		return commentaireService.retrieveAllCommentaires(publicationId);
	}
	
	// http://localhost:8087/SpringMVC/commentaire/find-commentaire/{commentaire-id}
	
	@GetMapping("/find-commentaire/{commentaire-id}")
		@ResponseBody
		public Commentaire findCommentaire(@PathVariable("commentaire-id") Long idCommentaire) {

			return commentaireService.findOne(idCommentaire);
		}
		
		
}
