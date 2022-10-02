class testResepter {
    public static void main(String[] args) {
        Lege lege = new Lege("");
        Legemiddel paracet = new Vanlig("Paracet", 100, 1000);
        Resept reseptHvit = new HvitResept (paracet, lege, 5, 0);
        Resept reseptMill = new MilResept (paracet, lege, 8);
        Resept reseptPrevansjon = new PResept (paracet, lege, 10, 2);
        Resept reseptBlaa = new BlaResept (paracet, lege, 14, 1);

        //Test for HvitResept
        System.out.println("Test for HvitResept");
        testId(reseptHvit, 1);
        testPasientId(reseptHvit, 5);
        testReit(reseptHvit, 0);
        testBruk(reseptHvit, false);
        testFarge(reseptHvit, "hvit");
        testNyPris(reseptHvit, 100);

        System.out.println();

        //Test for MilResept
        System.out.println("Test for MilResept");
        testId(reseptMill, 2);
        testPasientId(reseptMill, 8);
        testReit(reseptMill, 3);
        testBruk(reseptMill, true);
        testFarge(reseptMill, "hvit");
        testNyPris(reseptMill, 0);
        
        System.out.println();

        //Test for PResept
        System.out.println("Test for PResept");
        testId(reseptPrevansjon, 3);
        testPasientId(reseptPrevansjon, 10);
        testReit(reseptPrevansjon, 2);
        testBruk(reseptPrevansjon, true);
        testFarge(reseptPrevansjon, "hvit");
        testNyPris(reseptPrevansjon, 0);

        System.out.println();

        //Test for BlaResept
        System.out.println("Test for BlaResept");
        testId(reseptBlaa, 4);
        testPasientId(reseptBlaa, 14);
        testReit(reseptBlaa, 1);
        testBruk(reseptBlaa, true);
        testFarge(reseptBlaa, "blaa");
        testNyPris(reseptBlaa, 25);
    }
    
    //Sjekker om det er riktig reseptID
    public static void testId(Resept resept, int forventetId) {
        if (resept.hentId() == forventetId) {
            System.out.println("Riktig reseptID");
        }
        else {
            System.out.println("Feil reseptID");
        }
    }

    //Sjekker om det er riktig pasientID
    public static void testPasientId(Resept resept, int forventetId) {
        if (resept.hentPasientId() == forventetId) {
            System.out.println("Riktig pasientID");
        }
        else {
            System.out.println("Feil pasientID");
        }
    }

    //Sjekker om det er riktig antall reit
    public static void testReit(Resept resept, int forventetReit) {
        if (resept.hentReit() == forventetReit) {
            System.out.println("Riktig antall reit");
        }
        else {
            System.out.println("Feil antall reit");
        }
    }

    //Sjekker om metoden bruk fungerer
    public static void testBruk(Resept resept, boolean forventetReit) {
        if (resept.bruk() == forventetReit) {
            System.out.println("Riktig ny reit");
        }
        else {
            System.out.println("Feil ny reit");
        }
    }

    //Sjekker om metoden farge fungerer
    public static void testFarge(Resept resept, String forventetFarge) {
        if (resept.farge() == forventetFarge) {
            System.out.println("Riktig farge");
        }
        else {
            System.out.println("Feil farge");
        }
    }

    //Sjekker om metoden prisAaBetale fungerer
    public static void testNyPris(Resept resept, int forventetPris) {
        if (resept.prisAaBetale() == forventetPris) {
            System.out.println("Riktig ny-pris");
        }
        else {
            System.out.println("Feil ny-pris");
        }
    }

    


    
}
