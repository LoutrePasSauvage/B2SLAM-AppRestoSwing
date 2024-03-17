import java.util.ArrayList;

import org.json.*;

public class Ligne {
    private int idLigne;
    private int idCommande;
    private int idProduit;
    private int qte;
    private double totalLigneHT;

    private  String libelleProduit;

    public Ligne(int idLigne, int idCommande, int idProduit, int qte, double totalLigneHT, String libelleProduit) {
        this.idLigne = idLigne;
        this.idCommande = idCommande;
        this.idProduit = idProduit;
        this.qte = qte;
        this.totalLigneHT = totalLigneHT;
        this.libelleProduit = libelleProduit;
    }

    public String getLibelleProduit() {
        return libelleProduit;
    }

    public void setLibelleProduit(String libelleProduit) {
        this.libelleProduit = libelleProduit;
    }
    public int getIdLigne() {
        return idLigne;
    }

    public void setIdLigne(int idLigne) {
        this.idLigne = idLigne;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public double getTotalLigneHT() {
        return totalLigneHT;
    }

    public void setTotalLigneHT(double totalLigneHT) {
        this.totalLigneHT = totalLigneHT;
    }
}