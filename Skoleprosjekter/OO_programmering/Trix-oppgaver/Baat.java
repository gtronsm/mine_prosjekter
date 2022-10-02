class Baat {

    private static int antProd = 0;
    private int prodnr;
    private String merke;

    public Baat(String mrk) {
        prodnr = antProd;
        antProd++;
        merke = mrk;
    }

    public String hentInfo() {
        return "Produksjonsnummer: " + prodnr + ", merke: " + merke;
    }
}

class Baathus {
    private Baat[] baathus;

    public Baathus(int antallPlasser) {
        baathus = new Baat[antallPlasser];
    }
    public void settInn(Baat enBaat) {

        boolean sattInn = false;
        int teller = 0;

        while (teller < baathus.length && sattInn == false) {
            if (baathus[teller] == null) {
                baathus[teller] = enBaat;
                sattInn = true;
            }

            teller++;

        }
    }

    public void skrivBaater() {
        for (int i = 0; i < baathus.length; i ++) {
            if (baathus[i] != null) {
                System.out.println(baathus[i].hentInfo());
            }
           
        }

    }
}

class TestBaathus {
    public static void main(String[] args) {
        Baathus baathus = new Baathus(3);

        Baat b1 = new Baat("Triton");
        Baat b2 = new Baat("Chaparral");
        Baat b3 = new Baat("Mercury");
        Baat b4 = new Baat("Mercury");

        baathus.settInn(b1);
        baathus.settInn(b2);
        baathus.settInn(b3);
        baathus.settInn(b4);
        
        baathus.skrivBaater();
    }
}