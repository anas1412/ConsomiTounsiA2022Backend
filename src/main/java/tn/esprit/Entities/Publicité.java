package tn.esprit.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Publicité {

	@Id
	@Column(name="publicite_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long id;
	public String nom;
	public String canal;
	public Date DateDébut;
	public Date DateFin;
	public Integer NbrInitialCibléDeVue;
	public Integer NbrFinalAtteintDeVues;
	public Float CoutPublicité;
	public String TypePublicité;
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCanal() {
		return canal;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}
	public Date getDateDébut() {
		return DateDébut;
	}
	public void setDateDébut(Date dateDébut) {
		DateDébut = dateDébut;
	}
	public Date getDateFin() {
		return DateFin;
	}
	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}
	public Integer getNbrInitialCibléDeVue() {
		return NbrInitialCibléDeVue;
	}
	public void setNbrInitialCibléDeVue(Integer nbrInitialCibléDeVue) {
		NbrInitialCibléDeVue = nbrInitialCibléDeVue;
	}
	public Integer getNbrFinalAtteintDeVues() {
		return NbrFinalAtteintDeVues;
	}
	public void setNbrFinalAtteintDeVues(Integer nbrFinalAtteintDeVues) {
		NbrFinalAtteintDeVues = nbrFinalAtteintDeVues;
	}
	public Float getCoutPublicité() {
		return CoutPublicité;
	}
	public void setCoutPublicité(Float coutPublicité) {
		CoutPublicité = coutPublicité;
	}
	public String getTypePublicité() {
		return TypePublicité;
	}
	public void setTypePublicité(String typePublicité) {
		TypePublicité = typePublicité;
	}

	
	
}
