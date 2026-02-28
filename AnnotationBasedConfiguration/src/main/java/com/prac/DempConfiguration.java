package com.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages ="com")
public class DempConfiguration {
	
	@Bean
	public Scanner getScanner()
	{
		return new Scanner(System.in);
	}
	@Bean
	public ArrayList<String> items()
	{
		ArrayList<String> list = new ArrayList<>();
		list.add("Harsh");
		list.add("Aman");
		return list;
	}
	@Bean
	public HashMap<Integer, Integer> getMapped()
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1,5);
		map.put(4, 12);
		
		return map;
	}

}
