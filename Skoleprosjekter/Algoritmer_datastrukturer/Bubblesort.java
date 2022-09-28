import java.util.ArrayList;
import java.util.Random;

public class Bubblesort {

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
        sorterBubble(enListe);
        System.out.println("Sortert liste: " + enListe);
    }

    public static ArrayList<Integer> sorterBubble(ArrayList<Integer> liste) {

        for (int i = 0; i < liste.size()-1; i++) {
            for (int j = 0; j < (liste.size() - i - 1); j++) {
                if (liste.get(j) > liste.get(j + 1)) {
                    int elementVenstre = liste.get(j);
                    int elementHoyre = liste.get(j + 1);

                    liste.set(j, elementHoyre);
                    liste.set(j + 1, elementVenstre);
                }
            }
        }
        return liste;
    }
}