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
                
                if (amt >= 100) {
                    int quotient = amt / 100;
                    //int remainder = amt % 100;
                    amt %= 100;
                    zeroCnt += quotient;
                }

                if (direction.equals("R")) {
                    dialPtr += amt;
                    if (dialPtr >= 100) {
                        zeroCnt++;
                        dialPtr %= 100;
                    }
                }
                else if (direction.equals("L")) {
                    if (amt >= dialPtr) {
                        if (dialPtr != 0) {
                            zeroCnt++;
                        }
                        dialPtr = 100 + (dialPtr - amt);
                        dialPtr %= 100;
                    }
                    else {
                        dialPtr -= amt;
                    }
                }

                System.out.println("Dial aft: " + dialPtr);
                System.out.println("Zeros: " + zeroCnt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
