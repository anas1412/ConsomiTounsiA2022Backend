package tn.esprit.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entities.facture;
import tn.esprit.Entities.produit;
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

/*	@Override
	public Livraison updateLivraison(Livraison liv, Long idFacture, Long idLivreur) {
		// TODO Auto-generated method stub
		return LivraisonRepo.save(liv);
	}*/
	
	@Override
	public Livraison updateLivraison(Livraison liv) {
		Livraison livraison = LivraisonRepo.findById(liv.getIdLivraison()).get();
		
		livraison.setLivreur(liv.getLivreur());
		livraison.setIdLivraison(liv.getIdLivraison());
		livraison.setAdresse(liv.getAdresse());
		livraison.setDateLiv(liv.getDateLiv());
		livraison.setFacture(liv.getFacture());
		livraison.setFrais(liv.getFrais());
		LivraisonRepo.save(liv);
		return liv;
				
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

	
	}

