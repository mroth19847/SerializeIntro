package serializeintro;

import java.io.File;

public class LoadTester {

    public static void main(String[] args) {
        SchuelerBL bl = new SchuelerBL();
        try {
            bl.loadSerialize(new File("./klasse.ser"));
            System.out.println("Name,Geburtstag");
            for (Schueler s : bl.getSchueler()) {
                System.out.println(s.toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
