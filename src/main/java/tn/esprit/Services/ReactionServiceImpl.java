package tn.esprit.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import tn.esprit.Entities.Publication;
import tn.esprit.Entities.Reaction;
import tn.esprit.Entities.ReactionType;
import tn.esprit.Entities.User;
import tn.esprit.Repository.PublicationRepository;
import tn.esprit.Repository.ReactionRepository;
import tn.esprit.Repository.UserRepository;
@Service
public class ReactionServiceImpl implements ReactionService {
	@Autowired
	ReactionRepository reactionRepository;
	@Autowired
	PublicationRepository publicationRepository ;
	@Autowired
	UserRepository userRepository;
	
	

	@Override
	public Reaction addReaction(Long id, Long publicationId, Reaction react) {
		Publication publication = publicationRepository.findById(publicationId).orElse(null);
		User user = userRepository.findById(id).orElse(null);
		react.setPublication(publication);
		react.setUser(user);
		return reactionRepository.save(react);
	}

	@Override
	public void deleteReaction(Long id) {
		Reaction react = reactionRepository.findById(id).orElse(null);
		reactionRepository.delete(react);	
		
	}

	@Override
	public Reaction updateReaction(Reaction react) {
		Reaction r = reactionRepository.findById(react.getIdReaction()).orElse(null);
		react.setUser(r.getUser());
		react.setPublication(r.getPublication());
		
		return reactionRepository.save(react);
	}

	@Override
	public List<Reaction> retrievePublicationReactions(Long publicationId) {
		Publication publication = publicationRepository.findById(publicationId).orElse(null);
		List<Reaction> reactions =  reactionRepository.findByPublication(publication);
		
		return reactions;
	}
	
	
	// Avec List
		@Override
		public List<User> retrievePublicationReactors(Long publicationId) {
			Publication publication = publicationRepository.findById(publicationId).orElse(null);
			List<Reaction> reactions =  reactionRepository.findByPublication(publication);
			List<User> users = new ArrayList<>();
			
			for(Reaction react : reactions ) {
				users.add(react.getUser());
			}	
			return users;
		}
		
		// avec HashMap -- 
		@Override
		public HashMap<User, ReactionType> retrieveUsersReactions(Long publicationId) {
			Publication publication = publicationRepository.findById(publicationId).orElse(null);
			List<Reaction> reactions =  reactionRepository.findByPublication(publication);
			HashMap<User,ReactionType> user_reaction = new HashMap<User,ReactionType>();
			for(Reaction react : reactions ) {
				user_reaction.put(react.getUser(), react.getType());
			}
			return user_reaction;
		}

		@Override
		public List<User>  retrievePublicationReactorsByType(Long publicationId, ReactionType reactionType) {
			Publication publication = publicationRepository.findById(publicationId).orElse(null);
			List<Reaction> reactions =  reactionRepository.findByPublicationAndType(publication, reactionType);
			
			List<User> users = new ArrayList<>();
			
			for(Reaction react : reactions ) {
				users.add(react.getUser());
			}
			return users;
		}

}
