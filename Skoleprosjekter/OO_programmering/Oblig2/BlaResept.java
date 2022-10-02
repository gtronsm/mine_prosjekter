class BlaResept extends Resept {

    public BlaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    @Override
    public String farge() {
        String farge = "blaa";
        return farge;
    }

    //Tar inn legemiddelets pris og legger inn rabatten
    @Override
    public int prisAaBetale() {
        
        double pris = legemiddel.hentPris();
        double rabatt = 0.75;
        pris = pris - (pris*rabatt);

        int nyPris = (int) pris;
        
        return nyPris;
    }
}
