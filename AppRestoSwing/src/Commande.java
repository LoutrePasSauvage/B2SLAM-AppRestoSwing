public class Commande {
    private int id;
    private String date;
    private String heure;
    private String etat;
    private int nbPlats;
    private double prix;

    public Commande(int id, String date, String heure, String etat, int nbPlats, double prix) {
        this.id = id;
        this.date = date;
        this.heure = heure;
        this.etat = etat;
        this.nbPlats = nbPlats;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public String getEtat() {
        return etat;
    }

    public int getNbPlats() {
        return nbPlats;
    }

    public double getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", heure='" + heure + '\'' +
                ", etat='" + etat + '\'' +
                ", nbPlats=" + nbPlats +
                ", prix=" + prix +
                '}';
    }
}
