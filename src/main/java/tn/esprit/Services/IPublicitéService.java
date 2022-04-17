package tn.esprit.Services;

import java.util.List;

import tn.esprit.Entities.Publicité;


public interface IPublicitéService {
	
	List<Publicité> retrieveAllPublicité();

	Publicité addPublicité (Publicité p);

	void deletePublicité (Long id);

	Publicité updatePublicité (Publicité p);

	Publicité retrievePublicité (Long id);	
}
