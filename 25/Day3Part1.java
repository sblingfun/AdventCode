import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Day3Part1 {
    public static void main(String[] args) {
        
        String pathName = "day3main.txt";
        if (args.length > 0) {
            if (args[0].equals("ex")) pathName = "day3example.txt";

            else {
                pathName = "day3main.txt";
            }
        }

        Path filePath = Paths.get(pathName);

        try {
            BufferedReader reader = Files.newBufferedReader(filePath);
            String line;

            long chargeSum = 0;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                
                
                int highestIdx = 0;
                int nextHighestIdx = 0;
                int highestVal = 0;
                int nextHighestVal = 0; 
                
                for (int i = 0; i < line.length(); i++) {
                    if ((line.charAt(i) - '0') > highestVal && i < line.length() - 1) {
                        highestVal = (line.charAt(i) - '0');
                        highestIdx = i;
                        nextHighestIdx = i;
                        nextHighestVal = 0;
                    }
                    else if ((line.charAt(i) - '0') > nextHighestVal && i > 0) {
                        nextHighestVal = (line.charAt(i) - '0'); 
                        nextHighestIdx = i;
                    }
                    if (highestVal == 9 && nextHighestVal == 9) {
                        break;
                    }                    
                }
                System.out.println("High: " + highestVal + " Next: " + nextHighestVal);
                String largeChargeStr = String.valueOf(highestVal).concat(String.valueOf(nextHighestVal));
                System.out.println("Adding: " + largeChargeStr);
                chargeSum += Integer.parseInt(largeChargeStr);
                
            }

            System.out.println("Charge Sum: " + chargeSum);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

