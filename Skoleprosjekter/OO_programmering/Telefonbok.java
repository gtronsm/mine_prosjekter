import java.util.HashMap;
import java.util.Scanner;

public class Telefonbok {
    public static void main(String[] args) {

        HashMap<String, String> telefonbok = new HashMap<>();

        telefonbok.put("Arne", "22334455");
        telefonbok.put("Lisa", "11223344");
        telefonbok.put("Jonas", "99887766");
        telefonbok.put("Peder", "33445566");

        Scanner in = new Scanner(System.in);

        int input = 0;
        while(input != 1) {
            System.out.println("Meny: \n0: Soek etter person\n1: Avslutt");
            
            input = Integer.parseInt(in.nextLine());

            if (input == 0) {
                System.out.println("Hvem vil du ha nummeret til?");

                String navn = in.nextLine();

                if (telefonbok.containsKey(navn)) {
                    String tlf = telefonbok.get(navn);
                    System.out.println("Navn: " + navn + ", tlf: " + tlf);
                }
                else {
                    System.out.println("Fant ikke " + navn + ".");
                }
            }
        }

        System.out.println("Oversikt:");
        for (String navnekey : telefonbok.keySet()) {
            System.out.println("Navn: " + navnekey + ", tlf: " + telefonbok.get(navnekey));
        }
    }
}