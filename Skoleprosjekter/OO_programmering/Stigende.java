public class Stigende {

    static int antRader;

    public static void main(String[] args) {

        int m = 3;
        int n = 5;
        
        antRader = (2*(n - m + 1));

        triangel(m,n);
        
    }


    public static void triangel (int m, int n) {

        String s = "";

        int raderTeller = 0;


        if (raderTeller <= antRader) {
            if (m < n) {

                int lengde = m + 1;
                for (int indeks = 0; indeks < lengde; indeks++) {
                    s += "*";
                }

                triangel((m+1),n);
            }

            else if (m == n) {
                int lengde = n;
                for (int indeks = 0; indeks <= lengde; indeks++) {
                    s += "*";
                }
            }
        }
        System.out.println(s);
    }
}