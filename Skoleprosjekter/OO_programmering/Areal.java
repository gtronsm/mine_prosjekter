class Areal {

    int bredde;
    int hoyde;

    public Areal(int b, int h) {
        bredde = b;
        hoyde = h;
    }

    public void skrivUt() {
        System.out.println("Bredde: " + bredde);
        System.out.println("Hoyde: " + hoyde);
    }

    public void areal() {
        int areal = bredde * hoyde;
        System.out.println("Areal: " + areal);
    }    
}

class Ut {
    public static void main(String[] args) {
        Areal a1 = new Areal(4,6);
        Areal a2 = new Areal(5,7);

        a1.skrivUt();
        a2.areal();
    }
}