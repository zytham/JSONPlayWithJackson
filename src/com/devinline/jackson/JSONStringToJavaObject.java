package com.devinline.jackson;

import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
/**
 * 
 * @author nikhil(www.devinline.com)
 * 
 */
public class JSONStringToJavaObject {
	public static final String jsonInput  = "{\n" + 
			"            \"employeeId\": \"ORA098\",\n" + 
			"            \"department\": \"PSR-CP\",\n" + 
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
			"            \"designation\": \"Senior Engineer\"\n" + "        }";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter your choice: ");
		System.out.println("\n1. JSON String to Java Object : ");
		System.out.println("\n2. JAVA Object to JSON String : ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			convertJsonToJavaObject();
			break;
		case 2:
			convertJavaObjectToJSONString();
		default:
			break;
		}
		sc.close();
	}

	private static void convertJsonToJavaObject() {
		ObjectMapper objectMapper = new ObjectMapper();
		/*
		 * DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES added to deal with JSONs
		 * with unknown properties
		 */
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		try {
			/* Converting JSON String to Employee Object */
			Employee employee = objectMapper.readValue(jsonInput, Employee.class);
			System.out.println("***** Accessing Employee Object *****");
			System.out.println("Blood group of " + employee.getPersonalDetail().getFirstName() + " is "
					+ employee.getPersonalDetail().getBloodGroup());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void convertJavaObjectToJSONString() {
		ObjectMapper objectMapper = new ObjectMapper();
		/*
		 * To suppress serializing properties with null values
		 */
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		Employee employee = getEmployeeObjet();
		try {
			String employeeJSON = objectMapper.writeValueAsString(employee);
			System.out.println("***** Employee JSON String is ******** \n " + employeeJSON);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}

	private static Employee getEmployeeObjet() {
		Employee employee = new Employee();
		employee.setDepartment("PSR-CP");
		employee.setEmployeeId("ORA098");
		employee.setDesignation("Senior Engineer");
		PersonalDetail pdtail = new PersonalDetail();
		pdtail.setBloodGroup("O+ve");
		pdtail.setFirstName("Nikhil");
		pdtail.setLastName("Ranjan");
		Address address = new Address();
		address.setAddressLineOne("House# 206");
		address.setAddressLineTwo("SLS APRTMENT");
		address.setCity("Bangalore");
		address.setCountry("India");
		address.setLandmark("HSR LAYOUT");
		address.setZip("560043");
		pdtail.setAddress(address);
		employee.setPersonalDetail(pdtail);
		return employee;
	}

}
