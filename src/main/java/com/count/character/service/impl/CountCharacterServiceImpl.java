package com.count.character.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.count.character.dao.CountCharacterDAOImpl;
import com.count.character.model.CountCharacter;
import com.count.character.model.CountInputBean;
import com.count.character.service.CountCharacterService;

/*
 *Reading the input contents from a file
 *Writing the output to a file
 */
@Service
public class CountCharacterServiceImpl extends CountCharacterBase implements CountCharacterService {

	private CountInputBean pojos = null;
	private CountCharacterDAOImpl businessLogic = new CountCharacterDAOImpl();
	private List<String> innerList = null;
	private List<HashMap<Integer, List<String>>> outerList = new ArrayList<HashMap<Integer, List<String>>>();
	private HashMap<Integer, List<String>> innerMap = null;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	

	/**
	 * @return returns count of the number of occurrences of a particular
	 *         character
	 */

	public List<HashMap<Integer, List<String>>> countNumberOfCharacters() {
		pojos = new CountInputBean();
		List<List<String>> inputList = toFetchInputFromFile();
		Integer output = 0;
		int count = 1;
		
		for (List<String> eachElement : inputList) {
			int tempCount = 1;
			innerList = new ArrayList<String>();
			innerMap = new HashMap<Integer, List<String>>();

			for (String eachString : eachElement) {
				if (tempCount == 1) {
					pojos.setS(eachString);
				} else {
					pojos.setCharInput(eachString.charAt(0));
				}
				tempCount++;
			}
			
			output = businessLogic.mainCountLogic(pojos.getS(),
					pojos.getCharInput());
			innerList.add(pojos.getS());
			innerList.add(Character.toString(pojos.getCharInput()));
			
			try {
				innerList.add(Integer.toString(output));
			} catch (NullPointerException e) {
				logger.info("Got a null pointer value for count" + e + 
						" Input:"+pojos.getS()+" ,Char to search:"+pojos.getCharInput());
				innerList.add("0");
				//throw new NullPointerException("Expecting an integer for output. Got null value" + e);
			} 
			innerMap.put(count++, innerList);
			
			outerList.add(innerMap);
		}
		//Writing the output to file
		writeOutputTOfile(outerList);
		return outerList;

	}
	
	/**
	 * 
	 * @return
	 */
	public Integer CountCharacterSingleInput(CountCharacter cntChar){
		return businessLogic.mainCountLogic(cntChar.getStringInput(),
				cntChar.getCharInput());
	}
	
	/**
	 * 
	 * @return
	 */
	public String CountCharacterMultipleInput(){
		return null;
	}

/*	public static void main(String[] args) {
		CountCharacterServiceImpl t8 = new CountCharacterServiceImpl();
		System.out.println(t8.countNumberOfCharactersController());

	}*/
}