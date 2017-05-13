package com.count.character.model;
/*
 * Add constructor(default, 2 parameter)
 * 
 * Add toString() method
 * 
 * Add equals() & hashcode() method
 */
public class CountInputBean {

	private String stringInput;
	private char charInput;

	public CountInputBean() {
	}

	CountInputBean(String stringInput, char charInput) {
		super();
		this.stringInput = stringInput;
		this.charInput = charInput;
	}

	public char getCharInput() {
		return charInput;
	}

	public void setCharInput(char charInput) {
		this.charInput = charInput;
	}

	public String getS() {
		return stringInput;
	}

	public void setS(String s) {
		this.stringInput = s;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + charInput;
		result = prime * result
				+ ((stringInput == null) ? 0 : stringInput.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountInputBean other = (CountInputBean) obj;
		if (charInput != other.charInput)
			return false;
		if (stringInput == null) {
			if (other.stringInput != null)
				return false;
		} else if (!stringInput.equals(other.stringInput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CountInput [stringInput=" + stringInput + ", charInput="
				+ charInput + "]";
	}



}
