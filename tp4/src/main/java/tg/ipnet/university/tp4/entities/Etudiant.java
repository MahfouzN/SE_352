package tg.ipnet.university.tp4.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "etudiants")
//@DiscriminatorValue(value = "ETUDIANT")
@Data
@AllArgsConstructor
public class Etudiant extends Personne{
    
	@Column(name="adresse", nullable=true)
	private String adresse;
	
	@Column(name="telephone")
	private String telephone;
    
	//Ajout de la relation ManyToOne entre Etudiant et Departement
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "departement_id")
    private Departement departement;
    
    //Ajout de la relation ManyToMany entre la Classe Etudiant et Cours
    @ManyToMany(mappedBy = "etudiants", cascade = CascadeType.ALL)
    private Set<Cours> cours;

    public Etudiant() {
    	
    }
    
    public Etudiant(String nom, String prenom, String email, String adresse, String telephone) {
        super(nom, prenom, email);
        this.adresse = adresse;
        this.telephone = telephone;
    }

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Set<Cours> getCours() {
		return cours;
	}

	public void setCours(Set<Cours> cours) {
		this.cours = cours;
	}
     
    
}