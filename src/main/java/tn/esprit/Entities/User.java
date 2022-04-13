package tn.esprit.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table( name = "users")
public class User {
	
	
	@Id
	@Column (name = "user_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String nom;
	private String prenom;
	private Integer num_tel;
	private String email;
	private boolean enabled;
	
	
	

	@ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name ="users_roles", joinColumns = @JoinColumn (name="user_id"), inverseJoinColumns = @JoinColumn (name="role_id"))	
	private Set<Role> roles=new HashSet<>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Integer getNum_tel() {
		return num_tel;
	}


	public void setNum_tel(Integer num_tel) {
		this.num_tel = num_tel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	
	

	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
	
	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	
	
	
}
