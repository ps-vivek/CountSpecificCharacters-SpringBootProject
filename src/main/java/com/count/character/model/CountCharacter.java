package com.count.character.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CountCharacter {
	
	@Id
	public String id;
	
	private String stringInput;
	private char charInput;
	

	public String getStringInput() {
		return stringInput;
	}
	public void setStringInput(String stringInput) {
		this.stringInput = stringInput;
	}
	
	public char getCharInput() {
		return charInput;
	}
	public void setCharInput(char charInput) {
		this.charInput = charInput;
	}
	
	@Override
	public String toString() {
		return "CountCharacter [id=" + id + ", stringInput=" + stringInput + ", charInput=" + charInput + "]";
	}

}
