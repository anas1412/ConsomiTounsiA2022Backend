package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.Livraison;

@Repository
public interface LivraisonRepository extends CrudRepository<Livraison, Long>{

}
