package tn.esprit.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

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
public class Livreur implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLivreur;
	
	private String Nom;
	private String Prenom;
	private int Telephone;
	private String Ville;
	private int NbLivraison;
	private Date DateAjout;
	private String StatutCompte;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="livreur")
	private Set<Livraison> Livraison;
	
}
