package org.deklerativni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Proreda extends Sjeca {
 

	public Proreda() {
		super();
	}

	public Proreda(int bruto, int ogrev, int tehnika) {
		super(bruto, ogrev, tehnika);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "[bruto:" + getBruto() + " ogrev:" + getOgrev() + " tehnika"
				+ getTehnika() + "]";
	}
}
