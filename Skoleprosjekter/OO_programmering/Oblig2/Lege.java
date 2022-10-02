public class Lege {
    
    protected String navn;

    public Lege(String navn) {
        this.navn = navn;
    }

    public String hentLege() {
        return navn;
    }

    public String toString() {
        return ("Utskrivende lege: " + navn);
    }
    
}
