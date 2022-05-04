package tn.esprit.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

public class Livraison implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLivraison;
	private Date DateLiv;
	private String Adresse;
	private float Frais;
	
	@JsonIgnore
	@OneToOne
	private facture facture;
	@JsonIgnore
	@ManyToOne
	private Livreur livreur;
	
	
@OneToMany(cascade = CascadeType.ALL , mappedBy="livraison")
	private Set<Reclamation>ListReclamations;	

}
