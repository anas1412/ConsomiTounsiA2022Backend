package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.Cagnotte;

@Repository
public interface CagnotteRepository extends JpaRepository<Cagnotte,Long> {

}
