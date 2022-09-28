
public class BinaereTraer {

    public static void main(String[] args) {

        Node enNode = new Node(4);

        //Et lite testprogram
        insert(enNode, 6);
        insert(enNode, 100);
        insert(enNode,15);
        insert(enNode, 45);

        int fjernElement = 45;
        remove(enNode, fjernElement);
        Node soek = search(enNode, fjernElement);

        assert soek == null : "Elementet har ikke blitt fjernet";
    }

    //Returnerer 0 dersom vi skal finne dybde paa roten
    public static int depth(Node n) {
        if (n == null) {
            return -1;
        }
        return 1 + depth(n.parent);
    }

    //Rotnode som argument
    //Returnerer oppdatert node som er etterkommer av rotnode
    //Denne algoritmen har kompleksitet O(n), men dersom balansert er det O(log(n)) 
    public static Node insert(Node n, int element) {
        if (n == null) {
            n = new Node(element);
        }
        else if (element < n.element) {
            n.left = insert(n.left, element);
        }

        else if (element > n.element) {
            n.right = insert(n.right, element);
        }
        return n;
    }
    
    //Returnerer noden som holder paa elementet
    //Samme kompleksitet som insert
    public static Node search(Node n, int element) {
        if (n == null) {
            return null;
        }
        if (element == n.element) {
            return n;
        }
        if (element < n.element) {
            return search(n.left, element);
        }
        if (element > n.element) {
            return search(n.right, element);
        }
        return null;
    }

    //Hjelpemetode til remove
    //Returnerer noden som inneholder minste etterkommeren av v
    public static Node finnMinste(Node n) {

        if (n == null) {
            return null;
        }
        if (n.left == null) {
            return n;
        }
        return finnMinste(n.left);
    }

    //Tar inn en rot/subrot
    public static Node remove(Node n, int element) {
        if (n == null) {
            return null;
        }
        if (element < n.element) {
            //Setter nodens venstrebarn til aa vaere ...
            n.left = remove(n.left, element);
            return n;
        }
        if (element > n.element) {
            n.right = remove(n.right, element);
            return n;
        }
        if (n.left == null) {
            return n.left;
        }
        if (n.right == null) {
            return n.right;
        }
        Node minste = finnMinste(n.right);
        n.element = minste.element;
        n.right = remove(n.right, minste.element);

        return n;
    }

    private static class Node {
        Node left;
        Node right;
        Node parent;
        int element;

        public Node(int element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }
    }
}