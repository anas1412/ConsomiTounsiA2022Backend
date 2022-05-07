package tn.esprit.Services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import tn.esprit.Entities.Reclamation;
import tn.esprit.Repository.ReclamationRepository;
import tn.esprit.Repository.UserRepository;
import tn.esprit.Entities.User;
import tn.esprit.Entities.Livraison;
import tn.esprit.Repository.LivraisonRepository;
@Service
public class ReclamationServiceImp implements IReclamationService{
	@Autowired
	ReclamationRepository ReclamationRepo;
	
	@Autowired
	UserRepository UserRepo;
	
	@Autowired
	LivraisonRepository LivraisonRepo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public List<Reclamation> retrieveAllReclamations() {
		// TODO Auto-generated method stub
		return (List<Reclamation>) ReclamationRepo.findAll();
	}

	@Override
	public Reclamation addReclamation(Reclamation rec,Long idUser,Long idLivraison) {
		// TODO Auto-generated method stub
		User u = UserRepo.findById(idUser).orElse(null);
		Livraison livraison = LivraisonRepo.findById(idLivraison).orElse(null);
		rec.setUser(u);
		rec.setLivraison(livraison);
		rec.setDateRec(new Date());
		ReclamationRepo.save(rec);
		return rec;
	}

	@Override
	public Reclamation updateReclamation(Reclamation rec) {
		// TODO Auto-generated method stub
		Reclamation reclamation = ReclamationRepo.findById(rec.getIdReclamation()).get();
	rec.setType(rec.getType());
	rec.setDescription(rec.getDescription());
	rec.setLivraison(rec.getLivraison());
	rec.setUser(rec.getUser());
	rec.setDateRec(new Date());
	rec.setIdReclamation(rec.getIdReclamation());
		ReclamationRepo.save(rec);
		return rec;
	}

	@Override
	public Reclamation retrieveReclamation(Long idReclamation) {
		// TODO Auto-generated method stub
		return ReclamationRepo.findById(idReclamation).orElse(null);
	}

	@Override
	public void removeReclamation(Long idReclamation) {
		// TODO Auto-generated method stub
		ReclamationRepo.deleteById(idReclamation);
}
	@Override
	public void assignReclamationToUser(Long id,Long idReclamation) {
		User u =UserRepo.findById(id).orElse(null);
		Reclamation rec = ReclamationRepo.findById(idReclamation).orElse(null);
		rec.setUser(u);
        ReclamationRepo.save(rec);
	}
	
	@Override
	public void assignReclamationToLivraison(Long idLivraison,Long idReclamation) {
		Livraison liv = LivraisonRepo.findById(idLivraison).orElse(null);
		Reclamation rec = ReclamationRepo.findById(idReclamation).orElse(null);
		rec.setLivraison(liv);
		ReclamationRepo.save(rec);
	}


	
	public void traiterReclamation1() {
	
		SimpleMailMessage msg1 = new SimpleMailMessage();
	
		
	            	msg1.setTo("nourmrad171199@gmail.com","gg0101162@gmail.com");
	      
	          
	                msg1.setSubject("Traitement de réclamation");
	                msg1.setText("Madame, ou Monsieur, (à préciser)\r\n"
	                		+ "\r\n"
	                		+ "Nous avons bien reçu votre réclamtion relatif aux articles défectueux.\r\n"
	                		+ "\r\n"
	                		+ "Nous vous proposons de remplacer les articles défectueux. Cependant, ceux-ci devront nous être retournés dans leur emballage d’origine.\r\n"
	                		+ "\r\n"
	                		+ "Nous vous prions de nous excuser de cet incident.\r\n"
	                		+ "\r\n"
	                		+ "Cordialement,  ");

	                javaMailSender.send(msg1);
	                
	             	
	}
	

	public void traiterReclamation2() {
	
		SimpleMailMessage msg2 = new SimpleMailMessage();
	
		
	            	msg2.setTo("nourmrad171199@gmail.com","gg0101162@gmail.com");
	      
	          
	                msg2.setSubject("Traitement de réclamation");
	                msg2.setText("Madame, ou Monsieur, (à préciser)\r\n"
	                		+ "\r\n"
	                		+ "Comme vous l’avez demandé, nous avons traité votre remboursement, et il devrait apparaître sur votre compte bancaire dans les 3 jours ouvrables suivants.\r\n"
	                		+ "Nous sommes tristes de vous voir partir, mais nous espérons travailler ensemble dans le futur où notre produit sera utile pour vous.\r\n"
	                		+ "Si vous êtes toujours à la recherche d’autres options, n’hésitez pas à me le faire savoir, car je serai en mesure de vous aider à choisir d’autres options qui pourraient vous convenir.\r\n"
	                		+ "Veuillez rester en contact. Passez une excellente journée.\r\n"
	                		+ "\r\n"
	                		+ "\r\n"
	                		+ "Cordialement,  ");

	                javaMailSender.send(msg2);
	                
	             	
	}
	
	public void traiterReclamation3() {
		
		SimpleMailMessage msg3 = new SimpleMailMessage();
	
		
	            	msg3.setTo("nourmrad171199@gmail.com","gg0101162@gmail.com");
	      
	          
	                msg3.setSubject("Traitement de réclamation");
	                msg3.setText("Madame, ou Monsieur, (à préciser)\r\n"
	                		+ "\r\n"
	                		+ "Veuillez m’excuser pour ce problème et le désagrément qu’il vous a causé.\r\n"
	                		+ "En guise de dédommagement, je vous ai remboursé vos frais d’abonnement pour le mois en cours.\r\n"
	                		+ "Nous avons identifié l’origine du problème : il semble que celui-ci soit dû à [explication]. Nous mettons tout en œuvre pour le résoudre au plus vite.\r\n"
	                		+ "Tout devrait ainsi rentrer dans l’ordre d’ici [heure prévue]. Une fois l’accès rétabli, je vous recontacterai pour vous en informer.\r\n"
	                		+ "Nous vous prions de nous excuser de cet incident.\r\n"
	                		+ "\r\n"
	                		+ "Cordialement,  ");

	                javaMailSender.send(msg3);
	                
	             	
	}


}