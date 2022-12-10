package tg.ipnet.university.tp3;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="matchs")
public class Match {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "joueur1_id",nullable=true)
	private Joueur joueur1;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "joueur2_id",nullable=true)
	private Joueur joueur2;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "vainqueur_id",nullable=true)
	private Joueur vainqueur;

	public Match() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}

	public Joueur getVainqueur() {
		return vainqueur;
	}

	public void setVainqueur(Joueur vainqueur) {
		this.vainqueur = vainqueur;
	}
	
}
