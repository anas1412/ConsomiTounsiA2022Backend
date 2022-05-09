package tn.esprit.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.Entities.Publication;
import tn.esprit.Entities.Rating;
import tn.esprit.Entities.User;
import tn.esprit.Repository.PublicationRepository;
import tn.esprit.Repository.RatingRepository;
import tn.esprit.Repository.UserRepository;

@Service
public class RatingServiceImpl implements RatingService{

	
	@Autowired
    RatingRepository ratingRepository;
	@Autowired
	PublicationRepository publicationRepository;
	@Autowired
	UserRepository userRepository;
	

	@Override
	public Rating addRating(Long userId, Long publicationId, Rating rating) {
		User user = userRepository.findById(userId).orElse(null);
		Publication publication = publicationRepository.findById(publicationId).orElse(null);
		rating.setUser(user);
		rating.setPublication(publication);
		
		return ratingRepository.save(rating);
	}

	@Override
	public void deleteRating(Long id) {
		ratingRepository.deleteById(id);
		
	}

	@Override
	public Rating updateRating(Rating rating) {
		return ratingRepository.save(rating);
	}
	
	
	@Override
	public List<Rating> retrievePublicationRatings(Long publicationId) {
		Publication publication = publicationRepository.findById(publicationId).orElse(null);
		List<Rating> ratings =  ratingRepository.findByPublication(publication);
		
		return ratings;
	}


}
