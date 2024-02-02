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

public class solution1 {

    private static final String RESTURL = "https://jsonmock.hackerrank.com/api/food_outlets";
    static List<String> outletList = new ArrayList<>();
    public static List<String> getRelevantFoodOutlets(String city, int maxCost){
        int page = 1;
        int totalPages = Integer.MAX_VALUE;
        
        
//        List<String> cityList = new ArrayList<>();
        try {
        	while (page <= totalPages) {
        		String outletName = null;
        		String newurl = RESTURL+"?city="+city+"&page="+page;
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
                totalPages = jsonResponse.get("total_pages").getAsInt();
                JsonArray data = jsonResponse.getAsJsonArray("data");
                for (JsonElement e : data) {
                    if(e.getAsJsonObject().get("estimated_cost").getAsInt() <= maxCost) {
                    	outletName = e.getAsJsonObject().get("name").getAsString();
                    	outletList.add(outletName);
                    }
                }
                page++;
        		
        		
        	}
            
        } catch (Exception e) {
            System.out.println("Exception "+e);
        }
        return outletList;
      
    }



    public static void main(String[] args) throws Exception {
        String city = "Houston";
        int maxCost = 30;
        List<String> res = getRelevantFoodOutlets(city,maxCost);
        for (String r:res) {
        	System.out.println(r);
        }


    }
}

