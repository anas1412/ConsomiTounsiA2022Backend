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
import org.springframework.web.bind.annotation.RestController;



import tn.esprit.Services.ReactionService;

import tn.esprit.Entities.Reaction;
import tn.esprit.Entities.ReactionType;
import tn.esprit.Entities.User;

@RestController
@RequestMapping("/reaction")
@CrossOrigin(origins = "http://localhost:4200")
public class ReactionRestController {

		@Autowired
		ReactionService reactionService;
		
		@PostMapping("/add-reaction/{publication-id}/{user-id}") 
		public Reaction addReaction(@RequestBody Reaction react, @PathVariable("publication-id") Long idPublication,
				@PathVariable("user-id") Long userId) {
			
			return reactionService.addReaction(userId,idPublication,react);
		}
		
		@DeleteMapping("/remove-reaction/{reaction-id}")
		public void removeReaction(@PathVariable("reaction-id") Long reactionId) {
			reactionService.deleteReaction(reactionId);
		}
		
		@PutMapping("/modify-reaction")
		public Reaction modifyReaction(@RequestBody  Reaction react) {
			return reactionService.updateReaction(react);
		}
		
		@GetMapping("/retrieve-publicationreactions/{publication-id}") 
		public List<Reaction> retrievePublicationReactions(@PathVariable("publication-id") Long idPublication) {
			
			return reactionService.retrievePublicationReactions(idPublication);
		}
	
		
		
		@GetMapping("/retrieve-publicationreactors/{publication-id}") 
		public List<User> retrievePublicationReactors(@PathVariable("publication-id") Long publicationId) {
			
			return reactionService.retrievePublicationReactors(publicationId);
		}
		
		
		// HashMap 
		@GetMapping("/retrieve-usersreaction/{publication-id}") 
		public HashMap<User,ReactionType> retrieveUsersReactions(@PathVariable("publication-id") Long publicationId) {
			
			return reactionService.retrieveUsersReactions(publicationId);
		}
		
		
		
		@GetMapping("/retrieve-publicationreactors/{publication-id}/type/{reaction-type}") 
		public List<User> retrieveArticleReactorsByType(@PathVariable("publication-id") Long publicationId , 
				@PathVariable("reaction-type") ReactionType reactionType) {
			
			return reactionService.retrievePublicationReactorsByType(publicationId,reactionType);
		}
		
	}



