import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Day6 {

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

            List<Integer> timeList = new ArrayList<Integer>();
            List<Integer> distList = new ArrayList<Integer>();
            boolean dist = false;
            while (inputScan.hasNextLine()) {
                String curLine = inputScan.nextLine();
                //System.out.println(curLine);
                String[] lineSplit = curLine.split(":");
                
                String[] nums = lineSplit[1].trim().split(" ");
                for (int i = 0; i < nums.length; i++) {
                    if (!nums[i].equals("")) {
                        if (dist) {
                            distList.add(Integer.parseInt(nums[i].trim()));
                        }
                        else {
                            timeList.add(Integer.parseInt(nums[i].trim()));
                        } 
                    }
                       
                }
                dist = true;              
            }

            System.out.println(timeList);
            System.out.println(distList);

            int total = 1;
            for (int i = 0; i < timeList.size(); i++) {
                int[] timeRange = IntStream.rangeClosed(1, timeList.get(i)).toArray();
                int count = 0;
                for (int time : timeRange) {
                    if (finishRace(time,timeList.get(i) - time, distList.get(i))) {
                        count++;
                    }
                }
                total *= count;
                System.out.println("Count: " + count + " NewTotal: " + total);
            }

            System.out.println("Total: " + total);

            /* 
            System.out.println("1,6,9: " + finishRace(1,6,9));
            System.out.println("2,5,9: " + finishRace(2,5,9));
            System.out.println("3,4,9: " + finishRace(3,4,9));
            System.out.println("4,3,9: " + finishRace(4,3,9));
            System.out.println("5,2,9: " + finishRace(5,2,9));
            System.out.println("6,1,9: " + finishRace(6,1,9));
            System.out.println("10,20,200: " + finishRace(10,20,200));
            System.out.println("11,19,200: " + finishRace(11,19,200));
            System.out.println("11,19,200: " + finishRace(11,19,200));
            */
            




        }
        catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }

    private static boolean finishRace(int speed, int time, int dist) {
        int traveled = speed * time;
        if (traveled > dist) {
            return true;
        }
        return false;
    }


}
