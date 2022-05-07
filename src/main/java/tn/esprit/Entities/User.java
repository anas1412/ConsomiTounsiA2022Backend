package tn.esprit.Entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String nom;
	private String prenom;
	private Integer num_tel;
	private String email;
	private boolean enabled;
	
	@ManyToMany (cascade = CascadeType.ALL)
	private Set<Role> roles;
	
	/* @ManyToMany(mappedBy="users",cascade = CascadeType.ALL)
	private Set<Cagnotte> cagnottes;*/
	/*
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private Set <Event> events;
	*/
}
