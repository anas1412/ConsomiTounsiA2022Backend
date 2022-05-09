package tn.esprit.Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publication implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idPublication;
	@NonNull
	//@Size(min = 1, max = 50)
	private String title;
	@NonNull
//	@Size(min = 1, max = 50, message = "{post's content cannot be empty}")
	private String content;
	//@NonNull
	//@Temporal(TemporalType.DATE)
	private LocalDate createdAt;
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDate updatedAt;
	//private String image;
	 
	
	@ManyToOne
	
	private User user;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="publication")
	private Set<Reaction> reaction;
	
	
	

}
