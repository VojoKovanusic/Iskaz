package org.deklerativni;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Odsjek {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idOdsjek;
	private int brojOdsjeka;
	private int GK;
	private String knigaPremjerdbe;
	private String knjigaDoznake;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "vste_u_odsjeku")
	private Collection<Vrsta> listaVrsta = new ArrayList<>();

	public Odsjek() {
	}

	// za konstruktor koji nema doznaku(knjige)
	public Odsjek(int brojOdsjeka, int gK) {
		this.brojOdsjeka = brojOdsjeka;
		GK = gK;
		this.knigaPremjerdbe = "-";
		this.knjigaDoznake = "-";
	}

	// konstruktor za registraciju odsjeka u kojem ima doznaka i otprema
	public Odsjek(int brojOdsjeka, int gK, String knigaPremjerdbe,
			String knjigaDoznake) {

		this.brojOdsjeka = brojOdsjeka;
		GK = gK;
		this.knigaPremjerdbe = knigaPremjerdbe;
		this.knjigaDoznake = knjigaDoznake;
	}

	 
	public int getGK() {
		return GK;
	}

	public void setGK(int gK) {
		GK = gK;
	}

	public int getBrojOdsjeka() {
		return brojOdsjeka;
	}

	public void setBrojOdsjeka(int brojOdsjeka) {
		this.brojOdsjeka = brojOdsjeka;
	}

	public String getKnigaPremjerdbe() {
		return knigaPremjerdbe;
	}

	public void setKnigaPremjerdbe(String knigaPremjerdbe) {
		this.knigaPremjerdbe = knigaPremjerdbe;
	}

	public String getKnjigaDoznake() {
		return knjigaDoznake;
	}

	public void setKnjigaDoznake(String knjigaDoznake) {
		this.knjigaDoznake = knjigaDoznake;
	}

	@Override
	public String toString() {
		return "[brojOdsjeka=" + brojOdsjeka + ", GK=" + GK
				+ ", knigaPremjerdbe=" + knigaPremjerdbe + ", knjigaDoznake="
				+ knjigaDoznake + "]";
	}

	public Collection<Vrsta> getListaVrsta() {
		return listaVrsta;
	}

	public void setListaVrsta(Collection<Vrsta> listaVrsta) {
		this.listaVrsta = listaVrsta;
	}

}
