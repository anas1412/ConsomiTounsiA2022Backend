package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.Don;

@Repository
public interface DonRepository extends JpaRepository<Don,Long> {

}
