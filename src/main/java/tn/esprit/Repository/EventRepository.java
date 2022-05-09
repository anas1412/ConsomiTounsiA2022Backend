package tn.esprit.Repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import antlr.collections.List;
import tn.esprit.Entities.Event;



@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
	@Query(value = "SELECT e.nbplace FROM event as e WHERE id_event=?1", nativeQuery = true)
	public int NombrePlacesEvent(int idevent);
	
	@Query(value = "SELECT e.nbparticipant FROM event as e WHERE e.id_event=?1", nativeQuery = true)
	public int NombreParticpEvent(int idevent);
	
	@Query(value="SELECT * FROM Event u WHERE u.etat = 0", nativeQuery = true)
	public Collection<Event> findAllActiveEvents();
	
	
	@Modifying
	@Query(value="update Event u set u.etat = 1 WHERE u.DateFin > :d",nativeQuery = true)
	public void updateEtat(Date d);
	
	
	@Query(value="Select * from event e join cagnotte c on e.cagnotte_id_cagnotte = c.id_cagnotte",nativeQuery = true)
	public Collection<Event> findEventByCagnotte();

}
