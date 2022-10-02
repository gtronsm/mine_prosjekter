class IndeksertListe<T> extends Lenkeliste<T>{

    public void leggTil(int pos, T x) {
        if ((0 > pos) || (pos > stoerrelse())) {
            throw new UgyldigListeindeks(pos);
        }
        
        Node nyNode = new Node(x);
        if (pos == 0) {
            nyNode.neste = start;
            start = nyNode;
        }

        else {
            int teller = 0;
            Node peker = start;
            while (teller < (pos-1)) {
                peker = peker.neste;
                teller ++;
            }
            nyNode.neste = peker.neste;
            peker.neste = nyNode;
        } 
    }
  
    public void sett(int pos, T x) {
        if ((0 > pos) || (pos >= stoerrelse())) {
            throw new UgyldigListeindeks(pos);
        }

        Node nyNode = new Node(x);

        if (pos == 0) {
            nyNode.neste = start.neste;
            start = nyNode;
        }

        else {
            int teller = 0;
            Node peker = start;
            while (teller < (pos-1)) {
                peker = peker.neste;
                teller ++;
            }
        
            nyNode.neste = peker.neste.neste;
            peker.neste = nyNode;
        }
    }


    public T hent(int pos) {
        if ((0 > pos) || (pos >= stoerrelse())) {
            throw new UgyldigListeindeks(pos);
        }

        int teller = 0;
        Node peker = start;
        while (teller < (pos)) {
            peker = peker.neste;
            teller ++;
        }

        return peker.data;
    }

    
    public T fjern(int pos) {
        if ((0 > pos) || (pos >= stoerrelse())) {
            throw new UgyldigListeindeks(pos);
        }

        T data;

        if (pos == 0) {
            data = start.data;
            start = start.neste;
        }

        else {
            int teller = 0;
            Node peker = start;
            while (teller < (pos-1)) {
                peker = peker.neste;
                teller ++;
            }

            data = peker.neste.data;
            peker.neste = peker.neste.neste;
        }

        return data;
    }
}
