package org.deklerativni;

public class Prelaz {

	private String nazivVrste;
	private String godina;
	private int bruto;

	public Prelaz(String vrsta) {
		nazivVrste = vrsta;
	}

	public String getNazivVrste() {
		return nazivVrste;
	}

	public void setNazivVrste(String nazivVrste) {
		this.nazivVrste = nazivVrste;
	}

	public String getProslaGodina() {
		return godina;
	}

	public void setProslaGodina(String proslaGodina) {
		this.godina = proslaGodina;
	}

	public int getBruto() {
		return bruto;
	}

	public void setBruto(int bruto) {
		this.bruto += bruto;
	}

}
