package com.prac;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mobile {
	
	@Value("809037077")
	private String number;

}
