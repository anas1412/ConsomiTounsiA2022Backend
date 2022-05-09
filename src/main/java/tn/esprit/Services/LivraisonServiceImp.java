package tn.esprit.Services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entities.facture;
import tn.esprit.Entities.Livraison;
import tn.esprit.Entities.Livreur;

import tn.esprit.Repository.LivraisonRepository;
import tn.esprit.Repository.LivreurRepository;
import tn.esprit.Repository.FactureRepository;
@Service 
public class LivraisonServiceImp implements ILivraisonService{
	@Autowired
	LivreurRepository LivreurRepo;
	@Autowired
	FactureRepository FactureRepo;
	@Autowired
	LivraisonRepository LivraisonRepo;
	

	@Override
	public List<Livraison> retrieveAllLivraisons() {
		// TODO Auto-generated method stub
		return (List<Livraison>) LivraisonRepo.findAll();
	}

	@Override
	public Livraison updateLivraison(Livraison liv) {
		// TODO Auto-generated method stub
		Livraison livraison = LivraisonRepo.findById(liv.getIdLivraison()).get();
		livraison.setAdresse(liv.getAdresse());
		livraison.setFacture(liv.getFacture());
		livraison.setFrais(liv.getFrais());
		livraison.setLivreur(liv.getLivreur());
		livraison.setStatusLiv(true);
		livraison.setListReclamations(liv.getListReclamations());
		return LivraisonRepo.save(liv);
	}
	
	

	@Override
	public Livraison retrieveLivraison(Long idLivraison) {
		// TODO Auto-generated method stub
		return LivraisonRepo.findById(idLivraison).orElse(null);
	}

	@Override
	public Livraison addLivraison(Livraison liv, Long idFacture, Long idLivreur) {
		// TODO Auto-generated method stub

		facture facture = FactureRepo.findById(idFacture).orElse(null);
		Livreur livreur = LivreurRepo.findById(idLivreur).orElse(null);	
		liv.setFacture(facture);
		liv.setLivreur(livreur);
		liv.setDateLiv(new Date());
		LivraisonRepo.save(liv);
		return liv;
	}
	@Override
	public void removeLivraison(Long idLivraison) {
		// TODO Auto-generated method stub
		LivraisonRepo.deleteById(idLivraison);
		
	}
	
	@Override
	public List<Livraison> FindByIdLivreur(Long idLivreur) {
		return (List<Livraison>) LivraisonRepo.findByIdLivreur(idLivreur);

	}
	@Override
	public List<Livraison> findByDate(Date  DateLiv) {
		return (List<Livraison>) LivraisonRepo.findByDate( DateLiv);
	}
	@Override
	public List<Livraison> orderByDate() {
		return (List<Livraison>)LivraisonRepo.orderByDate();

	}
	
	@Override
	public Livraison deliverLivraison(Long idLivraison) {
		Livraison livraison= LivraisonRepo.findById(idLivraison).get();
		 livraison.setStatusLiv(true);
		 LivraisonRepo.save(livraison);
		return  livraison;
	}
	@Override
	public int CountDelivered() {
         int x= LivraisonRepo.CountDelivered();
         return x;
	}
	@Override
	public int CountUndelivered() {
        int x= LivraisonRepo.CountUndelivered();
		return x;
	}
}
	


