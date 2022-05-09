package tn.esprit.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.stock;

@Repository
public interface stockRepository extends CrudRepository<stock, Long> {
	
	@Query("SELECT s FROM stock s where s.quantite< s.quantiteMin")
	List<stock> status();

	@Query("SELECT s FROM stock s WHERE CONCAT(s.libelleStock, ' ', s.supplier_name) LIKE %?1%")
	public List<stock> search(String keyword);
	
	

}
