import java.util.ArrayList;

import org.json.*;

public class Commande {
    
    private int idCommande;
    private int idUser;
    private int idEtat;
    private double totalCommande;
    private int typeConso;
    private String date;

    private ArrayList<Ligne> lignesCommande;

    public Commande(int idCommande, int idUser, int idEtat, double totalCommande, int typeConso, String date, ArrayList lignesCommande) 
    {
        this.idCommande = idCommande;
        this.idUser = idUser;
        this.idEtat = idEtat;
        this.totalCommande = totalCommande;
        this.typeConso = typeConso;
        this.date = date;
        this.lignesCommande = lignesCommande;
    }

    // Getters et setters
    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdEtat() {
        return idEtat;
    }

    public void setIdEtat(int idEtat) {
        this.idEtat = idEtat;
    }

    public double getTotalCommande() {
        return totalCommande;
    }

    public void setTotalCommande(double totalCommande) {
        this.totalCommande = totalCommande;
    }

    public int getTypeConso() {
        return typeConso;
    }

    public void setTypeConso(int typeConso) {
        this.typeConso = typeConso;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}