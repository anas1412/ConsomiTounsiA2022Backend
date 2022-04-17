package tn.esprit.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.Entities.Role;
import tn.esprit.Entities.User;

import tn.esprit.Repository.RoleRepository;
import tn.esprit.Repository.UserRepository;



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
		
		u.setUsername(null);
		u.setPassword(null);
		u.setNom(null);
		u.setPrenom(null);
		u.setNum_tel(+216);
		u.setEmail(null);
		u.setEnabled(true);
		u.setRoles(null);
		userRep.save(u);
		return u;
	}

	
	@Override
	public User updateUser(User u) {
		
		User user = userRep.findById(u.getId()).get();
		
		((User) userRep).setUsername(u.getUsername());
		((User) userRep).setPassword(u.getPassword());
		((User) userRep).setNom(u.getNom());
		((User) userRep).setPrenom(u.getPrenom());
		((User) userRep).setNum_tel(u.getNum_tel());
		((User) userRep).setEmail(u.getEmail());
		((User) userRep).setEnabled(u.isEnabled());
		userRep.save(u);
 	    return u ; }
	
	 
	@Override
	public User retrieveUser(Long id) {
		return userRep.findById(id).orElse(null) ;
	}

	@Override
	public void deleteUser(Long id) {
		userRep.deleteById(id);
		
	}

}
