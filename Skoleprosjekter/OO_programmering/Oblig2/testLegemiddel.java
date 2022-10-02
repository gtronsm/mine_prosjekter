class testLegemiddel {

    public static void main(String[] args) {

        Narkotisk morfin = new Narkotisk("Morfin", 250, 10, 10);
        Vanedannende imovane= new Vanedannende("Imovane", 150, 5, 5);
        Vanlig paracet= new Vanlig("Paracet", 99, 1000);

        //Test for morfin
        System.out.println("Test for morfin");
        testId(morfin, 1);
        testNavn(morfin, "Morfin");
        testPris(morfin, 250);
        testVirkestoff(morfin, 10);
        testSettNyPris(morfin, 160);
        testNarkotisk(morfin, 10);
        skrivUt(morfin);

        System.out.println();

        System.out.println("Test for imovane");
        testId(imovane, 2);
        testNavn(imovane, "Imovane");
        testPris(imovane, 150);
        testVirkestoff(imovane, 5);
        testSettNyPris(imovane, 125);
        testVanedannende(imovane, 5);
        //Tester at test returnerer feil
        testVanedannende(imovane, 6);
        skrivUt(imovane);

        System.out.println();

        System.out.println("Test for paracet");
        testId(paracet, 3);
        testNavn(paracet, "Paracet");
        testPris(paracet, 99);
        testVirkestoff(paracet, 1000);
        testSettNyPris(paracet, 100);
        skrivUt(imovane);
    }

    //Sjekker om det er riktig ID
    public static void testId(Legemiddel legemiddel, int forventetId) {
        if (legemiddel.hentId() == forventetId) {
            System.out.println("Riktig ID");
        }
        else {
            System.out.println("Feil ID");
        }
    }

    //Sjekker om riktig navn
    public static void testNavn(Legemiddel legemiddel, String forventetNavn) {
        if (legemiddel.hentNavn() == forventetNavn){
            System.out.println("Riktig navn");
        }
        else {
            System.out.println("Feil navn");
        }
    }

    //Sjekker om riktig pris
    public static void testPris(Legemiddel legemiddel, int forventetPris) {
        if (legemiddel.hentPris() == forventetPris){
            System.out.println("Riktig pris");
        }
        else {
            System.out.println("Feil pris");
        }
    }

    //Sjekker om riktig mg virkestoff
    public static void testVirkestoff(Legemiddel legemiddel, double forventetVirkestoff) {
        if (legemiddel.hentVirkestoff() == forventetVirkestoff){
            System.out.println("Riktig mg virkestoff");
        }
        else {
            System.out.println("Feil mg virkestoff");
        }
    }

    //Sjekker at metoden settNyPris endrer pris
    public static void testSettNyPris(Legemiddel legemiddel, int nyPris) {
        legemiddel.settNyPris(nyPris);
        if (legemiddel.hentPris() == nyPris) {
            System.out.println("Riktig ny-pris");
        }
        else {
            System.out.println("Feil ny-pris");
        }
    }

    //Sjekker metoden hentNarkotiskStyrke
    public static void testNarkotisk(Narkotisk legemiddel, int forventetStyrke) {
        if (legemiddel.hentNarkotiskStyrke() == forventetStyrke){
            System.out.println("Riktig narkotisk styrke");
        }
        else {
            System.out.println("Feil narkotisk styrke");
        }
    }

    //Sjekker metoden hentVanedannendeStyrke
    public static void testVanedannende(Vanedannende legemiddel, int forventetStyrke) {
        if (legemiddel.hentVanedannendeStyrke() == forventetStyrke){
            System.out.println("Riktig vanedannende styrke");
        }
        else {
            System.out.println("Feil vanedannende styrke");
        }
    }

    //Sjekker at toString() fungerer
    public static void skrivUt(Legemiddel legemiddel) {
        System.out.println();
        System.out.println("Utskrift av informasjon om legemiddelet: \n");
        System.out.println(legemiddel);
    }



}