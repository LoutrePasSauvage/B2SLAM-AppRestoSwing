import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import javax.swing.table.JTableHeader;
import javax.swing.JTable;

public class Table {

    public void Tables() {

        try {
            HashMap<String, String> params = new HashMap<>();
            getApi api = new getApi("http://localhost/B2SLAM-AppRestoWeb/api/commandes_en_attente.php", params);
            Windows window = new Windows("TableCommandes", 1270, 800);

            window.createTable(1200, 700, api.GetRequest());
            window.setTitle("Commandes");
            window.setIcon("https://github.com/LoutrePasSauvage/B2SLAM-AppRestoWeb/blob/main/img/logoResto.png?raw=true");
            window.setImage("https://github.com/LoutrePasSauvage/B2SLAM-AppRestoWeb/blob/main/img/logoResto.png?raw=true");
            window.setButton("Détails");


        } catch(Exception e) {
            System.err.println("Message : " + e.getMessage());
        }
    }
}