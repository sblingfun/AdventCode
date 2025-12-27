import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Day3Test {
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
                
                chargeSum += getLargestCombination(line, 12); 
                
            }

            System.out.println("Charge Sum: " + chargeSum);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long getLargestCombination(String batteries, int count) {
        StringBuilder result = new StringBuilder();
        int startIndex = 0;

        for (int remaining = count; remaining > 0; remaining--) {
            int endIndex = batteries.length() - remaining;
            char maxDigit = '0';
            int maxIndex = startIndex;

            for (int i = startIndex; i <= endIndex; i++) {
                if (batteries.charAt(i) > maxDigit) {
                    maxDigit = batteries.charAt(i);
                    maxIndex = i;
                }
            }

            result.append(maxDigit);
            startIndex = maxIndex + 1;
        }

        return Long.parseLong(result.toString());
    }
}
