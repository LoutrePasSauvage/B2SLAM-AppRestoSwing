import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class TableDetail {
    public void TableDetails() {

        try {
            HashMap<String, String> params = new HashMap<>();
            getApi api = new getApi("http://localhost/B2SLAM-AppRestoWeb/api/commandes_en_attente.php", params);
            Windows window = new Windows("TableDetails", "DetailsCommande", 1270, 800);

            window.createTable(1200, 700, api.GetRequest());
            window.setIcon("https://github.com/LoutrePasSauvage/B2SLAM-AppRestoWeb/blob/main/img/logoResto.png?raw=true");
            window.setImage("https://github.com/LoutrePasSauvage/B2SLAM-AppRestoWeb/blob/main/img/logoResto.png?raw=true");


        } catch(Exception e) {
        System.err.println("Message : " + e.getMessage());
        }
    }
}
