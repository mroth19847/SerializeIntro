package serializeintro;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoadTester {

    public static void main(String[] args) {
        SchuelerBL bl = new SchuelerBL();
        try {
            bl.load(new File("./klasse.csv"));
            for (Schueler s : bl.getSchueler()) {
                System.out.println(s.toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
