package tn.esprit.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.Livraison;

@Repository
public interface LivraisonRepository extends CrudRepository<Livraison, Long>{
	
	@Query("SELECT LivraisonRepo FROM Livraison LivraisonRepo WHERE LivraisonRepo.idLivraison = ?1 ")
	List<Livraison> findByIdLivreur(Long idLivreur);
	
	@Query("SELECT LivraisonRepo FROM Livraison LivraisonRepo Order By LivraisonRepo.dateLiv ASC ")
	List<Livraison> orderByDate();
	
	@Query("SELECT COUNT(LivraisonRepo) FROM Livraison LivraisonRepo WHERE LivraisonRepo.statusLiv = true ")
	int CountDelivered();
	
	@Query("SELECT COUNT(LivraisonRepo) FROM Livraison LivraisonRepo WHERE LivraisonRepo.statusLiv =false ")
	int CountUndelivered();
	
	@Query("SELECT LivraisonRepo FROM Livraison LivraisonRepo WHERE LivraisonRepo.dateLiv = ?1 ")
	List<Livraison> findByDate(Date dateLiv);

}
