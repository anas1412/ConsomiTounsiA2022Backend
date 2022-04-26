package tn.esprit.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.Repository.CagnotteRepository;
import tn.esprit.Entities.Cagnotte;


@Service
@Slf4j
public class CagnotteServiceImp implements ICagnotteService {
	
	
	@Autowired
	CagnotteRepository cagnotteRepository;
	
	@Override
	public List<Cagnotte> retrieveAllCagnottes() {
		List<Cagnotte> cagnottetList = cagnotteRepository.findAll();
		for(Cagnotte cagnotte : cagnottetList) {
			log.info(cagnotte.toString());
		
		}
		return cagnottetList;
	}

	@Override
	public Cagnotte addCagnotte(Cagnotte c) {
	/*	c cagnotte = cagnotteRepository.findById(c.getIdCagnotte()).get(); */
		c.setTotalSomme(c.getTotalSomme());
		c.setEtat(c.getEtat());
		c.setLabelle(c.getLabelle());
		//cagnotte.setEvent(null);
		
		return cagnotteRepository.save(c);
	}

	@Override
	public Cagnotte updateCagnotte(Cagnotte c) {
		
Cagnotte cagnotte = cagnotteRepository.findById(c.getIdCagnotte()).get();
		
cagnotte.setTotalSomme(c.getTotalSomme());
cagnotte.setEtat(c.getEtat());
cagnotte.setLabelle(c.getLabelle());
cagnotte.setEvent(null);
		
		
		cagnotteRepository.save(c);
		return c;
	}

	@Override
	public Cagnotte retrieveCagnotte(Long id) {
		return cagnotteRepository.findById(id).orElse(null);
	}

	@Override
	public void removeCagnotte(Long id) {
		cagnotteRepository.deleteById(id);
		
	}

}
