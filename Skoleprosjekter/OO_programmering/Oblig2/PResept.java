class PResept extends HvitResept {

    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    //Tar inn legemiddelets pris og legger inn rabatten
    @Override
    public int prisAaBetale() {
        int pris = legemiddel.hentPris();
        int rabatt = 108;
        int nyPris = pris - rabatt;

        if (nyPris <= 0) {
            nyPris = 0;
        }
        return nyPris;
    }
    
}
