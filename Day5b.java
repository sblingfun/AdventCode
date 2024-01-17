import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day5b {
    
    public static void main(String[] args) {
        try {
            String workDir = Path.of("").toAbsolutePath().toString();
            if (args.length > 0 && args[0].equalsIgnoreCase("test")) {
                workDir = workDir.concat("\\Day5InputTEST.txt");
            }
            else {
                workDir = workDir.concat("\\Day5Input.txt");
            }

            File fileInput = new File(workDir);
            Scanner fileScan = new Scanner(fileInput);

            List<Long> seedRange = new ArrayList<Long>();
            List<List<Long>> seedToSoil = new ArrayList<List<Long>>();
            List<List<Long>> soilToFert = new ArrayList<List<Long>>();
            List<List<Long>> fertToWat = new ArrayList<List<Long>>();
            List<List<Long>> watToLight = new ArrayList<List<Long>>();
            List<List<Long>> lightToTemp = new ArrayList<List<Long>>();
            List<List<Long>> tempToHum = new ArrayList<List<Long>>();
            List<List<Long>> humToLoc = new ArrayList<List<Long>>();
            while (fileScan.hasNextLine()) {
                String curLine = fileScan.nextLine();
                //System.out.println(curLine);
                
                if (curLine.contains("seeds")) {
                    String[] seedSplit = curLine.split(": ");
                    String[] seedNums = seedSplit[1].split(" ");
                    for (int i = 0; i < seedNums.length - 1;i += 2) {
                        if (i == 1) System.out.println(seedNums[1]);
                        seedRange.add(Long.parseLong(seedNums[i]));
                        seedRange.add(Long.parseLong(seedNums[i+1]) - 1);                        
                    }
                }
                else if (curLine.contains("map")) {
                    //List<Integer> curMap = new ArrayList<Integer>();
                    if (curLine.contains("seed-to-soil")) {
                        curLine = fileScan.nextLine();
                        while (!curLine.equals("")) {
                            String[] lineSplit = curLine.split(" ");
                            
                            long diff = Long.parseLong(lineSplit[1]) - Long.parseLong(lineSplit[0]);
                            long start = Long.parseLong(lineSplit[1]);
                            long end = Long.parseLong(lineSplit[1]) + Long.parseLong(lineSplit[2]) - 1;
                            
                            seedToSoil.add(List.of(start,end,diff));
                            curLine = fileScan.nextLine();
                        }
                        
                    }
                    else if (curLine.contains("soil-to-fertilizer")) {
                        curLine = fileScan.nextLine();
                        while (!curLine.equals("")) {
                            String[] lineSplit = curLine.split(" ");
                            
                            long diff = Long.parseLong(lineSplit[1]) - Long.parseLong(lineSplit[0]);
                            long start = Long.parseLong(lineSplit[1]);
                            long end = Long.parseLong(lineSplit[1]) + Long.parseLong(lineSplit[2]) - 1;
                            
                            soilToFert.add(List.of(start,end,diff));
                            curLine = fileScan.nextLine();
                        }
                    }
                    else if (curLine.contains("fertilizer-to-water")) {
                        curLine = fileScan.nextLine();
                        while (!curLine.equals("")) {
                            String[] lineSplit = curLine.split(" ");
                            
                            long diff = Long.parseLong(lineSplit[1]) - Long.parseLong(lineSplit[0]);
                            long start = Long.parseLong(lineSplit[1]);
                            long end = Long.parseLong(lineSplit[1]) + Long.parseLong(lineSplit[2]) - 1;
                            
                            fertToWat.add(List.of(start,end,diff));
                            curLine = fileScan.nextLine();
                        }
                    }
                    else if (curLine.contains("water-to-light")) {
                        curLine = fileScan.nextLine();
                        while (!curLine.equals("")) {
                            String[] lineSplit = curLine.split(" ");
                            
                            long diff = Long.parseLong(lineSplit[1]) - Long.parseLong(lineSplit[0]);
                            long start = Long.parseLong(lineSplit[1]);
                            long end = Long.parseLong(lineSplit[1]) + Long.parseLong(lineSplit[2]) - 1;
                            
                            watToLight.add(List.of(start,end,diff));
                            curLine = fileScan.nextLine();
                        }
                    }
                    else if (curLine.contains("light-to-temperature")) {
                        curLine = fileScan.nextLine();
                        while (!curLine.equals("")) {
                            String[] lineSplit = curLine.split(" ");
                            
                            long diff = Long.parseLong(lineSplit[1]) - Long.parseLong(lineSplit[0]);
                            long start = Long.parseLong(lineSplit[1]);
                            long end = Long.parseLong(lineSplit[1]) + Long.parseLong(lineSplit[2]) - 1;
                            
                            lightToTemp.add(List.of(start,end,diff));
                            curLine = fileScan.nextLine();
                        }
                    }
                    else if (curLine.contains("temperature-to-humidity")) {
                        curLine = fileScan.nextLine();
                        while (!curLine.equals("")) {
                            String[] lineSplit = curLine.split(" ");
                            
                            long diff = Long.parseLong(lineSplit[1]) - Long.parseLong(lineSplit[0]);
                            long start = Long.parseLong(lineSplit[1]);
                            long end = Long.parseLong(lineSplit[1]) + Long.parseLong(lineSplit[2]) - 1;
                            
                            tempToHum.add(List.of(start,end,diff));
                            curLine = fileScan.nextLine();
                        }
                    }
                    else if (curLine.contains("humidity-to-location")) {
                        curLine = fileScan.nextLine();
                        while (!curLine.equals("")) {
                            String[] lineSplit = curLine.split(" ");
                            
                            long diff = Long.parseLong(lineSplit[1]) - Long.parseLong(lineSplit[0]);
                            long start = Long.parseLong(lineSplit[1]);
                            long end = Long.parseLong(lineSplit[1]) + Long.parseLong(lineSplit[2]) - 1;
                            
                            humToLoc.add(List.of(start,end,diff));
                            //endoffile
                            if (fileScan.hasNextLine()) {
                                curLine = fileScan.nextLine();
                            }
                            else {
                                curLine = "";
                            }
                            
                        }
                    }
                    
                    
                }
                
            }
            fileScan.close();
            /* 
            System.out.println(seedToSoil);
            System.out.println(soilToFert);
            System.out.println(fertToWat);
            System.out.println(watToLight);
            System.out.println(lightToTemp);
            System.out.println(tempToHum);
            System.out.println(humToLoc);
            
            if (curLine.contains("seeds")) {
                String[] seedSplit = curLine.split(": ");
                String[] seedNums = seedSplit[1].split(" ");
                for (int i = 1; i < seedNums.length;i += 2) {
                    long start = Long.parseLong(seedNums[i]);
                    for (long j = 0; j < Long.parseLong(seedNums[i+1]) - 1; j++) {
                        seedList.add(start + j);
                    }
                    
                }
            }
            */
            long retVal = Long.MAX_VALUE;
            for (int j = 0; j < seedRange.size(); j += 2) {

                List<Long> seedList = new ArrayList<Long>();
                long start = seedRange.get(j);
                long range = seedRange.get(j+1);
                while (range > 0) {
                    seedList.clear();
                    seedList.add(start);
                    start++;
                    range--;
                


            
                //System.out.println(seedList);
                for ( int i = 0; i < seedList.size(); i++) {
                    //System.out.println("seed: " + seed + " " + getNewValue(seed, seedToSoil) + " " + getNewValue(getNewValue(seed, seedToSoil),soilToFert));
                    seedList.set(i, getNewValue(seedList.get(i), seedToSoil));                
                }
                //System.out.println(seedList);
                for ( int i = 0; i < seedList.size(); i++) {
                    seedList.set(i, getNewValue(seedList.get(i), soilToFert));                
                }
                //System.out.println(seedList);
                for ( int i = 0; i < seedList.size(); i++) {
                    seedList.set(i, getNewValue(seedList.get(i), fertToWat));                
                }
                //System.out.println(seedList);
                for ( int i = 0; i < seedList.size(); i++) {
                    seedList.set(i, getNewValue(seedList.get(i), watToLight));                
                }
                //System.out.println(seedList);
                for ( int i = 0; i < seedList.size(); i++) {
                    seedList.set(i, getNewValue(seedList.get(i), lightToTemp));                
                }
                //System.out.println(seedList);
                for ( int i = 0; i < seedList.size(); i++) {
                    seedList.set(i, getNewValue(seedList.get(i), tempToHum));                
                }
                //System.out.println(seedList);
                for ( int i = 0; i < seedList.size(); i++) {
                    seedList.set(i, getNewValue(seedList.get(i), humToLoc));                
                }
                //System.out.println(seedList);
                for (long finalLoc : seedList) {
                    retVal = Math.min(retVal,finalLoc);
                }
            }
            }

            
            

            System.out.println("Lowest Location: " + retVal);
            
        }
        catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }

    }

    private static long getNewValue(long toCheck, List<List<Long>> ruleSet) {
        for (List<Long> rule : ruleSet) {
            if (rule.get(0) <= toCheck && toCheck <= rule.get(1)) {
                return toCheck - rule.get(2);
            }
        }
        return toCheck;
    }
}
