package tn.esprit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import tn.esprit.Entities.Publication;
import tn.esprit.Entities.User;


@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
	@Query(value = "SELECT A FROM Publication A ORDER BY A.createdAt DESC")
	List<Publication> retrieveOrderedByDate();
	
	List<Publication> findByUser(User user);
	

			
	   @Query(value = "SELECT A.user.username , A.idPublication "
			+ "FROM Publication A "
			+ "INNER JOIN Commentaire C  "
			+ "ON C.publication.idPublication = A.idPublication "
			+ "WHERE  C.user.id = :userId ")
			List<Object[]> SortByComments(@Param("userId") Long userId);
			
    	@Query(value = "SELECT A.user.username , A.idPublication "
					+ "FROM Publication A "
					+ "INNER JOIN Reaction R "
					+ "ON R.publication.idPublication = A.idPublication " 
					+ "WHERE (R.type = \'Love\' "
					+ "OR R.type =  \'Funny\') And R.user.id = :userId")
					List<Object[]> SortByReaction(@Param("userId") Long userId );
					
		   
			
			
		

}
