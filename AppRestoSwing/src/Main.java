import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Actions actions = new Actions();

        actions.getCommandeAttente();
        actions.getCommandeRefuser(220);

        Table table = new Table();
        table.Tables();
    }
}