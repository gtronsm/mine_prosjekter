class MilResept extends HvitResept {

    // Konstruktoren tar ikke inn reit, og setter i stedet inn 3 som en fast reit for alle MilResept som opprettes
    public MilResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId) {
        super(legemiddel, utskrivendeLege, pasientId, 3);
    }

    //Tar inn legemiddelets pris og legger inn rabatten
    @Override
    public int prisAaBetale() {
        double pris = legemiddel.hentPris();
        double rabatt = 1.0;
        pris = pris - (pris*rabatt);
        int nyPris = (int) pris;
        
        return nyPris;
    }

}
