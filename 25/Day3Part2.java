import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Day3Part2 {
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
                
                Comparator<List<Integer>> listFirstComparator = Comparator.comparingInt((List<Integer> list) -> list.get(0)).thenComparingInt(list -> list.get(1));
                Comparator<List<Integer>> listSecondComparator = Comparator.comparingInt(list -> list.get(1));
                PriorityQueue<List<Integer>> maxDigits = new PriorityQueue<List<Integer>>(listFirstComparator);
                 
                boolean maxFound = false;
                for (int i = 0; i < line.length() - 12; i++) {
                    int tempInt = line.charAt(i) - '0';
                    if (tempInt == 9) {
                        maxDigits.clear();
                        maxDigits.add(new ArrayList<Integer>(Arrays.asList(line.charAt(i) - '0', i)));
                        maxFound = true;
                        break;                    
                    }
                    if (maxDigits.size() >= 12) {
                        if ( maxDigits.peek().get(0) < tempInt) {
                            maxDigits.poll();
                            maxDigits.add(new ArrayList<Integer>(Arrays.asList(line.charAt(i) - '0', i)));
                        }
                    }
                    else {
                        maxDigits.add(new ArrayList<Integer>(Arrays.asList(line.charAt(i) - '0', i)));
                    }
                    //System.out.println("Findin max first");
                    System.out.println(maxDigits);
                }
                int maxValue = 0;
                int maxIdx = 0;

                if (!maxFound) {
                    for (List<Integer> maxDigit : maxDigits) {
                        if (maxDigit.get(0) > maxValue) {
                            maxValue = maxDigit.get(0);
                            maxIdx = maxDigit.get(1);
                        }
                        else if (maxDigit.get(0) == maxValue && maxDigit.get(1) < maxIdx) {
                            maxIdx = maxDigit.get(1);
                        }
                        
                    }
                    maxDigits.clear();
                    maxDigits.add(new ArrayList<Integer>(Arrays.asList(maxValue, maxIdx))); //repeating work here, could keep max values if index comes after max idx
                }
                
                int foundVals = 1;
                maxValue = line.charAt(maxIdx + 1) - '0';
                maxIdx = maxIdx + 1;
                for (int i = maxIdx; i < line.length(); i++) {
                    if (line.charAt(i) - '0' > maxValue && line.length() - i < 12) {
                        maxValue = line.charAt(i);
                        foundVals = 1;
                        while (maxDigits.size() > foundVals) {
                            maxDigits.poll();
                        }
                    }
                    if (maxDigits.size() >= 12) {
                        if ( maxDigits.peek().get(0) < line.charAt(i) - '0') {
                            maxDigits.poll();
                            maxDigits.add(new ArrayList<Integer>(Arrays.asList(line.charAt(i) - '0', i)));
                        }
                    }
                    else {
                        maxDigits.add(new ArrayList<Integer>(Arrays.asList(line.charAt(i) - '0', i)));
                        
                    }
                    System.out.println("i: "+ i);
                    System.out.println(maxDigits);
                }

                List<List<Integer>> maxDigitsList = new ArrayList<List<Integer>>(maxDigits);
                //ArrayList<Integer>[] maxDigitsArray = maxDigits.toArray(new ArrayList<Integer>[12]);
                
                System.out.println("Before:");
                System.out.println(maxDigitsList);
                Collections.sort(maxDigitsList, listSecondComparator);
                System.out.println("After");
                System.out.println(maxDigitsList);
                //List<Integer> maxList = new ArrayList<Integer>();
                String maxString = new String();
                for (int i = 0; i < maxDigitsList.size(); i++) {
                    //maxList.add(maxDigitsList.get(i).get(0));
                    maxString = maxString.concat(String.valueOf(maxDigitsList.get(i).get(0)));
                }
                System.out.println("maxString: " + maxString);
                long maxLineVal = Long.parseLong(maxString);
                if (maxLineVal != getLargestCombination(line, 12)) {
                    System.err.println("Got: " + maxLineVal);
                    System.err.println("Not: " + getLargestCombination(line, 12));
                }
                chargeSum += maxLineVal;
                //System.out.println(maxDigitsList);
                //System.out.println(maxList);
                

                //System.out.println(maxDigits);
                       
                                
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

