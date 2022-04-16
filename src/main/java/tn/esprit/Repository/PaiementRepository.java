package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.paiement;

@Repository
public interface PaiementRepository extends CrudRepository<paiement, Long> {

}