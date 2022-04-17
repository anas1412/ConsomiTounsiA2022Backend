package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

	
	


	}
