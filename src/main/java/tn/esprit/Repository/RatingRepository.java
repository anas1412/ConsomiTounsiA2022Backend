package tn.esprit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.Publication;
import tn.esprit.Entities.Rating;


@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
	
    List<Rating> findByPublication(Publication publication);


}
