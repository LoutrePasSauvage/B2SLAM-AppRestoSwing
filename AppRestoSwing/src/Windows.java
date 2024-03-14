import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import org.json.*;

public class Windows {

    JFrame frame = null;


    public Windows(String WinName, String title, int WinWidth, int WinHeight) {
        frame = new JFrame(WinName);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(WinWidth, WinHeight);
        frame.setVisible(true);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(Color.white);
        panel.add(new JLabel(title));
        frame.add(panel, BorderLayout.NORTH);


    }

    public void setIcon(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            Image img = ImageIO.read(url);
            frame.setIconImage(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setImage(String imageUrl) {
        try {
            URL url = new URL("https://github.com/LoutrePasSauvage/B2SLAM-AppRestoWeb/blob/main/img/logoRestoNoBg.png?raw=true");
            Image img = ImageIO.read(url);
            Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensionnement de l'image
            ImageIcon icon = new ImageIcon(scaledImg);
            JLabel imageLabel = new JLabel(icon);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public void createTable(int width, int height, String data) {


        JSONArray jsonArray = new JSONArray(data);
        String[] columnNames = new String[0];
        // get Columns names
        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            columnNames = JSONObject.getNames(obj);
        }

        String[][] DataJson = new String[jsonArray.length()][columnNames.length];

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            for (int j = 0; j < columnNames.length; j++) {
                // detect if is Array
                if(obj.get(columnNames[j]) instanceof JSONArray) {
                    JSONArray arr = obj.getJSONArray(columnNames[j]);
                    DataJson[i][j] = arr.toString();
                } else {
                    DataJson[i][j] = obj.get(columnNames[j]).toString();
                }
            }
        }
        JTable table = new JTable(DataJson, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setRowHeight(30);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.yellow);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, width, height);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);


    }
}