package day12.foodOutletRestProb;



import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class capital {

    private static final String RESTURL = "https://jsonmock.hackerrank.com/api/countries";
    static String capitalCityStr = "";
    
    public static String getCountryCodes(String country){
        
        
        try {
        	
        		country=country.replace(" ", "%20");
        		String newurl = RESTURL+"?name="+country;
        		URL url = new URL(newurl);
        		HttpURLConnection con = (HttpURLConnection) url.openConnection();
        		con.setRequestMethod("GET");
        		con.addRequestProperty("Content-Type", "application/json");
        		int status = con.getResponseCode();
                if(status<200 || status>=300) {
                    throw new IOException("Error in reading data with status:"+status);
                }
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String response;
                StringBuilder sb = new StringBuilder();
                while((response = br.readLine())!=null) {
                    sb.append(response);
                }
                br.close();
                con.disconnect();
                JsonObject jsonResponse = new Gson().fromJson(sb.toString(), JsonObject.class);
                JsonArray data = jsonResponse.getAsJsonArray("data");
                if( !data.isEmpty()) {
                	
                	JsonElement capitalCity = data.get(0).getAsJsonObject().get("capital");
                	
                	capitalCityStr = capitalCity.getAsString();
                	
                	
                }
                else return "-1";
                
        		
        		
        	
            
        } catch (Exception e) {
            System.out.println("Exception "+e);
        }
        return capitalCityStr;
      
    }



    public static void main(String[] args) throws Exception {
        
       System.out.println(getCountryCodes("Puerto Rico"));


    }
}

