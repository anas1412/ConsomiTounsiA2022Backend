package tn.esprit.Services;

import java.util.HashMap;
import java.util.List;



import tn.esprit.Entities.Reaction;
import tn.esprit.Entities.ReactionType;
import tn.esprit.Entities.User;



public interface ReactionService {
	Reaction addReaction(Long id , Long publicationId , Reaction react);
	void deleteReaction(Long id);
	Reaction updateReaction(Reaction react);
	List<Reaction> retrievePublicationReactions(Long publicationId);
	
	List<User> retrievePublicationReactors(Long publicationId);
	HashMap<User,ReactionType> retrieveUsersReactions(Long publicationId);
	List<User> retrievePublicationReactorsByType(Long articleId,ReactionType reactionType);

}
