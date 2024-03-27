import org.json.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Frame {
    private JFrame frame;
    private JPanel contentPanel;
    private CardLayout cardLayout;

    public Frame(String title) {
        frame = new JFrame(title);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1270, 720);

        frame.setVisible(true);

        frame.setLayout(new BorderLayout());
        contentPanel = new JPanel();
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);
        frame.add(contentPanel, BorderLayout.CENTER);
    }

    public void fillObjects() {

        Actions actions = new Actions();
        String data = actions.getCommandeAttente();

        if (data == null) {
            JLabel label = new JLabel("Aucune commande en attente");
            label.setFont(styles.titleFont);
            return;
        }

        JSONArray jsonArray = new JSONArray(data);


        String[] columnNames = new String[0];
        ArrayList<Ligne> lignesCommandes = new ArrayList<Ligne>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            columnNames = JSONObject.getNames(obj);
        }

        String[][] DataJson = new String[jsonArray.length()][columnNames.length];

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject commande = jsonArray.getJSONObject(i);


            // store lignesCommande
            if (commande.has("lignes")) {
                JSONArray lignes = commande.getJSONArray("lignes");
                for (int j = 0; j < lignes.length(); j++) {
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

            if (commande.isNull("total_commande")) {
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

            DataJson[i][0] = newCommande.getDate();
            DataJson[i][1] = newCommande.getLignesCommande().toString();
            DataJson[i][2] = String.valueOf(newCommande.getTypeConso());
            DataJson[i][3] = String.valueOf(newCommande.getIdCommande());
            DataJson[i][4] = String.valueOf(newCommande.getTotalCommande());
            DataJson[i][5] = String.valueOf(newCommande.getIdUser());
            DataJson[i][6] = String.valueOf(newCommande.getIdEtat());

        }

        JTable table = new JTable(DataJson, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };


        JTableHeader headerT = table.getTableHeader();
        headerT.setReorderingAllowed(false);
        table.setRowHeight(50);

        JTableHeader header = table.getTableHeader();

        header.setFont(styles.titleFont);
        table.setFont(styles.textFont);

        JScrollPane scrollPanel = new JScrollPane(table);
        scrollPanel.setBackground(styles.secondaryColor);


        if (table.getSelectedRow() == -1 && table.getRowCount() > 0) {
            table.setRowSelectionInterval(0, 0);
        }

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(12, 1));
        buttonPanel.setBackground(styles.primaryColor);

        JButton buttonDetails = this.createButton("Détail", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                // affiche le détail de la commande a partir de la ligne selectionnée
                int selectedRow = table.getSelectedRow();
                int idCommande = Integer.parseInt((String) table.getValueAt(selectedRow, 3));
                //new Jpanel
                JPanel panel = new JPanel();

                String columnNames[] = {"id_produit", "qte", "total_ligne_ht", "libelle"};
                String DataJson[][] = new String[lignesCommandes.size() + 1][columnNames.length + 1];
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject commande = jsonArray.getJSONObject(i);
                    if (commande.getInt("id_commande") == idCommande) {
                        JSONArray lignes = commande.getJSONArray("lignes");
                        DataJson = new String[lignes.length()][4];
                        for (int j = 0; j < lignes.length(); j++) {
                            JSONObject ligne = lignes.getJSONObject(j);
                            DataJson[j][0] = String.valueOf(ligne.getInt("id_produit"));
                            DataJson[j][1] = String.valueOf(ligne.getInt("qte"));
                            DataJson[j][2] = String.valueOf(ligne.getDouble("total_ligne_ht"));
                            DataJson[j][3] = ligne.getString("libelle");
                        }
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
                table.setRowHeight(50);
                headerT.setFont(styles.titleFont);
                table.setFont(styles.textFont);

                JScrollPane scrollPanel = new JScrollPane(table);
                scrollPanel.setBackground(styles.secondaryColor);
                contentPanel.add(scrollPanel, "mainPanel");


                panel.add(scrollPanel);

                JButton buttonReturn = createButton("Retour", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JPanel panel = new JPanel();
                        panel.setLayout(new BorderLayout());
                        panel.add(buttonPanel, BorderLayout.WEST); // Add the buttonPanel back
                        panel.add(scrollPanel, BorderLayout.CENTER); // Add the scrollPanel to the center

                        Frame.this.frame.setContentPane(panel);
                        fillObjects();
                        Frame.this.frame.revalidate();
                        Frame.this.frame.repaint();
                    }
                }, panel);
                buttonReturn.setBackground(styles.primaryColor);

                JButton buttonAccepter = createButton("Accepter", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                }, panel);
                buttonAccepter.setBackground(styles.okColor);

                JButton buttonRefuser = createButton("Refuser", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                }, panel);
                buttonRefuser.setBackground(styles.warningColor);

                // Add panel to the content panel
                Frame.this.frame.setContentPane(panel);

                Frame.this.frame.revalidate();
                Frame.this.frame.repaint();


            }
        }, contentPanel);
        buttonDetails.setBackground(styles.detailsColor);


        JButton buttonExit = this.createButton("Exit", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }, buttonPanel);
        buttonExit.setBackground(styles.warningColor);

        buttonPanel.add(buttonDetails);
        buttonPanel.add(buttonExit);

        frame.add(buttonPanel, BorderLayout.WEST);
        frame.add(scrollPanel, BorderLayout.CENTER);
        contentPanel.setVisible(true);
        frame.setVisible(true);
    }

    public void ResetAll() {


    }


    public JButton createButton(String name, ActionListener actionListener, JPanel buttonPanel) {
        JButton button = new JButton(name);
        button.setFont(styles.textFont);
        button.setBackground(styles.primaryColor);
        button.setForeground(styles.secondaryColor);
        button.setPreferredSize(new Dimension(150, 50));
        button.addActionListener(actionListener);
        buttonPanel.add(button, name);
        return button;
    }
}
