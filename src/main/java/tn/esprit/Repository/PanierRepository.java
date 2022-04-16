package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.panier;

@Repository
public interface PanierRepository extends CrudRepository<panier, Long> {

}