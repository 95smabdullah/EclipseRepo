package day3.restAPIproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CapitalCity2 {
	public static String getCapitalCity(String country) {
	try {
		String apiUrl = "https://jsonmock.hackerrank.com/api/countries?name=" + country;
		URL url = new URL(apiUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		int responseCode = connection.getResponseCode();
		if (responseCode == 200) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				response.append(line);
				}
			reader.close();
			String responseData = response.toString();
			int capitalIndex = responseData.indexOf("\"capital\":\"");
			System.out.println(capitalIndex);
			if (capitalIndex != -1) {
				int startIndex = capitalIndex + 11;
				int endIndex = responseData.indexOf("\"", startIndex);
				
				if (endIndex != -1) {
					return responseData.substring(startIndex, endIndex);
					}
				}
			return "-1";
			} else {
				return "-1";
				}
		} catch (IOException e) {
			e.printStackTrace();
			return "-1";
			}
}

	public static void main(String[] args) {
        System.out.print("Enter a country: ");
        String country = "Italy"; // Replace with your desired country or user input
 
        String capital = getCapitalCity(country);
        System.out.println("Capital city: " + capital);
    }
}
