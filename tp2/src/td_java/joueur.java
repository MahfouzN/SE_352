package td_java;

public class joueur {
	private String nom,prenom,num_licence;
	private double nbre_pts=0;
	public joueur(String nom,String prenom,String num_licence) {
		this.nom=nom;
		this.prenom=prenom;
		this.num_licence=num_licence;
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
	public String getNum_licence() {
		return num_licence;
	}
	public void setNum_licence(String num_licence) {
		this.num_licence = num_licence;
	}
	public void ajt_point(double nv_point) {
		nbre_pts+=nv_point;
	}
	@Override
	public String toString() {
		return "joueur [nom=" + nom + ", prenom=" + prenom + ", num_licence=" + num_licence + ", nbre_pts=" + nbre_pts
				+ "]";
	}

}
