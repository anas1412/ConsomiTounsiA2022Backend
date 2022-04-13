package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.Livreur;

@Repository
public interface LivreurRepository extends CrudRepository<Livreur, Long>{

}
