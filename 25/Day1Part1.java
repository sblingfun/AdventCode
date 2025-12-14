import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;


public class Day1Part1 {
    public static void main(String[] args) {
        
        String pathName = "day1main.txt";
        if (args.length > 0) {
            if (args[0].equals("ex")) pathName = "day1example.txt";

            else {
                pathName = "day1main.txt";
            }
        }

        Path filePath = Paths.get(pathName);

        try {
            BufferedReader reader = Files.newBufferedReader(filePath);
            String line;
            
            int dialPtr = 50;
            int zeroCnt = 0;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String direction = line.substring(0, 1);
                //System.out.println(direction);
                String amount = line.substring(1);
                //System.out.println(amount);
                int amt = Integer.parseInt(amount);
                
                System.out.println("Dial: " + dialPtr);
                
                amt %= 100;
                if (direction.equals("R") ) {
                    dialPtr += amt;
                    dialPtr %= 100;
                } 
                else if (direction.equals("L")) {
                    if (dialPtr > amt) {
                        dialPtr -= amt;
                    }
                    else if (dialPtr == amt) {
                        dialPtr = 0;
                    }
                    else {
                        dialPtr = 100 + (dialPtr - amt);
                    }
                }
                if (dialPtr == 0) zeroCnt++;

                
                System.out.println("Dial after: " + dialPtr);

            }

            System.out.println("Zero Count: " + zeroCnt);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
