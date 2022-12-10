package federation;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;
@Entity
public class Joueur implements Comparable<Joueur>{
	private String nom,prenom,numero_licence;
	@Id  
	private int id;
	private double nbre_point=0;

	public Joueur(int id,String nom, String prenom, String numero_licence) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numero_licence = genererNumeroLicence();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ", prenom=" + prenom + ", numero_licence=" + numero_licence + "]";
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

	public String getNumero_licence() {
		return numero_licence;
	}

	public void setNumero_licence(String numero_licence) {
		this.numero_licence = numero_licence;
	}
	public String genererNumeroLicence() {
		return this.nom + new Date();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		return Double.doubleToLongBits(nbre_point) == Double.doubleToLongBits(other.nbre_point)
				&& Objects.equals(nom, other.nom) && Objects.equals(numero_licence, other.numero_licence)
				&& Objects.equals(prenom, other.prenom);
	}
	
	public void ajouter_point(double nouveau_nombre) {
		this.nbre_point+=nouveau_nombre;
	}
	public int compareTo(Joueur j) {
		if(equals(j)==true) {
			System.out.println(" les joueurs sont egos");
			return -1;
			
		}
		else if (nbre_point>j.nbre_point) {
			System.out.println("le joueur:"+j.toString()+"est mieux classé par rapport à"+this.toString());
			return 1;
			
		}else 
		System.out.println("le joueur:"+this.toString()+"est mieux classé par rapport à"+j.toString());
		return 0;
	 
		
	}

	
	
}
