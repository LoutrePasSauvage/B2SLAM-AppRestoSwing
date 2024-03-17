import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Frame {
    private JFrame frame;
    private JPanel contentPanel;
    private CardLayout cardLayout;
    public Frame(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1270, 800);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        contentPanel = new JPanel();
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);
        frame.add(contentPanel, BorderLayout.CENTER);
    }

    public void fillObjects () {

        Actions actions = new Actions();
        String data = actions.getCommandeAttente();
        JSONArray jsonArray = new JSONArray(data);


        String[] columnNames = new String[0];
        ArrayList<Ligne> lignesCommandes = new ArrayList<Ligne>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            columnNames = JSONObject.getNames(obj);
        }

        String[][] DataJson = new String[jsonArray.length()][columnNames.length];

        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject commande = jsonArray.getJSONObject(i);



            // store lignesCommande
            if(commande.has("lignes")) {
                JSONArray lignes = commande.getJSONArray("lignes");
                for(int j = 0; j < lignes.length(); j++) {
                    JSONObject ligne = lignes.getJSONObject(j);
                    Ligne newLigne = new Ligne(
                            ligne.getInt("id_ligne"),
                            commande.getInt("id_commande"),
                            ligne.getInt("id_produit"),
                            ligne.getInt("qte"),
                            ligne.getDouble("total_ligne_ht"),
                            ligne.getString("libelle")
                    );
                    lignesCommandes.add(newLigne);
                }
            }

            // si total_commande est null on le met à 0.0

            if(commande.isNull("total_commande")) {
                commande.put("total_commande", 0.0);
            }

            Commande newCommande = new Commande(
                    commande.getInt("id_commande"),
                    commande.getInt("id_user"),
                    commande.getInt("id_etat"),
                    commande.getDouble("total_commande"),
                    commande.getInt("type_conso"),
                    commande.getString("date"),
                    lignesCommandes
                    );
        }
    }

    public void createTable() throws JSONException {

        Actions actions = new Actions();
        String data = actions.getCommandeAttente();
        JSONArray jsonArray = new JSONArray(data);
        String[] columnNames = new String[0];
        // get Columns names
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            columnNames = JSONObject.getNames(obj);
        }

        String[][] DataJson = new String[jsonArray.length()][columnNames.length];


        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject commande = jsonArray.getJSONObject(i);

            for (int j = 0; j < columnNames.length; j++) {

                DataJson[i][j] = commande.get(columnNames[j]).toString();

            }


        }
        JTable table = new JTable(DataJson, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };


        JTableHeader headerT = table.getTableHeader();
        headerT.setReorderingAllowed(false);
        table.setRowHeight(30);

        JTableHeader header = table.getTableHeader();

        header.setFont(styles.titleFont);
        table.setFont(styles.textFont);

        JScrollPane scrollPanel = new JScrollPane(table);
        scrollPanel.setBackground(styles.secondaryColor);

        if (table.getSelectedRow() == -1 && table.getRowCount() > 0) {
            table.setRowSelectionInterval(0, 0);
        }

        JButton button = this.createButton("Détail", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }, "Détail");

        JPanel buttonPanel = new JPanel(); // Create a new JPanel
        buttonPanel.add(button); // Add


        frame.add(buttonPanel, BorderLayout.WEST); // Add the JPanel to the left of the frame
        frame.add(scrollPanel, BorderLayout.CENTER);
        frame.setVisible(true);

    }



    public JButton createButton(String name, ActionListener actionListener, Object constraints) {
        JButton button = new JButton(name);
        button.setFont(styles.textFont);
        button.setBackground(styles.primaryColor);
        button.setForeground(styles.secondaryColor);
        button.setPreferredSize(new Dimension(150, 50));
        button.addActionListener(actionListener);
        contentPanel.add(button, name);
        return button;
    }




}