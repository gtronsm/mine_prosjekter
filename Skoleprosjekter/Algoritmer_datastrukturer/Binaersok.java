
class Binaersok {
    public static void main(String[] args) {
        int[] liste = {2,3,4,5,6,8};
        System.out.println(iterere(liste, 4));
    }

    public static boolean iterere(int[] liste, int tall) {
        int low = 0;
        int high = liste.length - 1;
        while (low <= high) {
            int indeks = ((low + high)/2);

            if (liste[indeks] == tall) {
                return true;
            }

            else if (liste[indeks] < tall) {
                low = indeks + 1;
            }

            else if (liste[indeks] > tall) {
                high = indeks - 1;
            }
        }
        return false;
    }
}