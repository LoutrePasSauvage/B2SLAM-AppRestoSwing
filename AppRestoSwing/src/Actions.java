import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Actions {
    public void getCommandeAttente() {
        String url = "http://localhost/B2SLAM-AppRestoWeb/API/commandes_en_attente.php";
        Map<String, String> params = new HashMap<String, String>();
        params.put("", "");
        String json;

        getApi api = new getApi(url, params);
        try {
            json = api.GetRequest();
            JSONArray myResponse = new JSONArray(json.toString());

            System.out.println("size: " + myResponse.length());
            for(int i = 0; i < myResponse.length(); i++) {
                JSONObject obj = myResponse.getJSONObject(i);
                System.out.println(obj.get("id_commande"));
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
