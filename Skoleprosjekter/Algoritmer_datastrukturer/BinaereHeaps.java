
import java.util.ArrayList;

import java.util.*;

public class BinaereHeaps {

    public static void main(String[] args) {

        //Testprogram
        ArrayList<Integer> heap = new ArrayList<>(Arrays.asList(0,1,7,2,4,11,10,5,10,6,9,29,14,28,21,19,19,15,22,23));

        insert(heap, 3);
        assert heap.get(4) == 3 : "Feil i insert";

        int minste = removeMinste(heap);
        assert minste == 0 : "Feil minste tall i remove";
        assert heap.get(7) == 6 : "Feil indeks paa endelig 'siste tall'";
    }

    public static void insert(ArrayList<Integer> heap, int element) {
        heap.add(element);

        int indeksElement = heap.size()-1;

        while (0 < indeksElement && element < heap.get(parentOf(indeksElement))) {
            int foreldreElement = heap.get(parentOf(indeksElement));

            heap.set(parentOf(indeksElement), element);
            heap.set(indeksElement, foreldreElement);

            indeksElement = parentOf(indeksElement);
        }
    }

    //Returnerer foreldreindeks
    public static int parentOf(int indeks) {
        return (int)Math.floor((indeks-1) / 2);
    }

    public static int removeMinste(ArrayList<Integer> heap) {
        int minste = heap.get(0);

        int indeks = 0;
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        //Unngaar out of bounds for rightOf til siste indeks
        while (rightOf(indeks) < (heap.size()-1)) {
            int nyIndeks;
            
            //Sjekker om selve tallet til venstre er stoerre eller lik
            if (heap.get(leftOf(indeks)) <= heap.get(rightOf(indeks))) {
                nyIndeks = leftOf(indeks);
            }
            else {
                nyIndeks = rightOf(indeks);
            }

            if (heap.get(nyIndeks) <= heap.get(indeks)) {
                
                int nyIndeksElement = heap.get(nyIndeks);
                heap.set(nyIndeks, heap.get(indeks)); 
                heap.set(indeks, nyIndeksElement);
                
                indeks = nyIndeks;
            }
            else {
                //Tallet maa IKKE 'synke' ned
                break;
            }
        }

        //Unngaar out of bounds for leftOf til siste indeks
        if (leftOf(indeks) < (heap.size()-1) && heap.get(leftOf(indeks)) <= heap.get(indeks)) {
            int leftOfElement = heap.get(leftOf(indeks));
            heap.set(leftOf(indeks), heap.get(indeks));
            heap.set(indeks, leftOfElement);
        }
        return minste;
    }

    public static int leftOf(int indeks) {
        return (indeks * 2) + 1;
    }

    public static int rightOf(int indeks) {
        return (indeks * 2) + 2;
    }
}