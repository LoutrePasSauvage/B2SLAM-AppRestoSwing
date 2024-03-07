
import java.net.*;
import java.io.*;
import java.util.Map;
import java.util.HashMap;
import org.json.*;




public class getApi {
    private String url;
    private Map<String, String> params;


    public getApi(String url, Map<String, String> params) {
        this.url = url;
        this.params = params;
    }

    public String getUrl() {
        return this.url;
    }

    public Map<String, String> getParams() {
        // return Map
        return this.params;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public Map<String, String> GetRequest() throws IOException {


        URL newurl = new URL(this.getUrl());
        HttpURLConnection con = (HttpURLConnection) newurl.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("User-Agent", "Java client");


        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(this.getParams().toString());

        out.flush();
        out.close();


        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));



        String inputLine;

        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        con.disconnect();

        //convert String to JSONString
       // Remove [] from the response
        String responseString = response.toString().replace("[", "").replace("]", "");
        System.out.println("Response: " + response.toString());
        // Convert JSONString to JSONObject

        JSONArray myResponse = new JSONArray(responseString);
        Map<String, String> responseMap = new HashMap<String, String>();
        // Create ArrauList to store the response

        for(int i = 0; i < myResponse.length(); i++) {
            JSONObject obj = myResponse.getJSONObject(i);
            // Add the response to the ArrayList

        }

        return responseMap;

    }


}



