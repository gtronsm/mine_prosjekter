public class Prioritetskoe<T extends Comparable<T>> extends Lenkeliste<T> {

    @Override
    public void leggTil(T x) {
        Node nyNode = new Node(x);
        
        if (stoerrelse() == 0) {
            start = nyNode;
        }
        
        else {
            Node peker = start;

            
            
            while ((peker.neste != null) && (x.compareTo(peker.neste.data) > 0)) {
                peker = peker.neste;
            }

            if (peker == start) {
                if (x.compareTo(peker.data) < 0) {
                    nyNode.neste = start;
                    start = nyNode;
                    return;
                }
            }

            nyNode.neste = peker.neste;
            peker.neste = nyNode;
        }
    }
}
