package tn.esprit.Services;

import java.util.HashMap;
import java.util.List;


import tn.esprit.Entities.Publication;



public interface PublicationService {
	
	Publication findOne(Long idPublication);
	List<Publication> findAll();
	public Publication add(Publication publication, Long id);
	void delete(Long idPublication);
	Publication updatePublication(Publication publication);
	
	List<Publication> retrieveOrderedByDate();
	List<Publication> getPublicationsByUser(Long id);
	
	HashMap<String, Long> SortByComments(Long userId);
	HashMap<String,Long> SortByReaction(Long userId);
	HashMap<String, Long> userPreferences(Long idUser);

 





	

}
