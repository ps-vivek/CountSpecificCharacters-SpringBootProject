package com.count.character.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/*
 * 
 * 
 * 
 * Add a logic for reading the inputs from the file
 */
public class CountCharacterBase {

	// This variable cant be used in derived class
	// private Scanner input;

	// This variable can be used in derived class
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());	
	
	protected Scanner input;
	private static final String FILENAME = "F:\\JavaCodesForEclipse\\PracticeRepository\\CountSpecificCharacter\\src\\main\\resources\\Input.txt";
	private static final String FILENAMEOUT = "F:\\JavaCodesForEclipse\\PracticeRepository\\CountSpecificCharacter\\src\\main\\resources\\Output.txt";
	
	private List<List<String>> outerList = new ArrayList<List<String>>();

	public String fetchStringInputs() {
		input = new Scanner(System.in);
		String stringUserInput = input.next();
		return stringUserInput;
	}

	public char fetchCharacterToCount() {
		logger.debug("CountCharacterBase:fetchCharacterToCount");
		input = new Scanner(System.in);

		char storeCharInput = 0;
		try {
			storeCharInput = input.next().charAt(0);
		} catch (Exception e) {
			System.out.println("ex" + e);
		}
		return storeCharInput;
	}

	// write the file reading input logic
	// Make sure that u split the contents of each line in a file based on comma
	// and store it in a string array
	// multiple string arrays should be returned as a list

	public List<List<String>> toFetchInputFromFile() {
		logger.info("CountCharacterBase:toFetchInputFromFile");
		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String sCurrentLine;
			br = new BufferedReader(new FileReader(FILENAME));
			while ((sCurrentLine = br.readLine()) != null) {
				String splitString[] = sCurrentLine.split(",");
				List<String> innerList = new ArrayList<String>();
				for (int i = 0; i < splitString.length; i++) {
					innerList.add(splitString[i].trim().toLowerCase());
				}
				outerList.add(innerList);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}
		return outerList;
	}
	
	//Writing the controller output to a file
	public void writeOutputTOfile(List<HashMap<Integer, List<String>>> outputContent)
	{
		logger.debug("CountCharacterBase:writeOutputTOfile");
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			//String content = "This is the content to write into file\n";
			fw = new FileWriter(FILENAMEOUT);
			bw = new BufferedWriter(fw);
			for(HashMap<Integer, List<String>> outMap : outputContent)
			{
				for (Entry<Integer, List<String>> entry : outMap.entrySet()) {
				    List<String> value = entry.getValue();
				    for(String content : value){
				    bw.write(content);
				    bw.write("\n");
				    }
				}
				
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();
			} 
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
}

