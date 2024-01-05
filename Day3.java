import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day3 {
    
    public static void main(String[] args) {

        try {
            String fileDir = System.getProperty("user.dir");
            System.out.println();
            if (args == null || args.length == 0) {
                fileDir = fileDir.concat("\\day3Input.txt");
            }
            else if (args[0].equalsIgnoreCase("test")) {
                fileDir = fileDir.concat("\\day3InputTEST.txt");
            }
            //System.out.println(fileDir);

            File inputFile = new File(fileDir);
            
            //going to make char[][] and List
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(inputFile));
            lineNumberReader.skip(Long.MAX_VALUE);
            int numLines = lineNumberReader.getLineNumber();
            lineNumberReader.close();
            //System.out.println(numLines);

            Scanner lineScanner = new Scanner(inputFile);
            String line = lineScanner.nextLine();
            int lineLen = line.length();
            char[][] schematic = new char[numLines][lineLen];

            ArrayList<List<Character>> listSchem = new ArrayList<List<Character>>();

            schematic[0] = line.toCharArray();
            listSchem.add(new ArrayList<Character>(line.chars().mapToObj(e->(char)e).collect(Collectors.toList())));
            
            for (int i = 1; i < numLines; i++) {
                line = lineScanner.nextLine();
                schematic[i] = line.toCharArray();
                listSchem.add(new ArrayList<Character>(line.chars().mapToObj(e->(char)e).collect(Collectors.toList())));
                //System.out.println(schematic[i]);
            }
            lineScanner.close();            
            /*
            //print
            
            for (List<Character> list : listSchem) {
                System.out.println(list);
            }
            System.out.println(schematic[0]);
            List<Integer> row0 = findNum(schematic[0]);
            System.out.println(row0);
            
            boolean test1 = isBySymbol(0, row0.get(2), row0.get(1), schematic);
            boolean test2 = isBySymbol(0, row0.get(5), row0.get(4), schematic);
            System.out.println(row0.get(3) + " " + test1);
            System.out.println(row0.get(6) + " " + test2);
            */

            //LOGIC
            int totalSum = 0;

            for (int i = 0; i <= numLines - 1; i++) {
                List<Integer> rowInts = findNum(schematic[i]);
                System.out.println(rowInts);
                int stPtr = 1;
                for (int j = rowInts.get(0); j > 0; j--) {
                    //System.out.println("j: " + j);
                    //System.out.println("t/f: " + isBySymbol(i, rowInts.get(stPtr + 1), rowInts.get(stPtr), schematic) + " st: " + (stPtr + 1) + " ed: " + (stPtr));
                    if (isBySymbol(i, rowInts.get(stPtr + 1), rowInts.get(stPtr), schematic)) {
                        totalSum += rowInts.get(stPtr + 2);
                    }
                    stPtr += 3;
                }
            }
            System.out.println("Total Sum: " + totalSum);  
        }        
        catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
        
    }

    private static List<Integer> findNum(char[] row) {
        //[0] # of nums,[1] start,[2] end,[3] value
        ArrayList<Integer> retList = new ArrayList<Integer>();
        int numNums = 0;
        retList.add(numNums);
        int i = row.length - 1;
        while (i >= 0) {
            //System.out.println("i + " + i + " char: " + row[i]);
            //Character.isDigit(row[i])
            if ('0' <= row[i] && row[i] <= '9') {
                retList.set(0,++numNums);
                retList.add(i);
                int value = 0;
                int multiplier = 1;
                //System.out.println("value + " + value + " mult: " + multiplier);
                while (i >= 0 && '0' <= row[i] && row[i] <= '9') {
                    value += Character.getNumericValue(row[i]) * multiplier;
                    multiplier *= 10;                    
                    //System.out.println("value + " + value + " mult: " + multiplier);
                    i--;
                }
                retList.add(i + 1);
                retList.add(value);
            }
            i--;
        }
        return retList;
    }

    private static boolean isBySymbol(int row, int start, int end, char[][] schem) {
        int numCol = schem[0].length;
        int numRow = schem.length;
        
        boolean retVal = false;
        for (int i = row - 1; i <= row + 1; i++) {
            if (retVal) break;
            for (int j = start - 1; j <= end + 1; j++) {
                //System.out.println("i + " + i + " j: " + j);
                if (0 <= i && i <= numRow - 1 && 0 <= j && j <= numCol - 1) {
                    //if (schem[i][j] != '.' && '0' > schem[i][j] && schem[i][j] < '9') {
                    if (schem[i][j] != '.' && !Character.isDigit(schem[i][j])) {
                        retVal = true;
                        break;
                    }
                }
            }
        }
        return retVal;
    }
}
