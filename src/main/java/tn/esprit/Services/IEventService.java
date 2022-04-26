package tn.esprit.Services;

import java.util.Collection;
import java.util.List;

import tn.esprit.Entities.Event;

public interface IEventService {
	List<Event> retrieveAllEvents();

	Event addEvent(Event e);
	
	Event addCagnotteToEvent (Event e,Long idCagnotte);

	Event updateEvent(Event e);

	Event retrieveEvent(Long id);

	void removeEventt(Long id);
	public Event addEventC(Event e,Long idCagnotte );
	
	Collection<Event> retrieveAllEventsActive();
	
	void updateEtat();
	


	
	

}
