package tn.esprit.Services;

import java.util.List;

import tn.esprit.Entities.Don;

public interface IDonService {
	List<Don> retrieveAllDons();

	Don addDon(Don d);
	Don addDonUser(Don d, Long idUser);

	Don updateDon(Don d);

	Don retrieveDon(Long id);

	void removeDon(Long id);

}
