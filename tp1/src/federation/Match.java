package federation;
import java.io.*;  
import java.util.*;  

public class Match {
	private Joueur joueur1;
	private Joueur joueur2;
	private Joueur vainqueur;
	public Match(Joueur j1, Joueur j2) {
		super();
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}
	public Joueur getJoueur1() {
		return joueur1;
	}
	public Joueur getJoueur2() {
		return joueur2;
	}
	public void setVainqueur() {
		if(joueur1.compareTo(joueur2)==1) {
			System.out.println("le vainqueur est"+joueur1.toString());
			vainqueur=joueur1;}
			else {
				vainqueur=joueur2;
			}
	}
	public Joueur getVainqueur() {
		if(joueur1.compareTo(joueur2)==1) {
			System.out.println("le vainqueur est"+joueur1.toString());
			vainqueur=joueur1;}
		else {
				vainqueur=joueur2;
			}
		return vainqueur;
		
	}
	public void getVaincu() {
		if(joueur1.compareTo(joueur2)==1) {
			System.out.println("le vaincu est"+joueur2.toString());}
			
		else if(joueur1.compareTo(joueur2)==0) {
				System.out.println("le vaincu est"+joueur1.toString());
				
	   
	
	}
		
	}
}
	


