package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.facture;

@Repository
public interface FactureRepository extends CrudRepository<facture, Long> {

}
