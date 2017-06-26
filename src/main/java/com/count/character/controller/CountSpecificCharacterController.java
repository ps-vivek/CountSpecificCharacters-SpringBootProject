package com.count.character.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.count.character.service.impl.CountCharacterServiceImpl;


@RestController
@RequestMapping("/CntChar/")

public class CountSpecificCharacterController {
	//execute everything
	
	//call the service impl from here
	public static final Logger logger = LoggerFactory.getLogger(CountSpecificCharacterController.class);
	
	@Autowired
    private CountCharacterServiceImpl cntChar; 

	//Retrieve all the words from an input text file
	@RequestMapping(value = "/textFile/", method = RequestMethod.GET)
	public List<HashMap<Integer, List<String>>> countSpecificCharacters(){
		logger.info("Inside CountSpecificCharacterController.countSpecificCharacters()");
		return cntChar.countNumberOfCharacters();
	}
	
}
