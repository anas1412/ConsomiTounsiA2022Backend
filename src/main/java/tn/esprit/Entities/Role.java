package tn.esprit.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
public class Role {

		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private Long idRole;
		private String name;
		
		
		
		public Long getId() {
			return idRole;
		}
		public void setId(Long idRole) {
			this.idRole = idRole;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		@ManyToMany (mappedBy="roles", cascade = CascadeType.ALL)
		private Set<User> users;
}
