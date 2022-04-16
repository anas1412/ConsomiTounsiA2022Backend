package tn.esprit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.categorieP;


@Repository
public interface categoriePRepository extends CrudRepository<categorieP, Long> {

	@Query("SELECT c FROM categorieP c WHERE CONCAT(c.codeProduit, ' ', s.libelleCategorieProduit) LIKE %?1%")
	public List<categorieP> search(String keyword);
	
}
