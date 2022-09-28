public class Traad implements Runnable{

    Bank b;
    int ut;
    int inn;
    int belop;

    public Traad(Bank b, int belop) {
        this.b = b;
        this.belop = belop;
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i<5; i++) {
                if (belop <= b.saldo()) {
                    ut = b.taUt();
                    inn = ut;
                    b.gi(inn);
                }
            }

            System.out.println(b.saldo());
        }
        catch (InterruptedException e) {
            System.out.println("Avbrytt");
        }
    }
    
}