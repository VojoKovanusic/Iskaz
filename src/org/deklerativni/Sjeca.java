package org.deklerativni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

 @Entity
public class Sjeca {
 @Id
 @GeneratedValue
	private int idSjeca;
	private int bruto;
	private int ogrev;
	private int tehnika;
	private int neto;

	public Sjeca() {
		this.bruto = 0;
		this.ogrev = 0;
		this.tehnika = 0;
		this.neto=0;
	}

	public Sjeca(int bruto, int ogrev, int tehnika) {
		this.bruto = bruto;
		this.ogrev = ogrev;
		this.tehnika = tehnika;
		setNeto(this.ogrev + this.tehnika);
	}

	public int getBruto() {
		return bruto;
	}

	public void setBruto(int bruto) {
		this.bruto = bruto;
	}

	public int getOgrev() {
		return ogrev;
	}

	public void setOgrev(int ogrev) {
		this.ogrev = ogrev;
	}

	public double getTehnika() {
		return tehnika;
	}

	public void setTehnika(int tehnika) {
		this.tehnika = tehnika;
	}

	@Override
	public String toString() {
		return "Sjeca [bruto=" + bruto + ", ogrev=" + ogrev + ", tehnika="
				+ tehnika + "]";
	}

	public int getNeto() {
		return neto;
	}

	public void setNeto(int neto) {
		this.neto = neto;
	}

	public void rekapitulacijaSjecePoVrstama_i_sjeci(Sjeca sjeca) {
		this.bruto += sjeca.getBruto();
		this.ogrev += sjeca.getOgrev();
		this.tehnika += sjeca.getTehnika();
		neto = this.tehnika + this.ogrev;

	}

}