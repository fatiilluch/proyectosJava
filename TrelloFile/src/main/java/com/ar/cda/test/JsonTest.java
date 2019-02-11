package com.ar.cda.test;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class JsonTest {

	private static final String filePath = "C:\\Users\\L0649805\\workspace2\\jsonTestFile.json";

	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader(filePath);
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(reader);

			String name = (String) jsonObject.get("firstname");
			System.out.println(name);
			
			JSONObject nuevoObjeto = new JSONObject();
			
			nuevoObjeto.put("Nombre", "ElDeTuViejaGil");
			
			JSONArray edades = new JSONArray();
			edades.add("15");
			edades.add("12");
			edades.add("66");
			nuevoObjeto.put("Edades", edades);
			
			
			FileWriter writer = new FileWriter("C:\\Users\\L0649805\\workspace2\\jsonPrueba.json");
			writer.write(nuevoObjeto.toJSONString());
			writer.flush();
			writer.close();

		} catch (FileNotFoundException e) {

		} catch (IOException a) {
		
		} catch (ParseException a) {

		} catch (NullPointerException a) {
			
		}
	}
}
