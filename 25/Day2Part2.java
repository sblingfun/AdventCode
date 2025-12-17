import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Day2Part2 {
    public static void main(String[] args) {
        
        String pathName = "day2main.txt";
        if (args.length > 0) {
            if (args[0].equals("ex")) pathName = "day2example.txt";

            else {
                pathName = "day2main.txt";
            }
        }

        Path filePath = Paths.get(pathName);

        try {
            BufferedReader reader = Files.newBufferedReader(filePath);
            String line;

            long resultSum = 0;
            ArrayList<String> rangeList = new ArrayList<String>();
            ArrayList<Long> invalidList = new ArrayList<Long>();

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                
                String[] rangeSplit = line.split(",");
                
                for (String s : rangeSplit) {
                    //System.out.println(s);
                
                    //String[] idSplit = s.split("-");
                    rangeList.add(s);
                }
            }
            
            for (String range : rangeList) {
                String[] idSplit = range.split("-");
                 
                Long startRng = Long.parseLong(idSplit[0]);
                Long endRng = Long.parseLong(idSplit[1]);
                System.out.println("checking " + startRng + " to " + endRng);
                
                while (startRng <= endRng) {
                    //System.out.println(startRng + " is " + isValid(startRng.toString()));
                    if (isValid(startRng.toString())) {
                        invalidList.add(startRng);
                    } 
                    startRng++;
                }
            }
            System.out.println("invalid list: " + invalidList);
            
            for (Long invalidId : invalidList) {
                resultSum += invalidId; 
            }

            System.out.println("Invalid Sum = " + resultSum);

            //isValid("2121212119");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isValid(String input) {
        boolean retVal = false;
        
        for (int i = 0; i < input.length(); i++) {
            if (! (input.charAt(i) == '0') ) {
                retVal = true;
                break;
            }
        }
        if (!retVal) return false;
        if (input.length() == 1) return false;
        else {
             
            List<Integer> factors = new ArrayList<Integer>();
            for (int i = 2; i < (input.length() / 2) + 1; i++) {
                if (input.length() % i == 0) {
                    factors.add(i);
                }
            }
            if (factors.size() == 0) factors.add(1);
            //System.out.println(factors);
            List<Integer> checkIdxs = new ArrayList<Integer>();
            for (Integer factor : factors) {
                checkIdxs.clear();
                int count = 0;
                while (count != input.length()) {
                    checkIdxs.add(count);
                    count += factor;
                }
                if (checkIdxs.size() > 0 ) {
                    for (int i = 0; i < checkIdxs.get(1); i++) {
                        if (i == 0) retVal = true;
                        for (Integer checkIdx : checkIdxs) {
                            if (checkIdx != 0) {
                                //System.out.println("checking i: " + i + " vs " + (checkIdx + i));
                                //System.out.println("char: " + input.charAt(i) + " " + input.charAt(checkIdx + i));
                                if (input.charAt(i) != input.charAt(checkIdx + i)) {
                                    retVal = false;
                                    break;
                                }
                                //else if (i == checkIdxs.get(1) - 1 && retVal) {
                                //    return true;
                                //}
                            }
                        }
                        if (i + 1 == checkIdxs.get(1) && retVal) { 
                            return true;
                        }
                    }
                }
            }
            
            
            //System.out.println(factors);

            //System.out.println(checkIdx);
            /*
            int start = 0;
            int middle = input.length() / 2;
            while (middle < input.length()) {
                //System.out.println("checking start: " + start + " " + input.charAt(start) + " middle: " + middle + " " + input.charAt(middle) );
                if (input.charAt(start) != input.charAt(middle)) {
                    retVal = false;
                    break;
                }
                else {
                    start++;
                    middle++;
                }
            }

            */
            for (int j = 1; j < input.length() - 1; j++) {
                if (input.charAt(j) != input.charAt(j + 1)) {
                    retVal = false;
                    break;
                }
            }
            return retVal;
        }
    }
}
