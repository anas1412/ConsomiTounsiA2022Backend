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
import tn.esprit.Entities.Rating;
import tn.esprit.Services.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingRestController {
	@Autowired
	RatingService ratingService;
	
		@PostMapping("/add-rating/{user-id}/{publication-id}")
		public Rating addRating(@PathVariable("user-id")Long userId, @PathVariable("publication-id")Long publicationId,@RequestBody Rating r) {
		return ratingService.addRating(userId,publicationId,r);
		}
	 
	// http://localhost:8089/SpringMVC/Rating/remove-Rating/{Rating-id}
			@DeleteMapping("/remove-Rating/{Rating-id}")
			public void removeRating(@PathVariable("Rating-id") Long RatingId) {
				ratingService.deleteRating(RatingId);
			}
			
	
			// http://localhost:8089/SpringMVC/Rating/modify-Rating
			@PutMapping("/modify-rating")
			public Rating modifyRating(@RequestBody Rating rating) {
			return ratingService.updateRating(rating);
			}
			
			@GetMapping("/retrieve-publication-ratings/{publication-id}")
			public List<Rating> retrievePublicationRatings(@PathVariable("publication-id") Long publicationId) {
			return ratingService.retrievePublicationRatings(publicationId);
			
	}

}
