import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;



public class mainDay1 {
    
    public static void main(String[] args) {
        //create file
        //createFile("day1Input");
        
        try {
            //FileReader fr = new FileReader("day1Input.txt");
            //FileWriter myWriter = new FileWriter("C:\\Users\\nclark\\Dev\\Advent\\"+"day1Input.txt");
            //myWriter.write("1abc2\r\npqr3stu8vwx\r\na1b2c3d4e5f\r\ntreb7uchet\r\n");
            //myWriter.close();
        }
        catch (Exception e) {
            System.out.println("Whoopsie!");
            e.printStackTrace();
        }

        try {
            //FileReader fr = new FileReader("C:\\Users\\nclark\\Dev\\Advent\\"+"day1Input.txt");
            File inputFile = new File("C:\\Users\\nclark\\Dev\\Advent\\"+"day1Input.txt");
            Scanner scan = new Scanner(inputFile);

            int total = 0;

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                //System.out.println(line);

                //PROCESSING LOGIC //////////////////////

                //Scanner lineScanner = new Scanner(line);
                int count = 0;
                //int firstInt = -1;
                //int secInt = -1;
                char firstInt = 'n';
                char secInt = 'n';
                for (int i = 0; i < line.length(); i++) {
                    if (Character.isDigit(line.charAt(i)) ) {
                        if (count == 0) {
                            firstInt = Character.valueOf(line.charAt(i));
                        }
                        else {
                            secInt = Character.valueOf(line.charAt(i));
                        }
                        count++;
                    }
                }
                if (count == 1) {
                    secInt = firstInt;
                }
                //System.out.println("1: " + firstInt + " 2: " + secInt);
                int lineNum = Integer.parseInt(new StringBuilder().append(firstInt).append(secInt).toString());
                //System.out.println(total);
                total += lineNum;
                

            }

            System.out.println("Final Count: " + total);
            
            scan.close();
        }
        catch (Exception e) {
            System.out.println("Bad Read");
            e.printStackTrace();
        }
        

        /* 
        getList lists = new getList();

        if (args[0] == null || args[0].trim().isEmpty()) {
            System.out.println("You need to specify a path!");
            return;
        }
        else {
            //File CP_file = new File(args[0]);
            //int count = fr.fileSizeInLines(CP_file);
            //System.out.println("Total number of lines in the file are: "+count);

            //List<String> lines = fr.strReader(CP_file);            
        }
        */
    }


    private static int createFile(String name) {
        try {
            File myObj = new File("C:\\Users\\nclark\\Dev\\Advent\\" + name + ".txt");
            myObj.delete();
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
            else {
                System.out.println("File already exists.");
            }
            return 0;
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return -1;
        }
        
    }
}

/* 
1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet

*/