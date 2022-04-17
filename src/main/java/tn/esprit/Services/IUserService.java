package tn.esprit.Services;

import java.util.List;

import tn.esprit.Entities.User;


public interface IUserService {

	
	List<User> retrieveAllUsers();

	User addUser (User u, Long idRole);

	User updateUser (User u);
	
	User retrieveUser(Long id);
	
	void deleteUser (Long id);
	
	
	
}
