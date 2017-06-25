package com.count.character.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.count.character.model.CountCharacter;
import com.count.character.repository.CountRepository;
import com.count.character.service.impl.CountCharacterServiceImpl;


@RestController
@RequestMapping("/CntChar/")

public class CountSpecificCharacterController {
	//execute everything
	
	//call the service impl from here
	public static final Logger logger = LoggerFactory.getLogger(CountSpecificCharacterController.class);
	
	@Autowired
	private CountRepository countRepo;
	
	@Autowired
    private CountCharacterServiceImpl cntChar; 

	//Retrieve all the words from an input text file
	@RequestMapping(value = "/textFile/", method = RequestMethod.GET)
	public List<HashMap<Integer, List<String>>> countSpecificCharacters(){
		logger.info("Inside controller class");
		return cntChar.countNumberOfCharacters();
	}
	
	//Single character Input is provided from the REST URI
	@RequestMapping(value = "/single/", method = RequestMethod.POST)
	public String countCharSingleInput(@RequestBody CountCharacter countChar){
		logger.info("<<<<<<Inside here:>>>>>>>"+countChar);
		countRepo.save(countChar);
		logger.info("Inserted One entry into db");
		//CountCharacter cntBean = countRepo.findOne(countChar.getStringInput());
		//return "Number of Characters: " + cntChar.CountCharacterSingleInput(cntBean);
		return "Feature fully not implemented. Try Later";
	}
	
	//Multiple character Input is provided from the REST URI
	@RequestMapping(value = "/multiple/", method = RequestMethod.POST)
	public String countCharMultipleInput(){
		return cntChar.CountCharacterMultipleInput();		
	}
}
