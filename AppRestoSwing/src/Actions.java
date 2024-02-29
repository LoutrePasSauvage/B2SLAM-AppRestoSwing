import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Actions {
    public void getCommandeAttente() {
        String url = "http://localhost/B2SLAM-AppRestoWeb/API/commandes_en_attente.php";
        Map<String, String> params = new HashMap<String, String>();
        params.put("", "");
        getApi api = new getApi(url, params);
        try {
            api.CreateRequest();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
