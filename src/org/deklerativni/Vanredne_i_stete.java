package org.deklerativni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vanredne_i_stete extends Sjeca {
 
 

	public Vanredne_i_stete() {
		super();
	}

	public Vanredne_i_stete(int bruto, int ogrev, int tehnika) {
		super(bruto, ogrev, tehnika);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "[bruto:" + getBruto() + " ogrev:" + getOgrev() + " tehnika"
				+ getTehnika() + "]";
	}
}
