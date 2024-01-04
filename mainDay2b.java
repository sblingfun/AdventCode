import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class mainDay2b {
    
    public static void main(String[] args) {
        try {
            String workDir = System.getProperty("user.dir");
            if (((args == null) || (args. length == 0))) {
                workDir = workDir.concat("\\day2Input.txt");
            }
            else if (args[0].equals("test")) {
                workDir = workDir.concat("\\day2InputTEST.txt");
            }

            File inputFile = new File(workDir);
            Scanner scan = new Scanner(inputFile);

            int totalSum = 0;

            int gameNum = 0;
            int minCube = 0;

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                //System.out.println(line);

                String[] split = line.split(":");
                //Remove "Game "
                gameNum = Integer.parseInt(split[0].substring(5));
                System.out.println("Game: " + gameNum);
                int red = 0;
                int green = 0;
                int blue = 0;
                
                String [] results = split[1].split(";");
                for (String result : results) {

                    int temp = 0;
                    
                    //System.out.println("Result: " + result);
                    String[] entryParts = result.split("\\s+");
                    //remove leading space
                    entryParts = Arrays.copyOfRange(entryParts, 1, entryParts.length);
                    //System.out.println(entry[0] + " next " + entry[1] + entry[2]);
                    boolean isInt = true;
                    for (String part : entryParts) {
                        if (isInt) {
                            temp = Integer.parseInt(part);
                            isInt = false;
                        }
                        else if (!part.equals("")) {
                            if (part.equals("red") || part.equals("red,")) {
                                red = Math.max(red,temp);
                            }
                            if (part.equals("green") || part.equals("green,")) {
                                green = Math.max(green,temp);                                
                            }
                            if (part.equals("blue") || part.equals("blue,")) {
                                blue = Math.max(blue,temp);
                            }
                            isInt = true;
                        }
                    }             
                }
                minCube = red * blue * green;
                System.out.println("R: " + red + " B: " + blue + " G: " + green);
                totalSum += minCube;
                System.out.println("Sum: " + totalSum);                
            }

            System.out.println("final result: " + totalSum);
            

            scan.close();
        }
        catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
}