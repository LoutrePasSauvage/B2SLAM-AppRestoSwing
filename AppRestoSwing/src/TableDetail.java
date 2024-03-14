import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class TableDetail {
    public void TableDetails() {

        HashMap<String, String> params = new HashMap<>();
        params.put("","");
        getApi api = new getApi("", params);
        Windows window = new Windows("TableDetails", "DetailsCommande", 1270, 800);

    }
}
