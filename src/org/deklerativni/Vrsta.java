package org.deklerativni;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Vrsta {
	@Id
	@GeneratedValue
	private int vrstaId;
	private int nazivVrste;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doznakaID")
	private Doznaka doznaka;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "redovnaID")
	private Redovna redovna;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "uziciID")
	private Uzici uzici;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "njegaID")
	private Njega njega;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "proredaID")
	private Proreda proreda;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vanrednaID")
	private Vanredne_i_stete vanredne;

	private int sumaBruto;
	private int sumaNeto;
	private int neposjecenoBruto;
	private String primjedba;

	public Vrsta(int ime) {
		this.nazivVrste = ime;
	}

	public Vrsta() {
	 
	}

	public int getNazivVrste() {
		return nazivVrste;
	}

	public void setNazivVrste(int nazivVrste) {
		this.nazivVrste = nazivVrste;
	}

	public Doznaka getDoznaka() {
		return doznaka;
	}

	public void setDoznaka(Doznaka doznaka) {
		this.doznaka = doznaka;
	}

	public Njega getNjega() {
		return njega;
	}

	public void setNjega(Sjeca sjeca2) {
		this.njega = (Njega) sjeca2;
	}

	public Uzici getUzici() {
		return uzici;
	}

	public void setUzici(Sjeca sjeca2) {
		this.uzici = (Uzici) sjeca2;
	}

	public Proreda getProreda() {
		return proreda;
	}

	public void setProreda(Sjeca proreda) {
		this.proreda = (Proreda) proreda;
	}

	public Redovna getRedovna() {
		return redovna;
	}

	public void setRedovna(Sjeca redovna) {
		this.redovna = (Redovna) redovna;
	}

	public Vanredne_i_stete getVanredne() {
		return vanredne;
	}

	public void setVanredne(Sjeca vanredne) {
		this.vanredne = (Vanredne_i_stete) vanredne;
	}

	public int getSumaBruto() {
		return sumaBruto;
	}

	public void setSumaBruto(int sumaBruto) {
		this.sumaBruto = sumaBruto;
	}

	public int getSumaNeto() {
		return sumaNeto;
	}

	public void setSumaNeto(int sumaNeto) {
		this.sumaNeto = sumaNeto;
	}

	public int getNeposjecenoBruto() {
		return neposjecenoBruto;
	}

	public void setNeposjecenoBruto(int prelaz) {
		if (prelaz < 0) {
			this.neposjecenoBruto = 0;
			setPrimjedba(" manjak " + prelaz);
		} else {
			this.neposjecenoBruto = prelaz;
			setPrimjedba(" prelaz: " + prelaz);
		}
	}

	public String getPrimjedba() {
		return primjedba;
	}

	private void setPrimjedba(String primjedba) {
		this.primjedba = primjedba;
	}

	@Override
	public String toString() {

		return "\nVRSTA [" + nazivVrste + "] DOZNAKA=" + doznaka
				+ ", SJECA->[ REDOVNA=" + redovna + " Sl.UŽICI=" + uzici
				+ " PROREDA=" + proreda + "VANREDNE=" + vanredne + "NjEGA="
				+ njega + " ], SUMA BRUTO=" + sumaBruto + ", SUMA" + " NETO="
				+ sumaNeto + ", NEPOSJECENO BRUTO=" + neposjecenoBruto
				+ ",Primjedba:" + primjedba + "";
	}

}
