package tn.esprit.Entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.List;
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
	private Long idLivreur;
	
	private String nom;
	private String prenom;
	private String telephone;
	private String ville;
	private int nbLivraison;
	private Date dateAjout;
	private boolean statutCompte;
	private String adresseEmail;
	private String mdp;
	private String imgURL;
	private String message;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="livreur")
	private List <Livraison> ListLivraisons;

	@Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNumber= ..." + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
	
}
