package tn.esprit.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.Livraison;
import tn.esprit.Entities.Reclamation;


@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation, Long> {


	

}
