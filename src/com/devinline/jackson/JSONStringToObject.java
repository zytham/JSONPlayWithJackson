package com.devinline.jackson;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
/**
 * 
 * @author nikhil(www.devinline.com)
 * 
 */
public class JSONStringToObject {

	public static void main(String[] args) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		/*Convert JSON String to JsonNode */
		JsonNode responseJsonNode = objectMapper.readTree(response);
		/*Retrieve payload node from JsonNode */
		JsonNode payloadJsonNode = responseJsonNode.get("payload");
		/*Retrieve Employees list node from payload */
		ArrayNode employeesArray = (ArrayNode) payloadJsonNode.get("employees");
		
		/*Iterate over ArrayNode and retrieve details*/
		for (JsonNode employee : employeesArray) {
			JsonNode personalDetailsNode = employee.get("personalDetails");
			String bloodGroup = personalDetailsNode.get("bloodGroup").asText();
			String firstName = personalDetailsNode.get("firstName").asText();
			System.out.println("Blood group of " + firstName + " is : " + bloodGroup);
		}

	}

	public static final String response = "{\n" + 
			"\"status\": \"SUCCESS\",\n" + 
			"\"payload\": {\n" + 
			"    \"employees\": [\n" + 
			"        {\n" + 
			"            \"employeeId\": \"015823300000500788\",\n" + 
			"            \"department\": \"1524637468898\",\n" + 
			"            \"personalDetails\":{\n" + 
			"                \"firstName\": \"Nikhil\",\n" + 
			"                \"lastName\": \"Ranjan\",\n" + 
			"                \"address\": {\n" + 
			"                    \"addressLineNumber1\": \"House# 206\",\n" + 
			"                    \"addressLineNumber2\": \"SLS APRTMENT\",\n" + 
			"                    \"zip\": 560043,\n" + 
			"                    \"state\": \"Karnataka\",\n" + 
			"                    \"country\": \"INDIA\",\n" + 
			"                    \"landmark\": \"HSR Layout\"\n" + 
			"                },\n" + 
			"                \"bloodGroup\": \"O+\"\n" + 
			"            },\n" + 
			"            \"designation\": \"Senior Engineer\"\n" + 
			"        },\n" + 
			"        {\n" + 
			"            \"employeeId\": \"015823300000500788\",\n" + 
			"            \"department\": \"1524637468898\",\n" + 
			"            \"personalDetails\":{\n" + 
			"                \"firstName\": \"Rahul\",\n" + 
			"                \"lastName\": \"kant\",\n" + 
			"                \"address\": {\n" + 
			"                    \"addressLineNumber1\": \"House# 96\",\n" + 
			"                    \"addressLineNumber2\": \"ARP Road\",\n" + 
			"                    \"zip\": 560086,\n" + 
			"                    \"state\": \"Karnataka\",\n" + 
			"                    \"country\": \"INDIA\",\n" + 
			"                    \"landmark\": \"BTM Layout\"\n" + 
			"                },\n" + 
			"                \"bloodGroup\": \"B+\"\n" + 
			"            },\n" + 
			"            \"designation\": \"Lead Engineer\"\n" + 
			"        }\n" + 
			"    ]\n" + 
			"}\n" + 
			"}";
	}
