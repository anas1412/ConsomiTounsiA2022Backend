package tn.esprit.Services;

import java.util.List;

import tn.esprit.Entities.Rating;

public interface RatingService {
	
	Rating addRating(Long userId , Long publicationId , Rating rating);
	void deleteRating(Long id);
	Rating updateRating(Rating rating);
	//List<Rating> retrieveAllRatings();
	//Rating findOne(Long idRating);
	
	public List<Rating> retrievePublicationRatings(Long publicationId);


}
