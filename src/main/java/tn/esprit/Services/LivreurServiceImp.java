package tn.esprit.Services;

import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

import tn.esprit.Configuration.TwilioConfiguration;
import tn.esprit.Entities.Livraison;
import tn.esprit.Entities.Livreur;
import tn.esprit.Entities.Reclamation;
import tn.esprit.Entities.SmsRequest;
import tn.esprit.Entities.TwilioSmsSender;
import tn.esprit.Repository.LivraisonRepository;
import tn.esprit.Repository.LivreurRepository;


@Service
public class LivreurServiceImp implements ILivreurService {
	
	@Autowired
	LivreurRepository LivreurRepo;
	
	@Autowired
	LivraisonRepository LivraisonRepo;
	
	  @Value("${accountSID}")
	    private String accountSID;
	 
	  @Value("${accountAuthToken}")
	    private String accountAuthToken;
	 
	  @Value("${twilloSenderNumber}")
	    private String twilloSenderNumber;
	  
	  @Autowired
	  TwilioSmsSender TwilioSmsSender;

	  @Autowired
	   TwilioConfiguration twilioConfiguration;

	
	
	@Override
	public List<Livreur> retrieveAllLivreurs() {
		// TODO Auto-generated method stub
		return (List<Livreur>) LivreurRepo.findAll();
	}

	@Override
	public Livreur addLivreur(Livreur l) {
		// TODO Auto-generated method stub
		l.setDateAjout(new Date());
		LivreurRepo.save(l);
		return l;
	}

	@Override
	public Livreur updateLivreur(Livreur l) {
		Livreur livreur = LivreurRepo.findById(l.getIdLivreur()).get();
		livreur.setNom(l.getNom());
		livreur.setPrenom(l.getPrenom());
		livreur.setTelephone(l.getTelephone());
		livreur.setNbLivraison(l.getNbLivraison());
		livreur.setVille(l.getVille());
		livreur.setListLivraisons(l.getListLivraisons());
		livreur.setIdLivreur(l.getIdLivreur());
		livreur.setAdresseEmail(l.getAdresseEmail());
		livreur.setImgURL(l.getImgURL());
		livreur.setMdp(l.getMdp());
		// TODO Auto-generated method stub
		LivreurRepo.save(l);
		return l;
	}

	@Override
	public Livreur retrieveLivreur(Long idLivreur) {
		// TODO Auto-generated method stub
		return LivreurRepo.findById(idLivreur).orElse(null);
	}

	@Override
	public void removeLivreur(Long idLivreur) {
		// TODO Auto-generated method stub
		LivreurRepo.deleteById(idLivreur);
		
	}
	
	@Override
	public List<Livreur> findByName(String Nom) {
		return (List<Livreur>)LivreurRepo.findByName(Nom);
	}
	
	public List<Livreur> ShowHired() {
		return (List<Livreur>)LivreurRepo.ShowHired();
	}
	@Override
	public List<Livreur> sortDown() {
		return (List<Livreur>)LivreurRepo.SortDown();
	}


	@Override
	public List<Livreur> findByCity(String Ville)
	{
		return (List<Livreur>)LivreurRepo.findByCity(Ville);

	}
	@Override
	public Livreur AcceptLivreur(Livreur l) {
		
		l.setStatutCompte(true);
		LivreurRepo.save(l);
		return l;
	
}
	@Override
	public Livreur getByEmail(String email) {
		Livreur l= LivreurRepo.getByEmail(email);
		return l;
	}
	
/*	public String NotifyLivreurBySMS(Livreur l) {
	    
	    Twilio.init(accountSID,accountAuthToken); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber("+21655251996"),  
                "+19893941189", 
                "Notif " +l +"a ete traiter  ")      
            .create();     
	 
	return "Message Send Succesfully" ;
}*/


	
	@Override
	public void assignLivreurToLivraison(Long idLivraison,Long idLivreur) {
		Livraison liv =LivraisonRepo.findById(idLivraison).orElse(null);
		Livreur l = LivreurRepo.findById(idLivreur).orElse(null);
		l.setListLivraisons(null);
	            PhoneNumber to = new PhoneNumber(l.getTelephone());
	            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
	            String message = ("Bonjour,\r\n" + l.getNom());
	            MessageCreator creator = Message.creator(to, from, message);
	            creator.create();
		LivreurRepo.save(l);
	}


    

}