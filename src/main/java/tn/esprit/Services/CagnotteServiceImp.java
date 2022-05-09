package tn.esprit.Services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.Repository.CagnotteRepository;
import tn.esprit.Repository.UserRepository;
import tn.esprit.Entities.Cagnotte;
import tn.esprit.Entities.Event;
import tn.esprit.Entities.User;


@Service
@Slf4j
public class CagnotteServiceImp implements ICagnotteService {
	
	
	@Autowired
	CagnotteRepository cagnotteRepository;
	@Autowired
	UserRepository userRepository;
	
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
		
		c.setTotalsomme(c.getTotalsomme());
		c.setEtat(c.getEtat());
		c.setLabelle(c.getLabelle());
		c.setDateCreation(new Date());
		//cagnotte.setEvent(null);
		
		return cagnotteRepository.save(c);
	}

	@Override
	public Cagnotte updateCagnotte(Cagnotte c) {
Cagnotte cagnotte = cagnotteRepository.findById(c.getIdCagnotte()).get();
		
cagnotte.setEtat(c.getEtat());
cagnotte.setLabelle(c.getLabelle());
cagnotte.setTotalsomme(c.getTotalsomme());

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

	@Override
	public Cagnotte updateSomme(Cagnotte c) {
		Cagnotte cagnotte = cagnotteRepository.findById(c.getIdCagnotte()).get();
		cagnotte.setEtat(c.getEtat());
		cagnotte.setLabelle(c.getLabelle());
		cagnotte.setTotalsomme(c.getTotalsomme()+50);
	//	System.out.println(c);

		cagnotteRepository.save(c);
		return c;
	}

	@Override
	public Cagnotte addCagnotteUser(Cagnotte c, Long idUser) {


		User u = userRepository.findById(idUser).orElse(null);
		c.setUser(u);
		c.setTotalsomme(c.getTotalsomme());
		c.setEtat(c.getEtat());
		c.setLabelle(c.getLabelle());
		c.setDateCreation(new Date());
		//cagnotte.setEvent(null);
		
		return cagnotteRepository.save(c);
	}

}
