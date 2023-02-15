
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Vocabulary {
    
    public static void main(String[] args) {
        ArrayList<String> rivit1 = new ArrayList<>();
        ArrayList<String> rivit2 = new ArrayList<>();
        try (Scanner tiedostonLukija = new Scanner(Paths.get("vocabulary.txt"))) {
            while (tiedostonLukija.hasNextLine()) {
                String rivi = tiedostonLukija.nextLine();
                rivit1.add(rivi);
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
        try (Scanner tiedostonLukija = new Scanner(Paths.get("vocabulary2.txt"))) {
            while (tiedostonLukija.hasNextLine()) {
                String rivi = tiedostonLukija.nextLine();
                rivit2.add(rivi);
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
        //tapa 1
        long alku = System.nanoTime();
        String puuttuva = "";
        for (String rivi : rivit1) {
            if(!rivit2.contains(rivi)){
                puuttuva=rivi;
                break;
            }
        }
        long loppu = System.nanoTime();
        long kesto1 = (loppu - alku)/1000000;
        System.out.println(puuttuva);
        System.out.println(kesto1+" ms");
        
        //tapa 2
        HashSet<String> hrivit2 = new HashSet<>();
        alku = System.nanoTime();
        for(int i=0;i<rivit2.size();i++){
            hrivit2.add(rivit2.get(i));
        }
        for (String rivi : rivit1) {
            if(!hrivit2.contains(rivi)){
                puuttuva=rivi;
                break;
            }
        }
        loppu = System.nanoTime();
        long kesto2 = (loppu - alku)/1000000;
        System.out.println(puuttuva);
        System.out.println(kesto2+" ms");
        
        // tapa 3
        alku = System.nanoTime();
        Collections.sort(rivit1);
        Collections.sort(rivit2);
        for(int i=0;i<rivit2.size();i++){
            if(!rivit1.get(i).equals(rivit2.get(i))){
                puuttuva=rivit1.get(i);
                break;
            }
        }
        loppu = System.nanoTime();
        long kesto3 = (loppu - alku)/1000000;
        System.out.println(puuttuva);
        System.out.println(kesto3+" ms");
    }
    
}
