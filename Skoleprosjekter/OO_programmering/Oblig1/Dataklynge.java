import java.util.ArrayList;

class Dataklynge {

	//Tom arrayliste opprettes ved ny Dataklynge, og denne skal referere til ulike Rack-objekter
	private ArrayList<Rack> rackliste;

    public Dataklynge() {
        rackliste = new ArrayList<Rack>();
    }
	
	//Dersom settInn i rack-klassen ikke returnerer true, lages nytt rack og noden settes inn i dette.
    public void settInnNode(Node enNode) {
        for (Rack r : rackliste) {
            if (r.settInn(enNode)) {
				return;
			}
		}
		lageRack().settInn(enNode);
    }

	//Hjelpemetode for aa lage nye rack
	private Rack lageRack() {
		Rack rack = new Rack();
		rackliste.add(rack);
		return rack;
	}

	public int antRack() {
		return rackliste.size();
	}

    public int antProsessorer() {
		int antProsessorer = 0;
		for (Rack r : rackliste) {
			antProsessorer += r.antProsessorer();
		}
        return antProsessorer;
    }

    public int noderMedNokMinne(int paakrevdMinne) {
		int nodeTilstrekkeligMinne = 0;
		for (Rack r : rackliste) {
			nodeTilstrekkeligMinne += r.noderMedNokMinne(paakrevdMinne);
		}
		return nodeTilstrekkeligMinne;
    }
}