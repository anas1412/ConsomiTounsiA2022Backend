package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.Reclamation;


@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation, Long> {

}
