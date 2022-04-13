package tn.esprit.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Override
	public List<Reclamation> retrieveAllReclamations() {
		// TODO Auto-generated method stub
		return (List<Reclamation>) ReclamationRepo.findAll();
	}

	@Override
	public Reclamation addReclamation(Reclamation rec,Long id,Long idLivraison) {
		// TODO Auto-generated method stub
		User u = UserRepo.findById(id).orElse(null);
		Livraison livraison = LivraisonRepo.findById(idLivraison).orElse(null);
		rec.setUser(u);
		rec.setLivraison(livraison);
		rec.setDateRec(new Date());
		ReclamationRepo.save(rec);
		return rec;
	}

	@Override
	public Reclamation updateReclamation(Reclamation rec,Long id,Long idLivraison) {
		// TODO Auto-generated method stub
		User u = UserRepo.findById(id).orElse(null);
		Livraison livraison = LivraisonRepo.findById(idLivraison).orElse(null);
		rec.setUser(u);
		rec.setLivraison(livraison);
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
}