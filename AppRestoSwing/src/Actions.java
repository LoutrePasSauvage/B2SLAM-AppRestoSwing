import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Actions {
    public void getCommandeAttente() {
        String url = "http://localhost/B2SLAM-AppRestoWeb/API/commandes_en_attente.php";
        Map<String, String> params = new HashMap<String, String>();
        params.put("", "");
        Map<String, String> response = new HashMap<String, String>();

        getApi api = new getApi(url, params);
        try {
           response = api.GetRequest();
           for(Map.Entry<String, String> entry : response.entrySet()) {
               System.out.println(entry.getKey() + " : " + entry.getValue());
           }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getCommandeTerminer(Integer idValue) {
        String url = "http://localhost/B2SLAM-AppRestoWeb/api/commande_terminer.php";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id_commande", idValue.toString());
        Map<String, String> response = new HashMap<String, String>();

        getApi api = new getApi(url, params);

        try {
            response = api.GetRequest();
            for(Map.Entry<String, String> entry : response.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getCommandeRefuser(Integer idValue) {
        String url = "http://localhost/B2SLAM-AppRestoWeb/api/commande_refuser.php";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id_commande", idValue.toString());
        Map<String, String> response = new HashMap<String, String>();

        getApi api = new getApi(url, params);

        try {
            response = api.GetRequest();
            for(Map.Entry<String, String> entry : response.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
