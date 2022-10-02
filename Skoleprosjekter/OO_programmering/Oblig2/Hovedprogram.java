class Hovedprogram {

    //Integrasjonstest
    public static void main(String[] args) {
        Lege tronsmoen = new Lege("Tronsmoen");
        Lege normann = new Spesialist("Normann", "1234");

        Legemiddel imovane = new Vanedannende("Imovane", 300, 10, 10);
        Legemiddel morfin = new Narkotisk("Morfin", 250, 10, 10);
        Legemiddel paracet = new Vanlig("Paracet", 99, 1000);

        Resept reseptBlaa = new BlaResept (morfin, normann, 14, 1);
        Resept reseptHvit = new HvitResept (paracet, tronsmoen, 5, 0);
        Resept reseptMil = new MilResept (imovane, normann, 8);
        Resept reseptPrevansjon = new PResept (paracet, tronsmoen, 10, 2);

        System.out.println(reseptBlaa);
        System.out.println(reseptHvit);
        System.out.println(reseptMil);
        System.out.println(reseptPrevansjon);

        //Test for aa sjekke at lege uten spesialist blir stoppet ved narkotisk resept
        Resept reseptBlaa2 = new BlaResept (morfin, tronsmoen, 14, 1);
    }

}
