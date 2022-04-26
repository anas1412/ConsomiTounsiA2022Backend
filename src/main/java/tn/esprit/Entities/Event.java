package tn.esprit.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Event implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEvent;
	String labelle;
	String description;
	@Temporal(TemporalType.DATE)
	Date dateDebut;
	@Temporal(TemporalType.DATE)
	Date DateFin;
	String lieu ;
	int etat;
	String image;
	
	@JsonIgnore
	@OneToOne
	private Cagnotte cagnotte;
	
/*	@ManyToOne
	private User user;
	*/

}
