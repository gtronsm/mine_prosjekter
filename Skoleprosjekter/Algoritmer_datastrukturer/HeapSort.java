
import java.util.ArrayList;
import java.util.Random;

public class HeapSort {

    // ikke paabegynt enda

    public static void main(String[] args) {

        //Testprogram
        ArrayList<Integer> enListe = new ArrayList<>();
        Random random = new Random();
        int teller = 0;

        for (int i = 0; i < 10; i++) {
            int tilfeldigTall = random.nextInt(100);
            if (!enListe.contains(tilfeldigTall)) {
                enListe.add(tilfeldigTall); 
            }
        }

        System.out.println("Usortert liste: " + enListe);
        sorterHeap(enListe);
        System.out.println("Sortert liste: " + enListe);
    }

    public static ArrayList<Integer> sorterHeap(ArrayList<Integer> liste) {

        return liste;
    }
    
}