abstract class Legemiddel {
    /*Lager en static teller for aa holde rede paa objektene som opprettes, 
    og koble denne til id for at alle faar sin unike ID*/
    static int idTeller = 1;

    protected String navn;
    protected int pris;
    protected double virkestoff;
    private int legemiddelId;

    public Legemiddel(String navn, int pris, double virkestoff) {
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        legemiddelId = idTeller;
        idTeller++;
    }

    public int hentId() {
        return legemiddelId;
    }

    public String hentNavn() {
        return navn;
    }

    public int hentPris() {
        return pris;
    }

    public double hentVirkestoff() {
        return virkestoff;
    }

    public void settNyPris(int nyPris) {
        pris = nyPris;
    }

    public String toString() {
        return ("Legemiddel: " + navn + "\nPris: " + pris + "kr. Virkestoff: " + virkestoff + " mg. ");
    }
}