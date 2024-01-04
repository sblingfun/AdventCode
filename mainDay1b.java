import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;



public class mainDay1b {
    
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

            //Real File
            File inputFile = new File("C:\\Users\\nclark\\Dev\\Advent\\"+"day1Input.txt");

            //Test File
            //File inputFile = new File("C:\\Users\\nclark\\Dev\\Advent\\"+"day1InputTEST.txt");
            Scanner scan = new Scanner(inputFile);

            //PROCESSING LOGIC //////////////////////

            //could to String to String
            HashMap<String,Character> stringToChar = new HashMap<String,Character>();
            stringToChar.put("one",'1'); //3
            stringToChar.put("two",'2'); //3
            stringToChar.put("three",'3'); //5
            stringToChar.put("four",'4'); //4
            stringToChar.put("five",'5'); //4
            stringToChar.put("six",'6'); //3
            stringToChar.put("seven",'7'); //5
            stringToChar.put("eight",'8'); //5
            stringToChar.put("nine",'9'); //4
            HashSet<Character> startChars = new HashSet<Character>();
            startChars.add('o');
            startChars.add('t');
            startChars.add('f');
            startChars.add('s');
            startChars.add('e');
            startChars.add('n');

            
            int total = 0;
            
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println("old line: " + line);
                //System.out.println(line);

                //Replace letters with chars
                for (int i = 0; i <= line.length() - 3; i++) {
                    //System.out.println("checking: " + i + " lineLen: " + line.length());
                    if (startChars.contains(line.charAt(i))) {
                        if (stringToChar.containsKey(line.substring(i, i + 3))) {
                            //3
                            //line = line.substring(0, i).concat(stringToChar.get(line.substring(i, i + 3)).toString()).concat(line.substring(i + 3, line.length()));
                            //line = line.replaceFirst(line.substring(i, i + 3), stringToChar.get(line.substring(i, i + 3)).toString());
                            line = line.substring(0, i).concat(stringToChar.get(line.substring(i, i + 3)).toString()).concat(line.substring(i + 2, line.length()));
                            
                        }
                        else if (i <= line.length() - 4 && stringToChar.containsKey(line.substring(i, i + 4))) {
                            //4
                            //line = line.replaceFirst(line.substring(i, i + 4), stringToChar.get(line.substring(i, i + 4)).toString());
                            line = line.substring(0, i).concat(stringToChar.get(line.substring(i, i + 4)).toString()).concat(line.substring(i + 3, line.length()));
                        }
                        else if (i <= line.length() - 5 && stringToChar.containsKey(line.substring(i, i + 5))) {
                            //5
                            //line = line.replaceFirst(line.substring(i, i + 5), stringToChar.get(line.substring(i, i + 5)).toString());
                            line = line.substring(0, i).concat(stringToChar.get(line.substring(i, i + 5)).toString()).concat(line.substring(i + 4, line.length()));
                        }

                    }
                }
                System.out.println("new line: " + line);
                

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
                System.out.println("1: " + firstInt + " 2: " + secInt);
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
two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen
 */