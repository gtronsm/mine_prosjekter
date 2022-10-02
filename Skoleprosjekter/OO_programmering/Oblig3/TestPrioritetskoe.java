class TestPrioritetskoe {
    private static void info (int nr, String tekst) {
	System.out.print("Test " + nr + " " + tekst + " ... ");
    }
    
    private static boolean test (int nr, String tekst, Prioritetskoe<String> k, String[] fasit) {
	info(nr, tekst);
	int fLen = fasit.length;
	int kLen = k.stoerrelse();
	if (kLen != fLen) {
	    p("stoerrelse() gir " + kLen + " og ikke " + fLen);
	    return false;
	}
	
	for (int i = 0;  i < fLen;  ++i) {
	    String fElem = fasit[i];
	    String kElem = k.fjern();
	    if (kElem == null) {
		p("fjern() gir null for element nr " + i);
		return false;
	    }
	    if (! fElem.equals(kElem)) {
		p("fjern() for element nr " + i + " gir \"" + kElem +
		  "\" og ikke \"" + fElem + "\"");
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

    private static void p (String s) {
	System.out.println(s);
    }

    public static void main (String[] arg) {
	int antOK = 0, antFeil = 0;

	// Test 1
	Prioritetskoe<String> k = new Prioritetskoe<>();
	String[] f = new String[] {};
	if (test(1, "Tom Prioritetskoe", k, f)) {
	    p("OK");  ++antOK;
	} else {
	    ++antFeil;
	}

	// Test 2
	k = new Prioritetskoe<>();
	k.leggTil("Anne");  k.leggTil("Berit");  k.leggTil("Chris");
	f = new String[] {"Anne", "Berit", "Chris"};
	if (test(2, "Prioritetskoe med 3 elementer", k, f)) {
	    p("OK");  ++antOK;
	} else {
	    ++antFeil;
	}

	// Test 3
	k = new Prioritetskoe<>();
	k.leggTil("B");  k.leggTil("D");  k.leggTil("C");  k.leggTil("A");
	k.leggTil("Z");  k.leggTil("X");
	k.fjern();
	String h1 = k.hent();
	info(3, "Bruk av hent()");
	if (h1.equals("B")) {
	    p("OK");  ++antOK;
	} else {
	    p("hent() fra {\"B\", \"C\", \"D\", \"X\", \"Z\"} ga \"" + h1 + 
	      "\" og ikke \"B\"");
	    ++antFeil;
	}
	    
	// Test 4
	k = new Prioritetskoe<>();
	k.leggTil("Z");  k.leggTil("Y");
	k.fjern();  k.fjern();
	k.leggTil("W");  k.leggTil("V");  k.leggTil("X");  k.leggTil("U");
	if (test(4, "Innsetting og fjerning", k, new String[] {"U", "V", "W", "X"})) {
	    p("OK");  ++antOK;
	} else {
	    ++antFeil;
	}

	// Test 5
	k = new Prioritetskoe<>();
	k.leggTil("Noe");  k.fjern();
	info(5, "Fjerning fra tom liste");
	try {
	    k.fjern();
	    p("Feilen ble ikke oppdaget");
	    ++antFeil;
	} catch (UgyldigListeindeks e) {
	    p("OK");  ++antOK;
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
