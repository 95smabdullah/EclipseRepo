package day2.restProblem.controller;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
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

import day2.restProblem.entities.Asset;
import day2.restProblem.entities.Device;

//import org.glassfish.jersey.client.ClientConfig;
//import com.fasterxml.jackson.databind.ObjectMapper;

import day2.restProblem.entities.IotResponse;
import day2.restProblem.entities.OperatingParams;
import day2.restProblem.entities.Parent;

public class Controller {
	
		
		

	    public static IotResponse getApiResponse(String statusQuery, int pageNumber) {
	        try {
	            // Build the URL with the specified statusQuery and pageNumber
	            String apiUrl = "https://jsonmock.hackerrank.com/api/iot_devices/search?status=" + statusQuery + "&page=" + pageNumber;

	            // Create a URL object and open a connection
	            URL url = new URI(apiUrl).toURL();
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("GET");

	            if (connection.getResponseCode() == 200) {
	                // Read the JSON response into a string
	            	System.out.println("connection done");
	                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	                System.out.println("buffered reader read");
	                String jsonResponse = reader.lines().collect(Collectors.joining("\n"));
	                System.out.println(jsonResponse);
	                
	                reader.close();

	                // Deserialize the JSON response into the IotResponse object
	                IotResponse iotResponse = parseJsonResponse(jsonResponse);

	                connection.disconnect(); // Close the connection
	                return iotResponse;
	            } else {
	                // Handle error or return null in case of failure
	                connection.disconnect(); // Close the connection
	                return null;
	            }
	        } catch (Exception e) {
	            // Handle exceptions, e.g., network issues or JSON parsing errors
	            e.printStackTrace();
	            return null; // or return an error response
	        }
	    }

	    private static IotResponse parseJsonResponse(String jsonResponse) {
	        try {
	        	
	        	JsonReader reader = Json.createReader(new StringReader(jsonResponse));
	            // Assuming the JSON response is an object with fields like "page", "per_page", "total", "total_pages", and "data"
	        	System.out.println("hi from parser");
	        	JsonObject json = reader.readObject();

	            IotResponse apiResponse = new IotResponse();
	            apiResponse.setPage(json.getInt("page"));
	            apiResponse.setPer_page(json.getInt("per_page"));
	            apiResponse.setTotal(json.getInt("total"));
	            apiResponse.setTotal_pages(json.getInt("total_pages"));

	            // Parse the "data" array
	            JsonArray dataArray = json.getJsonArray("data");
	            List<Device> devices = new ArrayList<>();
	            for (int i = 0; i < dataArray.size(); i++) {
	            	JsonObject deviceJson = dataArray.getJsonObject(i);
	                Device device = new Device();
	                device.setId(deviceJson.getInt("id"));
//	                device.setTimestamp(Long.parseLong(deviceJson.getString("timestamp")));
	                device.setTimestamp(deviceJson.getJsonNumber("timestamp").longValue());
	                device.setStatus(deviceJson.getString("status"));

	                // Parse the "operatingParams" object
	                JsonObject operatingParamsJson = deviceJson.getJsonObject("operatingParams");
	                OperatingParams operatingParams = new OperatingParams();
	                operatingParams.setRotorSpeed(operatingParamsJson.getJsonNumber("rotorSpeed").doubleValue());
	                operatingParams.setSlack(operatingParamsJson.getJsonNumber("slack").doubleValue());
	                operatingParams.setRootThreshold(operatingParamsJson.getJsonNumber("rootThreshold").doubleValue());
//	                operatingParams.setRotorSpeed(Double.parseDouble(operatingParamsJson.getString("rotorSpeed")));
//	                operatingParams.setSlack(Double.parseDouble(operatingParamsJson.getString("slack")));
//	                operatingParams.setRootThreshold(Double.parseDouble(operatingParamsJson.getString("rootThreshold")));
	                device.setOperatingParams(operatingParams);

	                // Parse the "asset" object
	                JsonObject assetJson = deviceJson.getJsonObject("asset");
	                Asset asset = new Asset();
	                asset.setId(assetJson.getInt("id"));
	                asset.setAlias(assetJson.getString("alias"));
	                device.setAsset(asset);

	                // Check if "parent" exists
//	                if (deviceJson.containsKey("parent")) {
//	                	System.out.println(deviceJson.get("parent").getValueType());
//	                }
//	                
	                if (deviceJson.containsKey("parent") && deviceJson.get("parent").getValueType() != ValueType.NULL) {
	                    JsonObject parentJson = deviceJson.getJsonObject("parent");
	                    Parent parent = new Parent();
	                    parent.setId(parentJson.getInt("id"));
	                    parent.setAlias(parentJson.getString("alias"));
	                    device.setParent(parent);
	                }

	                devices.add(device);
	            }
	            apiResponse.setData(devices);

	            return apiResponse;
	        } catch (JsonException e) {
	            e.printStackTrace();
	            return null; // Handle parsing errors or return an error response
	        }
	    }

	}
