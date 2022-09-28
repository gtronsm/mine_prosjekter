public class BinaersokRekursivt {
    int midten;

    public static void main(String[] args) {
        int[] liste = {2,3,4,5,6,8,10,14};
        System.out.println(binaerSok(liste, 0, liste.length, 4));
    }
    
    public static int binaerSok(int[] liste, int start, int stopp, int tall) {
        int midten = (int)(Math.floor((start + stopp)/2));

        if (start > stopp) {
            return -1;
        }

        if (tall == liste[midten]) {
            //returnerer indeks hvor tallet befinner seg
            return midten;
        }

        if (tall < liste[midten]) {
            return binaerSok(liste, start, midten - 1, tall);
        }

        if (tall > liste[midten]) {
            return binaerSok(liste, midten + 1, stopp, tall);
        }

        return -1;
    }
}