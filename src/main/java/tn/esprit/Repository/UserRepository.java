package tn.esprit.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.User;

import java.util.List;


@Repository
public interface UserRepository  extends CrudRepository<User, Long>{
    @Query ("SELECT u from User u WHERE u.username=:name")
    List<User> retrieveuserbyname (@Param("name") String name);

}
