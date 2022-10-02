abstract class Lenkeliste<T> implements Liste<T> {

    public Lenkeliste() {
    }

    class Node {
        Node neste = null;
        T data;
        
        Node (T data) {
            this.data = data;
        }

        public T hentData() {
            return data;
        }
    }

    //Oppretter et node-objekt
    Node start = null;

    //Metoden returnerer hvor mange elementer det er i listen.
    public int stoerrelse() {
        
        int teller = 0;
        Node peker = start;
        while (peker != null) {
            teller ++;
            peker = peker.neste;
        }
        
        return teller;
    }

    //Metoden legger inn et nytt element sist i listen.
    public void leggTil(T x) {
        Node nyNode = new Node(x);
        Node peker = start;

        if (start == null) {
            start = nyNode;
        }
        else {
            while (peker.neste != null) {
                peker = peker.neste;
            }
            peker.neste = nyNode;
        }     
    }

    //Metoden returnerer det forste elementet i listen
    public T hent() {
        T data = null;
        try {
            data = start.hentData(); 
        }
        catch (Exception e) {
            throw new UgyldigListeindeks(stoerrelse());
        }

        return data;
    }

    //Metoden fjerner det forste elementet i listen og returnerer det.
    public T fjern() {
        T res = hent();
        start = start.neste; 
        
        return res;
    }


    public String toString() {
        String tekst = "";
        Node peker = start;
        while (peker != null) {
            tekst += peker.hentData().toString();
            peker = peker.neste;
        }

        return tekst;
    }
}
