package tn.esprit.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import tn.esprit.Entities.Don;
import tn.esprit.Repository.DonRepository;


@Service
@Slf4j
public class DonServiceImp implements IDonService {
	
	@Autowired
	DonRepository donRepository;
	
	@Override
	public List<Don> retrieveAllDons() {
		List<Don> donList = donRepository.findAll();
		for(Don don : donList) {
			log.info(don.toString());
		
		}
		return donList;
	}

	@Override
	public Don addDon(Don d) {
		return donRepository.save(d);
	}

	@Override
	public Don updateDon(Don d) {
		Don don = donRepository.findById(d.getIdDon()).get();
		don.setDateCreation(d.getDateCreation());
		don.setEtat(d.getEtat());
		don.setName(d.getName());
		don.setNbProduit(d.getNbProduit());
		don.setP(d.getP());
		return donRepository.save(d);
	}

	@Override
	public Don retrieveDon(Long id) {
		return donRepository.findById(id).orElse(null);
	}

	@Override
	public void removeDon(Long id) {
		donRepository.deleteById(id);
		
	}

	@Override
	public Don addDonUser(Don d, Long idUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
