package tn.esprit.Repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import antlr.collections.List;
import tn.esprit.Entities.Event;



@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
	
	@Query(value="SELECT * FROM Event u WHERE u.etat = 0", nativeQuery = true)
	public Collection<Event> findAllActiveEvents();
	
	
	@Modifying
	@Query(value="update Event u set u.etat = 1 WHERE u.DateFin > CURRENT_DATE",nativeQuery = true)
	public void updateEtat();
	

}
