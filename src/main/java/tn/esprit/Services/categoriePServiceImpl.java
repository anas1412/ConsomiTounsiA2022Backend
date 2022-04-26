package tn.esprit.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entities.categorieP;

import tn.esprit.Repository.categoriePRepository;


@Service
public class categoriePServiceImpl implements ICategorieServices {

	
	@Autowired
	categoriePRepository CategorieRepo;
	@Override
	public List<categorieP> retrieveAllCategorieProduits() {
		// TODO Auto-generated method stub
		return (List<categorieP>) CategorieRepo.findAll();
	}

	@Override
	public categorieP addCategorieProduit(categorieP cp) {
		// TODO Auto-generated method stub
		CategorieRepo.save(cp);
		return cp;
	}

	@Override
	public categorieP updateCategorieProduit(categorieP cp) {
		categorieP categorie = CategorieRepo.findById(cp.getIdCategorieP()).get();
		categorie.setCodeProduit(cp.getCodeProduit());
		categorie.setLibelleCategorieProduit(cp.getLibelleCategorieProduit());
		
		CategorieRepo.save(cp);
		return cp;
	}

	@Override
	public categorieP retrieveCategorieProduit(Long id) {
		// TODO Auto-generated method stub
		return CategorieRepo.findById(id).orElse(null);
	}

	@Override
	public void removeCategorieProduit(Long id) {
		// TODO Auto-generated method stub
		CategorieRepo.deleteById(id);
	}
	

}
