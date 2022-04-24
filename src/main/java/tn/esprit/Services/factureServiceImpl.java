package tn.esprit.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entities.User;
import tn.esprit.Entities.facture;
import tn.esprit.Entities.paiement;
import tn.esprit.Entities.panierProduit;
import tn.esprit.Entities.produit;
import tn.esprit.Repository.FactureRepository;
import tn.esprit.Repository.PaiementRepository;
import tn.esprit.Repository.UserRepository;

@Service 
public class factureServiceImpl implements IFactureService{
	
	@Autowired
	FactureRepository FactureRepo;
	
	@Autowired
	UserRepository UserRepo;
	
	@Autowired
	PaiementRepository PaiementRepo;

	@Override
	public List<facture> retrieveAllFacture() {
		// TODO Auto-generated method stub
		return (List<facture>) FactureRepo.findAll();
	}

	@Override
	public facture addFacture(facture f, Long idPaiement) {
		// TODO Auto-generated method stub
		
		paiement p = PaiementRepo.findById(idPaiement).orElse(null);
		f.setPaiement(p);
		
		f.setType(f.getType());
		f.setEtat_livraison(f.getEtat_livraison());
		f.setDate(new Date());
		FactureRepo.save(f);
		return f;
	}

	@Override
	public facture updateFacture(facture f) {
		// TODO Auto-generated method stub
		facture fa = FactureRepo.findById(f.getIdFacture()).get();
		fa.setType(f.getType());
		fa.setEtat_livraison(f.getEtat_livraison());
		return FactureRepo.save(f);
	}

	@Override
	public facture retrieveFacture(Long idFacture) {
		// TODO Auto-generated method stub
		return FactureRepo.findById(idFacture).orElse(null);
	}

	@Override
	public void removeFacture(Long idFacture) {
		// TODO Auto-generated method stub
		FactureRepo.deleteById(idFacture);
	}

	@Override
	public void imprimerFacture(Long idFacture) {
		// TODO Auto-generated method stub
		
	}
	
}
