package day2.restProblem.controller;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonException;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue.ValueType;

import java.io.StringReader;



//import org.glassfish.jersey.client.ClientConfig;
//import com.fasterxml.jackson.databind.ObjectMapper;


public class Parser {
	
		
		static String query = "";
		static int totPages = 1;
		static int result = 0;
		static double thresh = 0;
		static SimpleDateFormat sdf = new SimpleDateFormat("MM-yyyy");
		static String theDate = "";

	    public static int parseJsonResponse(String srch, double threshold, String dt) {
	    	thresh = threshold;
	    	query = srch;
	        theDate = dt;
	        
	        	
	        	for(int p=1;p<=totPages;p++) {
	        		try {
	        			
	        			String apiUrl = "https://jsonmock.hackerrank.com/api/iot_devices/search?status=" + query + "&page=" + p;

	    	            URL url = new URI(apiUrl).toURL();
	    	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	    	            connection.setRequestMethod("GET");
	    	            if (connection.getResponseCode() == 200) {
	    	                BufferedReader breader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	    	                String jsonResponse = breader.lines().collect(Collectors.joining("\n"));	    	                
	    	                breader.close();
	    	                
	    	                JsonReader reader = Json.createReader(new StringReader(jsonResponse));

	    		        	JsonObject json = reader.readObject();
	    		            totPages = json.getInt("total_pages");
	    		            JsonArray dataArray = json.getJsonArray("data");
	    		            
	    		            for (int i = 0; i < dataArray.size(); i++) {
	    		            	
	    		            	JsonObject deviceJson = dataArray.getJsonObject(i);
	    		            	long secs = deviceJson.getJsonNumber("timestamp").longValue();
	    		            	Date millis = new Date(secs);
	    		            	String formattedDate = sdf.format(millis);
	    		                
	    		                if(deviceJson.getString("status").equals(query) && formattedDate.equals(theDate)) {
	    		                	JsonObject operatingParamsJson = deviceJson.getJsonObject("operatingParams");             	
	    		                	if(operatingParamsJson.getJsonNumber("rootThreshold").doubleValue()>=thresh) {
	    		                		result++;
	    		                		
	    		                	}
	    		                }
	    		            }
	    	            }

	        			
	        		}catch (Exception e) {
	    	            
	    	            e.printStackTrace();
	        		}
	        	}
	        	
	        	
	                

	                

	            return result;
	    }

	}
