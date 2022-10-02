class TestIndeksertListe {
    private static void info (int nr, String tekst) {
	System.out.print("Test " + nr + " " + tekst + " ... ");
    }
    
    private static void p (String s) {
	System.out.println(s);
    }

    private static boolean test (int nr, String tekst, 
				 IndeksertListe<Integer> k, int[] fasit) {
	info(nr, tekst);
	int fLen = fasit.length;
	int kLen = k.stoerrelse();
	if (kLen != fLen) {
	    p("stoerrelse() gir " + kLen + " og ikke " + fLen);
	    return false;
	}
	
	for (int i = 0;  i < fLen;  ++i) {
	    int fElem = fasit[i];
	    Integer kElem = k.fjern();
	    if (kElem == null) {
		p("fjern() gir null for element nr " + i);
		return false;
	    }
	    if (fElem != kElem) {
		p("fjern() for element nr " + i + " gir " + kElem +
		  " og ikke " + fElem);
		return false;
	    }
	}

	kLen = k.stoerrelse();
	if (kLen != 0) {
	    p("stoerrelse() etter fjerning gir " + kLen + " og ikke 0");
	    return false;
	}
	return true;
    }

    public static void main (String[] arg) {
	int antOK = 0, antFeil = 0;

	// Test 1
	IndeksertListe<Integer> k = new IndeksertListe<>();
	int[] f = new int[] {};
	if (test(1, "Tom IndeksertListe", k, f)) {
	    p("OK");  ++antOK;
	} else {
	    ++antFeil;
	}

	// Test 2
	k = new IndeksertListe<>();
	k.leggTil(0, 101);
	k.leggTil(102);
	k.leggTil(0, 103);
	k.leggTil(3, 104);
	k.leggTil(3, 105);
	f = new int[] { 103, 101, 102, 105, 104 };
	if (test(2, "IndeksertListe med 5 elementer", k, f)) {
	    p("OK");  ++antOK;
	} else {
	    ++antFeil;
	}

	// Test 3
	k = new IndeksertListe<>();
	k.leggTil(205);
	k.leggTil(0, 204);
	info(3, "Hente elementer");
	int kRes1 = k.hent(1), kRes2 = k.hent(0);
	if (kRes1 != 205) {
	    p("element nr 1 er " + kRes1 + " og ikke 205");
	    ++antFeil;
	} else if (kRes2 != 204) {
	    p("element nr 0 er " + kRes2 + " og ikke 204");
	    ++antFeil;
	} else {
	    p("OK");  ++antOK;
	}

	// Test 4
	k = new IndeksertListe<>();
	k.leggTil(0, 401);
	k.leggTil(0, 402);
	k.leggTil(2, 403);
	k.sett(1, -1);
	f = new int[]{ 402, -1, 403 };
	if (test(4, "Endre elementer", k, f)) {
	    p("OK");  ++antOK;
	} else {
	    ++antFeil;
	}

	// Test 5
	k = new IndeksertListe<>();
	k.leggTil(501);
	info(5, "Ulovlig indeksering");
	try {
	    k.sett(1, 502);
	    p("Ulovlig indeks ble ikke oppdaget");
	    ++antFeil;
	} catch (UgyldigListeindeks e) {
	    p("OK");  ++antOK;
	}

	// Test 6
	k = new IndeksertListe<>();
	k.leggTil(1001);
	info(6, "Ulovlig fjerning");
	try {
	    k.fjern(1);
	    p("Gal indeks ved fjerning ble ikke oppdaget");
	    ++antFeil;
	} catch (UgyldigListeindeks e) {
	    p("OK");  ++antOK;
	}

	// Test 7
	IndeksertListe<String> ks = new IndeksertListe<>();
	ks.leggTil("Alfa");
	ks.leggTil(1, "Omega");
	String ks1 = ks.fjern(1);
	String ks0 = ks.fjern();
	info(7, "Fjerne siste");
	if (! ks1.equals("Omega")) {
	    p("fjernet element er \"" + ks1 + "\" og ikke \"Omega\"");
	    ++antFeil;
	} else if (! ks0.equals("Alfa")) {
	    p("fjernet sisteelement er \"" + ks0 + "\" og ikke \"Alfa\"");
	    ++antFeil;
	} else if (ks.stoerrelse() != 0) {
	    p("listen skulle vaert tom men har " + ks.stoerrelse() + " elementer");
	    ++antFeil;
	} else {
	    p("OK");
	    ++antOK;
	}

	// Oppsummering
	if (antFeil == 0) {
	    p("Alt gikk bra!");
	} else {
	    p("I alt gikk " + antOK + " tester bra, men " + antFeil +
	      " inneholdt feil."); 
	}
    }
}
