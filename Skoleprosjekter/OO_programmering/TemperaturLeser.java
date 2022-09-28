import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class TemperaturLeser {
    public static void main(String[] args)
    throws FileNotFoundException {
        int antallPlasser = 12;
            
        String[] temperaturer = new String[antallPlasser];
    
        File minFil = new File("temperaturer.txt"); 
        Scanner scanner = new Scanner(minFil); 
        
        int teller = 0;
    
        while (scanner.hasNextLine()) {
				temperaturer[teller] = scanner.nextLine();
			    teller++;
            }
        for (int i = 0; i < temperaturer.length; i++) {
            System.out.println(temperaturer[i]);
        }
        scanner.close();
    }
}