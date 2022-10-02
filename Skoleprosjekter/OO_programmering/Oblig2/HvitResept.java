class HvitResept extends Resept {

    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }  

    @Override
    public String farge() {
        String farge = "hvit";
        return farge;
    }
    
    @Override
    public int prisAaBetale() {
        int fullPris = legemiddel.hentPris();
        return fullPris;
    }

}