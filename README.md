# RestoSwing

Une brève description du projet.

## Points d'accès

- **/API/commandes_en_attente.php** : Récupère une liste de commandes en attente.
  - Méthode : GET
  - Paramètres : Aucun
  - Réponse : Tableau JSON des commandes en attente
  
<!-- Ajouter plus de points d'accès au besoin -->

## Utilisation des méthodes

### Actions.java

- **getCommandeAttente()** : Récupère les commandes en attente à partir du point d'accès spécifié.

### getApi.java

- **GetRequest()** : Envoie une requête GET à l'URL spécifiée avec des paramètres.

### Ligne.java

- Représente un article dans une commande.

### Commande.java

- Représente une commande.

### Frame.java

- Représente l'interface utilisateur graphique pour afficher les commandes.

## Dépendances

- Java Development Kit (JDK)
- Swing Library (Inclus dans Java SE)
- org.json Library (Ajoutez les informations sur les dépendances si nécessaire)

## Utilisation

1. Clonez le dépôt.

2. Ouvrez le projet dans votre IDE Java préféré.

3. Assurez-vous que toutes les dépendances sont installées.

4. Compilez et exécutez la classe `Frame`.

5. Visualisez les commandes en attente dans l'interface utilisateur graphique.
