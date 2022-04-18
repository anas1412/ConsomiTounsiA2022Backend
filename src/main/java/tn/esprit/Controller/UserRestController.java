package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.Entities.User;
import tn.esprit.Services.IUserService;
import tn.esprit.Services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("user")
public class UserRestController {
	
	@Autowired
	IUserService iuserservice ;
	
	//http://localhost:8085/SpringMVC/user/add-user
		@PostMapping("/add-user/{roleid}")
		@ResponseBody
		public User addUser(@RequestBody User u, @PathVariable("roleid") Long idRole)
		{	
	
		    return iuserservice.addUser(u, idRole);
		   
		}
		//http://localhost:8085/SpringMVC/user/retrieveAllUsers
		@GetMapping ("/retrieveAllUsers")
		public List<User> retrieveAllUsers() {
			List<User> listeuser = iuserservice.retrieveAllUsers();
			return listeuser;
		}
	//http://localhost:8085/SpringMVC/user/updateuser
			@PutMapping("/updateuser")
			public User updateUser(@RequestBody User u) {
				return iuserservice.updateUser(u);
			}


	//http://localhost:8085/SpringMVC/user/retrieveuser
			@GetMapping("/retrieveuser/{id}")
	public User retrieveUser(@PathVariable("id") Long id){

				return iuserservice.retrieveUser(id);
			}

	//http://localhost:8085/SpringMVC/user/delete
			@DeleteMapping("delete/{id}")
			public void deleteUser(@PathVariable("id") Long id) {
			 iuserservice.deleteUser(id); ;


			}



			//http://localhost:8085/SpringMVC/user/retrieveuserbyname
			@GetMapping("/retrieveuserbyname/{name}")
			public List<User> retrieveuserbyname(@PathVariable("name") String name){
			return iuserservice.retrieveuserbyname(name);
			}




		}

