package com.count.character.dao;
/*
 *
 * Instead of reading the value from user directly.
 * Read the value from a text file
 * Write the output to the table
 *
 */
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.count.character.dao.impl.CountCharacterDAO;

public class CountCharacterDAOImpl implements CountCharacterDAO{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());	

	@Override
	public Integer mainCountLogic(String userInput, char userCharcToSearch) {
		logger.debug("Inside CountCharacterDAOImpl:mainCountLogic");
		userInput = userInput.toLowerCase();
		HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

		for (int i = 0; i < userInput.length(); i++) {
			if (hashmap.containsKey(userInput.charAt(i))) {
				hashmap.put(userInput.charAt(i), hashmap.get(userInput.charAt(i)) +1 ) ;
			} else {
				hashmap.put(userInput.charAt(i), 1);
			}
		}
		
		return (hashmap.get(userCharcToSearch));
	}
}
