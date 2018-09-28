package serializeintro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SchuelerBL {

    private ArrayList<Schueler> schueler = new ArrayList<>();

    public void add(Schueler s) {
        schueler.add(s);
    }

    public void save(File f) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write("Name,Geburtsdatum");
        bw.newLine();
        for (Schueler s : schueler) {
            bw.write(s.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public void load(File f) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        line = br.readLine();
        while ((line = br.readLine()) != null) {
            String[] hStr = line.split(",");
            schueler.add(new Schueler(hStr[0], LocalDate.parse(hStr[1], DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
        }
        br.close();
    }

    public void loadSerialize(File f) throws Exception{
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Schueler s = (Schueler) ois.readObject();
        fis.close();
        ois.close();
    }

    public void saveSerialize(File f) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        for (Schueler s : schueler) {
            oos.writeObject(s);
        }
        oos.flush();
        oos.close();
    }

    public ArrayList<Schueler> getSchueler() {
        return schueler;
    }

}
