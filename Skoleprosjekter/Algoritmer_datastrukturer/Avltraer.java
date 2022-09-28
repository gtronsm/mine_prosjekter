
//Henter metoder fra BinaereTraer.java

public class AvlTraer {

    public static void main(String[] args) {




    }

    //Hoyden til et tre er gitt av den hoyeste avstanden til en etterkommer, dvs dybden av den dypeste lovnoden
    public static int height(Node n) {
        int hoyde = -1;
        
        if (n == null) {
            return hoyde;
        }

        return hoyde;
    }

    private static class Node {
        Node left;
        Node right;
        Node parent;
        int element;
        int height;

        public Node(int element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }
    }
}