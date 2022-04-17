package tn.esprit.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.Entities.Publicité;
import tn.esprit.Repository.PublicitéRepository;

public class PublicitéService implements IPublicitéService {

	
	
	@Autowired
	PublicitéRepository pubRep ;
	
	
	@Override
	public List<Publicité> retrieveAllPublicité() {
		// TODO Auto-generated method stub
		return (List<Publicité>) pubRep.findAll();
	}

	
	@Override
	public Publicité addPublicité(Publicité p) {
		pubRep.save(p) ;
		return p;
	}

	
	
	@Override
	public void deletePublicité(Long id) {
		pubRep.deleteById(id);

	}


	
	@Override
	public Publicité updatePublicité(Publicité p) {
		Publicité p1 = pubRep.findById(p.getId()).get();
		p1.setNom(p.getNom());
		p1.setCanal(p.getCanal());
		p1.setDateDébut(p.getDateDébut());
		p1.setDateFin(p.getDateFin());
		p1.setNbrInitialCibléDeVue(p.getNbrInitialCibléDeVue());
		p1.setTypePublicité(p.getTypePublicité());
		return pubRep.save(p1);
		
	}

	
	
	@Override
	public Publicité retrievePublicité(Long id) {
		// TODO Auto-generated method stub
		return pubRep.findById(id).orElse(null);	}

}
