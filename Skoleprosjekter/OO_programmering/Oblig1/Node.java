class Node {
    private int minne;
    private int antPros;

    public Node(int minne, int antPros) {
        this.minne = minne;
        this.antPros = antPros;
    }

    public int antProsessorer() {
        return antPros;
    }    

    public boolean nokMinne(int paakrevdMinne) {
        boolean nokMinne = true;
        if (minne < paakrevdMinne) {
            nokMinne = false;
        }
        return nokMinne;
    }
}