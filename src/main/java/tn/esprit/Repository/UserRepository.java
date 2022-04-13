package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.User;


@Repository
public interface UserRepository  extends CrudRepository<User, Long>{

}
