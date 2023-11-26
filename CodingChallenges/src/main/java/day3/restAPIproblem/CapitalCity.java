package day3.restAPIproblem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.json.JSONObject; 

public class CapitalCity {

	
	 

    public static String getCapitalCity(String country) {
    	
    	try {
    		String apiUrl = "https://jsonmock.hackerrank.com/api/countries?name=" + country;
    		URL url = new URL(apiUrl);
    		HttpURLConnection connection = (HttpURLConnection) url.openConnection(); connection.setRequestMethod("GET");
    		int responseCode = connection.getResponseCode();
    		if (responseCode == 200) {
    			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	    		StringBuilder response = new StringBuilder();
	    		String line;
	    		while ((line = reader.readLine()) != null) {
	    			response.append(line);
	    		 }
    		reader.close();
    		JSONObject jsonResponse = new JSONObject(response.toString());
    		if (jsonResponse.getJSONArray("data").isEmpty()) {
    			return "-1";
    			} else {
    				return jsonResponse.getJSONArray("data") .getJSONObject(0).getString("capital");
    			}
    			} else {
    				return "-1";
    			}
    		} catch (Exception e) {
    			e.printStackTrace();
    			return "-1";
    		}
    	}
    
//        try {
//            String apiUrl = "https://jsonmock.hackerrank.com/api/countries?name=" + country;
//            URL url = new URI(apiUrl).toURL();
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
// 
//            int responseCode = connection.getResponseCode();
// 
//            if (responseCode == 200) {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                StringBuilder response = new StringBuilder();
//                String line;
// 
//                while ((line = reader.readLine()) != null) {
//                    response.append(line);
//                }
// 
//                reader.close();
//                connection.disconnect();
// 
//                // Parse the JSON response
//                String jsonResponse = response.toString();
//                // You can use a JSON library to parse the response, such as Gson or org.json.
//                // Here, I'll use a simple method to extract the capital field.
//                String capital = extractCapitalFromJson(jsonResponse);
// 
//                if (capital.isEmpty()) {
//                    return "-1";
//                }
// 
//                return capital;
//            } else {
//                return "-1";
//            }
//        } catch (IOException | URISyntaxException e) {
//            e.printStackTrace();
//            return "-1";
//        }
//    }
// 
//    // Replace this method with a proper JSON parsing library (e.g., Gson or org.json) for production use.
//    private static String extractCapitalFromJson(String jsonResponse) {
//        // Parse the JSON and extract the capital field.
//        // This is a simplified example. Use a JSON library for robust parsing.
//        // For example, using Gson:
//        // Gson gson = new Gson();
//        // YourObject obj = gson.fromJson(jsonResponse, YourObject.class);
//        // return obj.capital;
//        return "";
//    }
// 
    public static void main(String[] args) {
        System.out.print("Enter a country: ");
        String country = "Italy"; // Replace with your desired country or user input
 
        String capital = getCapitalCity(country);
        System.out.println("Capital city: " + capital);
    }
}


