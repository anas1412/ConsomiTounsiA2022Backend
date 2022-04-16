package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.panierProduit;

@Repository
public interface PanierProduitRepository extends CrudRepository<panierProduit, Long> {

}