package tn.esprit.Services;

import java.util.List;

import tn.esprit.Entities.categorieP;

public interface ICategorieServices {

	List<categorieP> retrieveAllCategorieProduits();

	categorieP addCategorieProduit(categorieP cp);

	categorieP updateCategorieProduit(categorieP cp);

	categorieP retrieveCategorieProduit(Long id);

	void removeCategorieProduit(Long id);
	
}

