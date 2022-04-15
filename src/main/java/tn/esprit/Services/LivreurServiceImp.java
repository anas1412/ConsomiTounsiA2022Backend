package tn.esprit.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entities.Livraison;
import tn.esprit.Entities.Livreur;
import tn.esprit.Entities.produit;
import tn.esprit.Repository.LivreurRepository;


@Service
public class LivreurServiceImp implements ILivreurService {
	
	@Autowired
	LivreurRepository LivreurRepo;
	
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
		// TODO Auto-generated method stub
		Livreur livreur = LivreurRepo.findById(l.getIdLivreur()).get();
		livreur.getIdLivreur();
		livreur.getDateAjout();
		livreur.getNom();
		livreur.getPrenom();
		livreur.getTelephone();
		livreur.getVille();
		livreur.getNbLivraison();
		livreur.getStatutCompte();
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
	
}
