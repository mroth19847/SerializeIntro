package serializeintro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SchuelerBL{

    private ArrayList<Schueler> schueler = new ArrayList<>();
    
    
    public void add(Schueler s){
        schueler.add(s);
    }
    
    public void save(File f) throws Exception{
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write("Name,Geburtsdatum");
        bw.newLine();
        for (Schueler s: schueler) {
            bw.write(s.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    
    public void load(File f) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        line = br.readLine();
        while((line = br.readLine())!=null){
            String[] hStr = line.split(",");
            schueler.add(new Schueler(hStr[0],LocalDate.parse(hStr[1], DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
        }
        br.close();
    }

    public ArrayList<Schueler> getSchueler() {
        return schueler;
    }
    
    
    
}
