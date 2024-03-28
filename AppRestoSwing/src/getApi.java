
import java.net.*;
import java.io.*;
import java.util.ArrayList;
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

    public String GetRequest() throws IOException {


        //get key value pairs from Map
        String key = "", value = "";

        for(Map.Entry<String, String> entry : this.getParams().entrySet()) {
           key = entry.getKey();
           value = entry.getValue();

        }
        URL newurl = new URL(this.getUrl() + "?" + key + "=" + value);
        System.out.println(newurl);
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
        // Convert JSONString to JSONObject

        return response.toString();


    }


}



