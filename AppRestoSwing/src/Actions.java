import org.json.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Actions {
    public String getCommandeAttente() {
        String url = "http://localhost/B2SLAM-AppRestoWeb/API/commandes_en_attente.php";
        Map<String, String> params = new HashMap<String, String>();
        params.put("", "");
        String json;

        getApi api = new getApi(url, params);
        try {
            json = api.GetRequest();
            return json;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public String setCommandeAccepter(Integer idCommande) {
        String url = "http://localhost/B2SLAM-AppRestoWeb/API/commande_accepter.php";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id_commande", idCommande.toString());
        String json;

        getApi api = new getApi(url, params);
        try {
            json = api.GetRequest();
            return json;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String setCommandeRefuser(Integer idCommande) {
        String url = "http://localhost/B2SLAM-AppRestoWeb/API/commande_refuser.php";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id_commande", idCommande.toString());
        String json;

        getApi api = new getApi(url, params);
        try {
            json = api.GetRequest();
            return json;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
