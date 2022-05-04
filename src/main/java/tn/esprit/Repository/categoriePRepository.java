package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.categorieP;


@Repository
public interface categoriePRepository extends CrudRepository<categorieP, Long> {

}
