package com.count.character.controller;


import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.count.character.model.CountCharacter;
import com.count.character.repository.CountRepository;
import com.count.character.repository.CountRepositoryImpl;


@RestController
@RequestMapping("/CntCharService/json")

public class CountSpecificCharacterJsonController {

	public static final Logger logger = LoggerFactory.getLogger(CountSpecificCharacterJsonController.class);
	
	@Autowired
	private CountRepository countRepo;
	
	@Autowired
	private CountRepositoryImpl countRepoImpl;
		
	//When the input is provided in the JSON format
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/addInput/", method = RequestMethod.POST)
	public JSONObject addInput(@RequestBody CountCharacter[] countChar){

		logger.info("CountSpecificCharacterJsonController.addInput():"+countChar.toString());
		JSONObject obj = new JSONObject();
		try{
			int count = 0;
			for(CountCharacter ch : countChar){
				logger.info("Input String:" +ch.getStringInput() + " Input Character: " + ch.getCharInput());
				countRepo.save(ch);
				count++;
			}
			obj.put("STATUS","SUCCESS");
			obj.put("DESCRIPTION",count + " records inserted into db");
			return obj;
		}
		catch(Exception e){
			
			try {
				obj.put("STATUS","FAILURE");
				obj.put("DESCRIPTION","Error while inserting records into db");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return obj;
		}
	}
	

	//When the input is provided in the JSON format, it updates if the given input exists already
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/updateInput/", method = RequestMethod.POST)
	public JSONObject updateInput(@RequestBody CountCharacter[] countChar){

		logger.info("CountSpecificCharacterJsonController.updateInput():"+countChar.toString());
		JSONObject obj = new JSONObject();
		try{
			int count = 0;
			for(CountCharacter ch : countChar){
				logger.info("ID: "+ch.getId()+" Input String:" +ch.getStringInput() + " Input Character: " + ch.getCharInput());
				countRepoImpl.updateString(ch.getStringInput(), ch.getId() ,ch.getCharInput());
				count++;
			}
			obj.put("STATUS","SUCCESS");
			obj.put("DESCRIPTION",count + " records updated into db");
			return obj;
		}
		catch(Exception e){
			
			try {
				obj.put("STATUS","FAILURE");
				obj.put("DESCRIPTION","Error while updating records into db");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return obj;
		}
	}

	
}
