package tn.esprit.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import tn.esprit.Entities.Role;
import tn.esprit.Entities.User;

import tn.esprit.Repository.RoleRepository;
import tn.esprit.Repository.UserRepository;

import javax.transaction.Transactional;


@Service
@Transactional
public class UserService implements IUserService {

	
	
	@Autowired
	UserRepository userRep ;
	@Autowired
	RoleRepository roleRep;
	
	
	
	@Override
	public List<User> retrieveAllUsers() {
		return (List<User>) userRep.findAll() ;
		
	}

	
	
	@Override
	public User addUser(User u, Long idRole) {
	
		Role r = roleRep.findById(idRole).orElse(null);
		List<User> users= retrieveAllUsers();

				userRep.save(u);
				System.out.println("rttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt"+r);
				u.getRoles().add(r);

		return u;
	}

	
	@Override
	public User updateUser(User u) {

		userRep.save(u) ;
 	    return u ; }
	
	 
	@Override
	public User retrieveUser(Long id) {
		return userRep.findById(id).orElse(null) ;
	}

	@Override
	public void deleteUser(Long id) {
		userRep.deleteById(id);
		
	}

	@Override
	public List<User> retrieveuserbyname(String name) {
		return userRep.retrieveuserbyname(name);
	}

}
