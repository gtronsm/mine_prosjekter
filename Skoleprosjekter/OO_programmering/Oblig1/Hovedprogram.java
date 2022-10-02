import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Hovedprogram {

    public static void main(String[] args)
    throws FileNotFoundException {
        
        Dataklynge dataklynge = new Dataklynge();

        File minFil = new File("dataklynge.txt"); 
        Scanner scanner = new Scanner(minFil); 
        int antNoder, antPros, minne;


        //Leser gjennom filen saa lenge det er en neste linje.
        while (scanner.hasNextLine()) {
            String[] biter = scanner.nextLine().split(" ");
            antNoder = Integer.parseInt(biter[0]);
            antPros = Integer.parseInt(biter[1]);
            minne = Integer.parseInt(biter[2]);


            //Sjekker om filen har gyldige tall. Programmet terminerer dersom ugyldige tall.
            if (antPros > 16) {
                System.out.println("Filen viser for mange prosessorer per node. Programmet avsluttes.");
                System.exit(0);
            }
            else if (minne > 4096) {
                System.out.println("Filen viser for mye minne per node. Programmet avsluttes.");
                System.exit(0);
            }


            
            for (int teller = 0; teller < antNoder; teller ++) {
                Node node = new Node(minne, antPros);
                dataklynge.settInnNode(node);
            }
        }
        scanner.close();
        
        System.out.println(
            "Noder med minst 128 GB: " + dataklynge.noderMedNokMinne(128) +
            "\nNoder med minst 512 GB: " + dataklynge.noderMedNokMinne(512) +
            "\nNoder med minst 1024 GB: " + dataklynge.noderMedNokMinne(1024) + "\n" +
            "\nAntall prosessorer i dataklynge: " + dataklynge.antProsessorer() +
            "\nAntall racks i dataklynge: " + dataklynge.antRack()
        );
    }      
}