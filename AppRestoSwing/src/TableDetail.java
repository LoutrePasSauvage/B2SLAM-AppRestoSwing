import javax.swing.*;
import java.awt.*;

public class TableDetail {
    public void TableDetails() {
        // Création d'une nouvelle instance de JFrame
        JFrame DetailCommande = new JFrame("Détails de la commande");
        DetailCommande.setLayout(new BorderLayout());

        // Configuration de la fermerture de la fenêtre

        DetailCommande.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DetailCommande.setSize(1280, 820);

        // Affichage de la fenêtre
        // dont close the main window
        DetailCommande.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DetailCommande.setVisible(true);

    }
}
