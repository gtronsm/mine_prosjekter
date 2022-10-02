abstract class Resept {
    static int idTeller = 1;

    protected Legemiddel legemiddel;
    protected Lege utskrivendeLege;
    protected int pasientId;
    protected int reit;
    private int reseptId;

    
    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        //Faar konstruktoren til aa sjekke om legemiddelet er narkotisk og om legen har lov, hvis ikke stopper programmet og gir en beskjed.
        if (legemiddel instanceof Narkotisk) {
            if (!(utskrivendeLege instanceof Spesialist)) {
                throw new IllegalArgumentException("Lege uten spesialisering kan ikke skrive ut resept paa narkotisk legemiddel.");
            }
        }
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;
        reseptId = idTeller;
        idTeller++;
    }

    public int hentId() {
        return reseptId;
    }
    
    public Legemiddel hentLegemiddel() {
        return legemiddel;
    } 
    
    public Lege hentLege() {
        return utskrivendeLege;
    }
    
    public int hentPasientId() {
        return pasientId;
    }
    
    public int hentReit() {
        return reit;
    }

    public boolean bruk() {
        Boolean reitIgjen = true;
        if (reit >= 1) {
            reit--;
        }
        else {
            reitIgjen = false; 
        }
        return reitIgjen;
    }
    
    abstract public String farge();

    abstract public int prisAaBetale();

    public String toString() {
        return (legemiddel.toString() + "\n" + utskrivendeLege.toString() + 
                "\nPasientID: " + pasientId + ". Antall reit igjen: " + reit +
                ". Type resept: " + farge() + "\n\nDin pris: " + prisAaBetale() + " kr\n");
    }
    
}
