class Rack {

	//Lager array med referanse til node-objekter
    private Node[] nodeliste;
    private static int antallPlasser = 12;

    public Rack() {
        nodeliste = new Node[antallPlasser];
    }

	//Sjekker om det er ledig plass i rack, og setter eventuelt inn node.
    public boolean settInn(Node enNode) {
		int i = 0;
		while (i < antallPlasser) {
			if (nodeliste[i] == null) {
				nodeliste[i] = enNode;
				return true;
			}
			i++;
		}
		return false;
    }

	public int antProsessorer() {
		int antPros = 0;
		for (Node n : nodeliste) {
			if (n != null) {
				antPros += n.antProsessorer();
			}
		}
		return antPros;
	}

	public int noderMedNokMinne(int paakrevdMinne) {
		int nodeTilstrekkeligMinne = 0;
		for (Node n : nodeliste) {
			if (n != null){
				if (n.nokMinne(paakrevdMinne)) {
					nodeTilstrekkeligMinne += 1;
				}
			}
		}
		return nodeTilstrekkeligMinne;
	}
}