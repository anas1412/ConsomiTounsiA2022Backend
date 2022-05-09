package tn.esprit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import tn.esprit.Entities.Publication;
import tn.esprit.Entities.Reaction;
import tn.esprit.Entities.ReactionType;



@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long>{

	List<Reaction> findByPublication(Publication publication);
	List<Reaction> findByPublicationAndType(Publication publication,ReactionType reactionType); 

	//List<Reaction> findByArticleAndType(Article article,ReactionType reactionType); 
	
	/*@Query(value = "SELECT r FROM Reaction r WHERE r.type = :reactionType and r.Article = :article")
	List<Reaction> retrieveReactionsByArticleAndType(@Param("article") Article article,
			@Param("reactionType") ReactionType reactionType);*/
}
