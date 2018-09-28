package serializeintro;

import java.io.File;
import java.time.LocalDate;

public class SaveTester {
    

    public static void main(String[] args) {
        Schueler s1 = new Schueler("Hans", LocalDate.of(2000, 3, 1));
        Schueler s2 = new Schueler("Grete", LocalDate.of(1999, 10, 10));
        Schueler s3 = new Schueler("Frederik", LocalDate.of(1997, 10, 12));
        SchuelerBL bl = new SchuelerBL();
        bl.add(s1);
        bl.add(s2);
        bl.add(s3);
        try {
            bl.saveSerialize(new File("./klasse.ser"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
