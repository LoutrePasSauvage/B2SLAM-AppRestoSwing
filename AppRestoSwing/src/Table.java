import javax.swing.*;
import java.awt.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class Table {
    public void Tables() {
        // Création d'une nouvelle instance de JFrame
        JFrame frame = new JFrame("Liste des commandes");
        frame.setLayout(new BorderLayout());

        // Titre
        JLabel title = new JLabel("Liste des commandes", SwingConstants.LEFT);
        frame.add(title, BorderLayout.NORTH);

        // Création d'une nouvelle police
        Font font = new Font("Default", Font.PLAIN, 45); // Changez 20 à la taille de police que vous voulez

        // Application de la police au JLabel
        title.setFont(font);

        // Données pour le tableau
        Object[][] data = new Object[12][6];
        for (int i = 0; i < 12; i++) {
            // Création d'une nouvelle instance de Commande
            Commande commande = new Commande(1, "2021-01-01", "12:00", "En cours", 2, 25.0);
            data[i][0] = commande.getId();
            data[i][1] = commande.getDate();
            data[i][2] = commande.getHeure();
            data[i][3] = commande.getEtat();
            data[i][4] = commande.getNbPlats();
            data[i][5] = commande.getPrix();
        }

        // Noms des colonnes
        String[] columnNames = {"ID", "Date", "Heure", "Etat", "NB plats", "Montant"};


        JTable table = new JTable(data, columnNames);

        Font font2 = new Font("Default", Font.PLAIN, 25);
        JTableHeader header = table.getTableHeader();

        // police de l'en-tête
        header.setFont(font2);

        Font font3 = new Font("Default", Font.PLAIN, 15);
        table.setFont(font3);

        // Ajout du tableau à un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Ajout d'une bordure vide pour créer un espace entre les bords du tableau et les bords de la fenêtre
        scrollPane.setBorder(BorderFactory.createEmptyBorder(25, 55, 10, 55));

        // Espacement entre les lignes du tableau
        //table.setPadding(10);


        // Ajout du JScrollPane au centre de la fenêtre
        frame.add(scrollPane, BorderLayout.CENTER);

        // Configuration de la fermerture de la fenêtre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1080, 820);

        // Affichage de la fenêtre
        frame.setVisible(true);
    }
}