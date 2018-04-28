package com.devinline.jackson;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
 * @author nikhil(www.devinline.com)
 * 
 */
public class JSONStringToJavaObject {
	public static final String jsonInput  = "{\n" + 
			"            \"employeeId\": \"015823300000500788\",\n" + 
			"            \"department\": \"1524637468898\",\n" + 
			"            \"personalDetail\":{\n" + 
			"                \"firstName\": \"Nikhil\",\n" + 
			"                \"lastName\": \"Ranjan\",\n" + 
			"                \"address\": {\n" + 
			"                    \"addressLineOne\": \"House# 206\",\n" + 
			"                    \"addressLineTwo\": \"SLS APRTMENT\",\n" + 
			"                    \"zip\": 560043,\n" + 
			"                    \"state\": \"Karnataka\",\n" + 
			"                    \"country\": \"INDIA\",\n" + 
			"                    \"landmark\": \"HSR Layout\"\n" + 
			"                },\n" + 
			"                \"bloodGroup\": \"O+\"\n" + 
			"            },\n" + 
			"            \"designation\": \"Senior Engineer\"\n" + 
			"        }";
	
		public static void main(String[] args) {
			ObjectMapper objectMapper = new ObjectMapper();
			/*
			 * DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES added to deal with JSONs
			 * with unknown properties
			 */
			objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			/*
			 * To suppress serializing properties with null values 
			 * */
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			try {
				/*Converting JSON String to Employee Object*/
				Employee employee = objectMapper.readValue(jsonInput, Employee.class);
				System.out.println("*****Accessing Employee Object *****");
				System.out.println("Blood group of "+ employee.getPersonalDetail().getFirstName()+ " is "
						+employee.getPersonalDetail().getBloodGroup());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
