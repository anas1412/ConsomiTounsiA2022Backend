package tn.esprit.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
public class panier implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long idPanier;
	
	private List<panierProduit> panierproduits;
	
	private int nbrArticle;
	
	private Date date;
	
	private float somme_total;
	
	@OneToOne
	private User user;	
	
	@OneToOne
	private paiement paiement;
	

}