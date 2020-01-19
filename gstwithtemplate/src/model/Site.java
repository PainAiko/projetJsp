package model;

public class Site {
	 private String numSite;
	 private String nomSite;
	 private String lieuSite;
	 private double tarifJour;
	 public String getNumSite() {
		return numSite;
	}
	public void setNumSite(String numSite) {
		this.numSite = numSite;
	}
	public String getNomSite() {
		return nomSite;
	}
	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}
	public String getLieuSite() {
		return lieuSite;
	}
	public void setLieuSite(String lieuSite) {
		this.lieuSite = lieuSite;
	}
	public double getTarifJour() {
		return tarifJour;
	}
	public void setTarifJour(double tarifJour) {
		this.tarifJour = tarifJour;
	}
}
