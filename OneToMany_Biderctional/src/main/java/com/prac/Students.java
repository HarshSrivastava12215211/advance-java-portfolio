package com.prac;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

public class Students {
	
	private int id;
	private String name;
	@ManyToOne(cascade = CascadeType.ALL)
	private College college;
	

}
