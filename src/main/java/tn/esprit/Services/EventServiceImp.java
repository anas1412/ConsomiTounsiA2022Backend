package tn.esprit.Services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.Entities.Cagnotte;
import tn.esprit.Entities.Event;
import tn.esprit.Entities.User;
import tn.esprit.Repository.CagnotteRepository;
import tn.esprit.Repository.EventRepository;
// import tn.esprit.Entities.User;
import tn.esprit.Repository.UserRepository;

// import tn.esprit.Repository.UserRepository;



@Service
@Slf4j
public class EventServiceImp implements IEventService {
	@Autowired
	EventRepository eventRepository;
	@Autowired
	CagnotteRepository cagnotteRepository;
	@Autowired
	UserRepository userRepository;

	//@Autowired
	//private MailSendService mailSendService ;
	
	
	
	
	@Override
	public List<Event> retrieveAllEvents() {
		List<Event> eventList = eventRepository.findAll();
		for(Event event : eventList) {
			log.info(event.toString());
		
		}
		return eventList;
	}


	@Override
	public Event addEvent(Event e) {
		//Cagnotte c = cagnotteRepository.findById(idCagnotte).orElse(null);
		 //  c.setIdCagnotte(idCagnotte);
		   e.setDateDebut(new Date());
		   e.setDateFin(new Date());
		   e.setDescription(e.getDescription());
		  // e.setCagnotte(c);
		e.setEtat(0);
		   //mailSendService.sendEmail("ghassen.riahi@esprit.tn","Félicitation, votre évènement est ajouter avec succés"+ " " +e.getLabelle(),"Evénement Ajouté avec succés");
		
		return eventRepository.save(e);
	}

	@Override
	public Event updateEvent(Event e) {
		Event event = eventRepository.findById(e.getIdEvent()).get();
		
		
		event.setDateDebut(e.getDateDebut());
		event.setDateFin(e.getDateFin());
		event.setDescription(e.getDescription());
		event.setImage(e.getImage());
		event.setLabelle(e.getLabelle());
		event.setLieu(e.getLieu());
		event.setEtat(e.getEtat());
		
		//event.getCagnotte();
		eventRepository.save(e);
	    return e;

	}

	@Override
	public Event retrieveEvent(Long id) {
		return eventRepository.findById(id).orElse(null);
		
	}

	@Override
	public void removeEventt(Long id) {
		eventRepository.deleteById(id);
		
	}

	@Override
	public Event addCagnotteToEvent(Event e, Long idCagnotte) {
		Cagnotte c = cagnotteRepository.findById(idCagnotte).orElse(null);
	  // c.setIdCagnotte(idCagnotte);
	   e.setDateDebut(new Date());
	   e.setDateFin(new Date());
	   e.setDescription(e.getDescription());
	   e.setCagnotte(c);
	 
	   
	   eventRepository.save(e);
	   //mailSendService.sendEmail("ghassen.riahi@esprit.tn","Félicitation, L'évènement "+c.getLabelle()+" est ajouter avec succés","Ajout d'évènement");
	  
	   return e;
	}

	@Override
	public Event addEventC(Event e, Long idCagnotte) {
		Cagnotte c = cagnotteRepository.findById(idCagnotte).orElse(null);
		 //  c.setIdCagnotte(idCagnotte);
		   e.setDateDebut(new Date());
		   e.setDateFin(new Date());
		   e.setDescription(e.getDescription());
		   e.setCagnotte(c);
		 
		   
		   eventRepository.save(e);
		   //mailSendService.sendEmail("ghassen.riahi@esprit.tn","Félicitation, L'évènement "+c.getLabelle()+" est ajouter avec succés , veuillez le consulter","Ajout d'un évènement");
			
		  
		   return e;
	}

	@Override
	public Collection<Event> retrieveAllEventsActive() {
		Collection<Event> eventList = eventRepository.findAllActiveEvents();
		for(Event event : eventList) {
			log.info(event.toString());
			System.out.println(event.toString());
		
		}
		return eventList;
	}

	@Override
	public void updateEtat() {
		//Event e = new Event();
		eventRepository.updateEtat(new Date());
		
		
		/*
		Collection<Event> eventList = eventRepository.findAllActiveEvents();
		Date d = new Date();
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		String s = dateFormatter.format(d);
		//Date date = Date.parse(s);
		for(Event event : eventList) {
			System.out.println(d);
					if(event.getDateFin().after(d)) {
						
						event.setEtat(1);
						eventRepository.save(event);
					}
		}
		
		*/
		
	}

	@Override
	public Collection<Event> findEventByCagnotte() {
		Collection<Event> eventList = eventRepository.findEventByCagnotte();
		for(Event event : eventList) {
			log.info(event.toString());
			System.out.println(event.toString());
		
		}
		return eventList;
	}
	
	@Scheduled(cron = "*/60 * * * * *")
	@Override
    public void ExpiredEvent() {
       
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
      String msgDate = sdf.format(now.getMonth());
       /* String finalMessage = "";
        String newLine = System.getProperty("line.separator");*/
        String s = sdf.format(now);
   
        List<Event> eventExpiree = this.retrieveAllEvents();
       
        for (int i = 0; i < eventExpiree.size(); i++) {
            String a = eventExpiree.get(i).getDateFin().toString();
            
            if(a == s ) {
            	eventExpiree.get(i).setEtat(1);
            }
        }
        
    }
	
	@Override
	public int getNombrePlacesEvent(int idevent){
		return eventRepository.NombrePlacesEvent(idevent);		
	}
	
	@Override
	public int getNombreParticpEvent(int idevent){
		return eventRepository.NombreParticpEvent(idevent);
	}

	@Override
	public Event addEvent(Event e, Long idCagnotte, Long idUser) {
		Cagnotte c = cagnotteRepository.findById(idCagnotte).orElse(null);
		User u = userRepository.findById(idUser).orElse(null);
		e.setUser(u);
		 //  c.setIdCagnotte(idCagnotte);
		   e.setDateDebut(new Date());
		   e.setDateFin(new Date());
		   e.setDescription(e.getDescription());
		   e.setCagnotte(c);
		 
		   
		   eventRepository.save(e);
		   //mailSendService.sendEmail("ghassen.riahi@esprit.tn","Félicitation , L'évènement "+c.getLabelle()+ " est ajouter avec succés par "+ e.getUser().getUsername()+" , veuillez le consulter" ,"Ajout d un évènement");
			
		  
		   return e;
	}


	

	
}

	
	
	


