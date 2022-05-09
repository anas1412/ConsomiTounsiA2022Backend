package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.Badwords;


@Repository
public interface BadwordsRepository extends JpaRepository<Badwords, Long>{

	Badwords findByWord(String word);
}
