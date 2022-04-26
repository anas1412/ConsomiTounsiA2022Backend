package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.produit;

@Repository
public interface produitRepository extends CrudRepository<produit, Long> {

}