package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.stock;

@Repository
public interface stockRepository extends CrudRepository<stock, Long> {

}
