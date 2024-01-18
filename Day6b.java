import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Day6b {

    public static void main(String[] args) {
        try {
            String curDir = Path.of("").toAbsolutePath().toString();

            if (args.length > 0 && args[0].equalsIgnoreCase("test")) {
                curDir = curDir.concat("\\day6InputTEST.txt");
            }
            else {
                curDir = curDir.concat("\\day6Input.txt");
            }

            File inputFile = new File(curDir);

            Scanner inputScan = new Scanner(inputFile);

            List<String> timeList = new ArrayList<String>();
            List<String> distList = new ArrayList<String>();
            boolean dist = false;
            while (inputScan.hasNextLine()) {
                String curLine = inputScan.nextLine();
                //System.out.println(curLine);
                String[] lineSplit = curLine.split(":");
                
                String[] nums = lineSplit[1].trim().split(" ");
                for (int i = 0; i < nums.length; i++) {
                    if (!nums[i].equals("")) {
                        if (dist) {
                            distList.add(nums[i].trim());
                        }
                        else {
                            timeList.add(nums[i].trim());
                        } 
                    }
                       
                }
                dist = true;              
            }

            String combinedTimeString = "";
            for (String time : timeList) {
                combinedTimeString = combinedTimeString.concat(time);
            }
            long time = Long.parseLong(combinedTimeString);
            String combinedDistanceString = "";
            for (String distance : distList) {
                combinedDistanceString = combinedDistanceString.concat(distance);
            }
            long distNum = Long.parseLong(combinedDistanceString);

            long start = 0;
            for (long i = 1; i < time; i++) {
                if (finishRace(i, time - i ,distNum)) {
                    start = i;
                    break;
                }
            }
            long end = 0;
            for (long i = time - 1; i > 0; i--) {
                if (finishRace(i, time - i ,distNum)) {
                    end = i;
                    break;
                }
            }
            System.out.println(end - start + 1);
        }
        catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }

    private static boolean finishRace(long speed, long time, long dist) {
        long traveled = speed * time;
        if (traveled > dist) {
            return true;
        }
        return false;
    }


}
