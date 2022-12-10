package tg.ipnet.university.tp4.entities;

import javax.persistence.Column;
//import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
@MappedSuperclass
@Data
@AllArgsConstructor
//@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "type")
public class Personne extends BaseEntity{ 
    
	@Column(name="nom", length=60, nullable=false)
	protected String nom;

	@Column(name="prenom", length=60, nullable=false)
	protected String prenom;
	
	@Column(name="email", length=60)
	protected String email;

    public Personne(String nom, String prenom, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public Personne() 
    {
    	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
      
}
