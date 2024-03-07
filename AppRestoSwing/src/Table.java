import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.swing.table.JTableHeader;
import javax.swing.JTable;

public class Table {

    public void Tables() {
        // Création d'une nouvelle instance de JFrame
        JFrame frame = new JFrame("Liste des commandes");
        frame.setLayout(new BorderLayout());
        try {
            URL url = new URL("https://github.com/LoutrePasSauvage/B2SLAM-AppRestoWeb/blob/main/img/logoResto.png?raw=true");
            Image img = ImageIO.read(url);
            frame.setIconImage(img);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Titre
        try {
            URL url = new URL("https://github.com/LoutrePasSauvage/B2SLAM-AppRestoWeb/blob/main/img/logoRestoNoBg.png?raw=true");
            Image img = ImageIO.read(url);
            Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensionnement de l'image
            ImageIcon icon = new ImageIcon(scaledImg);
            JLabel imageLabel = new JLabel(icon);

            JLabel titleLabel = new JLabel("Liste des commandes", SwingConstants.LEFT);
            titleLabel.setForeground(styles.secondaryColor);
            titleLabel.setOpaque(true);
            titleLabel.setBackground(styles.primaryColor);
            titleLabel.setFont(styles.titleFont);

            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panel.setBackground(styles.primaryColor);
            panel.add(imageLabel);
            panel.add(titleLabel);
            frame.add(panel, BorderLayout.NORTH);
        } catch (IOException e) {
            e.printStackTrace();
        }


        String dataJson;
        Actions actions = new Actions();

        dataJson = actions.getCommandeAttente();
        JSONArray jsonArray = new JSONArray(dataJson.toString());


        // Données pour le tableau
        Object[][] data = new Object[jsonArray.length()][6];

        for (int i = 0; i < jsonArray.length(); i++) {
            // Création d'une nouvelle instance de Actions
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            // Appel de la méthode getCommandeAttente


            // Récupération des données de la méthode getCommandeAttente
            data[i][0] = jsonObject.get("id_commande");
            data[i][1] = jsonObject.get("id_user");
            data[i][2] = jsonObject.get("id_etat");
            data[i][3] = jsonObject.get("date");
            data[i][4] = jsonObject.get("total_commande");
            data[i][5] = jsonObject.get("type_conso");
        }

        // Noms des colonnes
        String[] columnNames = {"ID", "User", "Etat", "Date", "Total TTC", "Conso"};


        JTable table = new JTable(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.setRowHeight(40);

        JTableHeader header = table.getTableHeader();

        // police de l'en-tête
        header.setFont(styles.titleFont);

        table.setFont(styles.textFont);

        // Ajout du tableau à un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBackground(styles.secondaryColor);
        // Ajout d'une bordure vide pour créer un espace entre les bords du tableau et les bords de la fenêtre
        scrollPane.setBorder(BorderFactory.createEmptyBorder(25, 55, 10, 55));

        // Ajout du JScrollPane au centre de la fenêtre
        frame.add(scrollPane, BorderLayout.CENTER);

        // Configuration de la fermerture de la fenêtre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1280, 820);

        // Affichage de la fenêtre
        frame.setVisible(true);
    }
}