import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class TableDetail {


    public void TableDetails(String url, HashMap<String, String> params) {
        try {
            getApi api = new getApi(url, params);
            Windows window = new Windows("TableDetails", 1270, 800);

            window.createTable(1200, 700, api.GetRequest(), "Retour", params);
            window.setTitle("DetailsCommandes");
            window.setIcon("https://github.com/LoutrePasSauvage/B2SLAM-AppRestoWeb/blob/main/img/logoResto.png?raw=true");
            window.setImage("https://github.com/LoutrePasSauvage/B2SLAM-AppRestoWeb/blob/main/img/logoResto.png?raw=true");
            window.setButton("Retour", "Retour");

        } catch(Exception e) {
        System.err.println("Message : " + e.getMessage());
        }
    }
}
