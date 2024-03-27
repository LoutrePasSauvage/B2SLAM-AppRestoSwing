# RestoSwing

A brief description of the project.

## Endpoints

- **/API/commandes_en_attente.php**: Retrieves a list of pending orders.
  - Method: GET
  - Parameters: None
  - Response: JSON array of pending orders
  
<!-- Add more endpoints as needed -->

## Method Usage

### Actions.java

- **getCommandeAttente()**: Retrieves pending orders from the specified endpoint.

### getApi.java

- **GetRequest()**: Sends a GET request to the specified URL with parameters.

### Ligne.java

- Represents a line item in an order.

### Commande.java

- Represents an order.

### Frame.java

- Represents the graphical user interface for displaying orders.

## Dependencies

- Java Development Kit (JDK)
- Swing Library (Included in Java SE)
- org.json Library (Add dependency information if any)

## Usage

1. Clone the repository.

2. Open the project in your preferred Java IDE.

3. Ensure that all dependencies are installed.

4. Compile and run the `Frame` class.

5. View pending orders in the graphical user interface.

