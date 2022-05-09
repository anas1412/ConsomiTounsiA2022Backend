package tn.esprit.Services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;
import tn.esprit.Entities.Publication;
import tn.esprit.Entities.User;
import tn.esprit.Repository.PublicationRepository;
import tn.esprit.Repository.UserRepository;

@Service
@Slf4j
public class PublicationServiceImpl implements PublicationService{
	
	@Autowired
	PublicationRepository publicationRepository;
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Publication findOne(Long idPublication) {
		return publicationRepository.findById(idPublication).get();

	}

	@Override
	public List<Publication> findAll() {
		return (List<Publication>) publicationRepository.findAll();
	}

	
	@Override
	public Publication add(Publication publication, Long id) {
		User user = userRepository.findById(id).orElse(null);
		publication.setUser(user);
		publication.setCreatedAt(LocalDate.now());	
		publication.setUpdatedAt(LocalDate.now());	

		return publicationRepository.save(publication);
	}

	@Override
	public void delete(Long idPublication) {
		publicationRepository.deleteById(idPublication);
	}

	@Override
	public Publication updatePublication(Publication publication) {
	
		Publication publicationp = publicationRepository.findById(publication.getIdPublication()).get();	
		publicationp.setContent(publication.getContent());
        publicationp.setTitle(publication.getTitle());
		//publication.setImage(p.getImage());
		//publication.setUser(publication.getUser());
		publication.setCreatedAt(LocalDate.now());	
		publication.setUpdatedAt(LocalDate.now());		

		return publicationRepository.save(publication);


	}

	@Override
	public List<Publication> retrieveOrderedByDate() {
		return publicationRepository.retrieveOrderedByDate();

	}

	@Override
	public List<Publication> getPublicationsByUser(Long id) {
		User user = userRepository.findById(id).orElse(null);
		List<Publication> listPublications = publicationRepository.findByUser(user);
		
		// 2 eme methode 
		/*
		List<Article> listArticles = new ArrayList<Article>();
		listArticles.addAll(user.getArticles());
		*/		
		return listPublications;
	}

	@Override
	public HashMap<String, Long> SortByComments(Long userId) {
		HashMap<String, Long> hMap = new HashMap<String, Long>();
		List<Object[]> listStaff = publicationRepository.SortByComments(userId);
		for (Object[] obj : listStaff) {
			log.info("------- ADMIN --------------"+(String)obj[0]);
			log.info("------- Publication --------------"+(Long)obj[1]);
			if (hMap.containsKey((String)obj[0])) {
				hMap.put( (String)obj[0] , hMap.get((String)obj[0])+1);
			} else {
			hMap.put( (String)obj[0], 1L);
			}
		}
		return hMap;
	}
	
	@Override
	public HashMap<String, Long> SortByReaction(Long userId) {
			HashMap<String, Long> hMap = new HashMap<String, Long>();
			List<Object[]> listStaff = publicationRepository.SortByReaction(userId);
			for (Object[] obj : listStaff) {
				log.info("------- ADMIN --------------"+(String)obj[0]);
				log.info("------- Publication --------------"+(Long)obj[1]);
				if (hMap.containsKey((String)obj[0])) {
					hMap.put( (String)obj[0] , hMap.get((String)obj[0])+1);
				} else {
				hMap.put( (String)obj[0], 1L);
				}
			}
			return hMap;
	}
	
	@Override
	public HashMap<String, Long> userPreferences(Long idUser) {
		
		HashMap<String, Long> commenthMap = SortByComments(idUser);
		HashMap<String, Long> reactionhMap = SortByReaction(idUser);
	
		log.info("--------- commentmap size"+commenthMap.size());
		log.info("--------- reactionmap size"+reactionhMap.size());
		if (commenthMap.size() > reactionhMap.size()) {
			log.info("--------- MERGING INTO COMMENTHMAP");
			reactionhMap.forEach(
					  (key, value) -> commenthMap.merge(key, value, (v1, v2) -> v1 + v2));
			log.info("MAP ------- 1"+commenthMap);
			return commenthMap;
		} else {
			log.info("--------- MERGING INTO REACTIONHMAP");
			commenthMap.forEach(
					  (key, value) -> reactionhMap.merge(key, value, (v1, v2) -> v1 + v2));
			log.info("MAP ------ 2"+reactionhMap);
			return reactionhMap;
		}
		
		
	}



	

	

}
