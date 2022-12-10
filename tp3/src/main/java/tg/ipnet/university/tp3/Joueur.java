package tg.ipnet.university.tp3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="joueurs")
public class Joueur{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "numero_licence")
	private String numeroLicence;
	
	@Column(name = "nom", nullable = false, length = 60)
	private String nom;
	
	@Column(name = "prenom", nullable = false, length = 80)
	private String prenom;
	
	@Column(name = "points", nullable = false)
	private Integer points;

	//@OneToMany(mappedBy = "joueur1", fetch = FetchType.LAZY)
	//private Set<Match> matchs;
	
	public Joueur() {
		// TODO Auto-generated constructor stub
	}
	
	public Joueur(String nom, String prenom, String numeroLicence, int points) {
		this.nom = nom;
		this.prenom = prenom;
		this.numeroLicence = numeroLicence;
		this.points = points;
	}
	
	public Joueur(String nom, String prenom, int points) {
		this.nom = nom;
		this.prenom = prenom;
		this.numeroLicence = this.generateNumeroLicence();
		this.points = points;
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

	public String getNumeroLicence() {
		return numeroLicence;
	}

	public void setNumeroLicence(String numeroLicence) {
		this.numeroLicence = this.getNumeroLicence();
	}

	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String generateNumeroLicence() {
		return this.getNom() + (int) (Math.random()*(100-0)) + 0;
	}
	
	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ", prenom=" + prenom + ", numeroLicence=" + numeroLicence + ", nombrePoints="
				+ points + "]";
	}
	
}

