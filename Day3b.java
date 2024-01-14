import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3b {    
    public static void main(String[] args) {

        
        //System.out.println("Hello World");
        String workDir = System.getProperty("user.dir");
        String curDir = Paths.get(".").toAbsolutePath().toString();
        //System.out.println(workDir);
        //System.out.println(curDir);

        
        if (args.length > 0 && args[0].equals("test")) {
            workDir = workDir.concat("\\Day3TestData.txt");
        }
        else if (args.length > 0 && args[0].equals("test2")) {
            workDir = workDir.concat("\\Day3TestData2.txt");
        }
        else {
            workDir = workDir.concat("\\Day3Data.txt");
        }
        //System.out.println(workDir);
        
        File dataFile = new File(workDir);
        int lineCnt = 0;
        int lineSize = 0;
        try {
            Scanner sc = new Scanner(dataFile);
            while (sc.hasNextLine()) {
                String curLine = sc.nextLine();
                lineSize = curLine.length();
                lineCnt++;
            }
            sc.close();

            sc = new Scanner(dataFile);
            char[][] schematic = new char[lineCnt][lineSize];
            lineCnt = 0;
            while (sc.hasNextLine()) {
                String curLine = sc.nextLine();
                //System.out.println("add: " + curLine);
                schematic[lineCnt] = curLine.toCharArray();
                lineCnt++;
            }
            sc.close();

            /*
            for (int i = 0; i < schematic.length; i++){
                System.out.println(new String(schematic[i]));
            }
            */
            //LOGIC
            
            long totalSum = 0;

            List<List<Integer>> stars = new ArrayList<List<Integer>>();
            for (int i = 0; i < lineCnt; i++) {
                for (int j = 0; j < lineSize; j++) {
                    if (schematic[i][j] == '*') {
                        stars.add(List.of(i,j));
                    }
                }
            }
            /*
            for (List<Integer> star : stars) {
                System.out.println(star);
            }
            
            stars.clear();
            stars.add(List.of(120,136));
            
            

            
            for (List<Integer> starCord : stars) {
                List<Integer> adjList = new ArrayList<Integer>();
                List<Integer> rowToCheck = new ArrayList<Integer>();
                rowToCheck.add(starCord.get(0));
                if (starCord.get(0) - 1 >= 0 ) rowToCheck.add(starCord.get(0) - 1);
                if (starCord.get(0) + 1 < lineCnt ) rowToCheck.add(starCord.get(0) + 1);
                //System.out.println("Row2Chk: " + rowToCheck);
                for (int i = 0; i < rowToCheck.size(); i++) {
                    List<Integer> numRet = new ArrayList<Integer>();
                    if (i > 0) {
                        if (starCord.get(1) - 1 >= 0 && isNum( schematic[rowToCheck.get(i)][starCord.get(1) - 1])) {
                            List<Integer> newRet = getNum(starCord.get(1) - 1, schematic[rowToCheck.get(i)]);
                            numRet = newRet;
                            adjList.add(numRet.get(2));
                            System.out.println("adj add-: " + starCord.get(1));
                        }
                        else if (isNum( schematic[rowToCheck.get(i)][starCord.get(1)])) {
                            List<Integer> newRet = getNum(starCord.get(1), schematic[rowToCheck.get(i)]);
                            if (numRet.size() == 0 ) {
                                numRet = newRet;
                                adjList.add(numRet.get(2));
                                System.out.println("adj add: " + starCord.get(1));
                            }
                            else if (newRet.get(0) != numRet.get(0)) {
                                numRet = newRet;
                                adjList.add(numRet.get(2));
                            }
                            
                        }
                        else if (starCord.get(1) + 1 < schematic[rowToCheck.get(i)].length - 1 && isNum( schematic[rowToCheck.get(i)][starCord.get(1) + 1])) {
                            List<Integer> newRet = getNum(starCord.get(1) + 1, schematic[rowToCheck.get(i)]);
                            if (numRet.size() == 0 ) {
                                numRet = newRet;
                                adjList.add(numRet.get(2));
                                System.out.println("adj add+:" + starCord.get(1) + 1);
                            }
                            else if (newRet.get(0) != numRet.get(0)) {
                                numRet = newRet;
                                adjList.add(numRet.get(2));
                            }                            
                        }  
                    }
                    else {
                        //only have to check side of each star
                        if (starCord.get(1) - 1 >= 0 && isNum( schematic[rowToCheck.get(i)][starCord.get(1) - 1])) {
                            numRet = getNum(starCord.get(1) - 1, schematic[rowToCheck.get(i)]);
                            adjList.add(numRet.get(2));
                        }
                        if (starCord.get(1) + 1 <= schematic[i].length - 1 && isNum( schematic[rowToCheck.get(i)][starCord.get(1) + 1])) {
                            numRet = getNum(starCord.get(1) + 1, schematic[rowToCheck.get(i)]);
                            adjList.add(numRet.get(2));
                        }
                    }
                }
                System.out.println("adj: " + adjList);
                int tempSum = 1;
                if (adjList.size() == 2) {
                    for (int adjVal : adjList) {
                        tempSum *= adjVal;
                    }
                    totalSum += tempSum;
                    System.out.println("Adding: " + tempSum + " to " + totalSum);
                }
                
                
            }

            System.out.println("Total Sum: " + totalSum);
            
            
            //getNum(1,schematic[0]);
            

            List<Integer> funcCall = nextNums(1,3,schematic);
            System.out.println("1,3" + funcCall);
            funcCall = nextNums(4,3,schematic);
            System.out.println("4,3" + funcCall);
            funcCall = nextNums(8,5,schematic);
            System.out.println("8,5" + funcCall);
            System.out.println("Line Len: " + schematic[0].length);
            System.out.println("Number Lines: " + schematic.length);
            List<Integer> funcCall = nextNums(3,136,schematic);
            System.out.println("1,3" + funcCall);
            */

            totalSum = 0;
            for (List<Integer> starCord : stars) {
                List<Integer> adjList = nextNums(starCord.get(0),starCord.get(1), schematic);
                System.out.println("Checking star " + starCord.get(0) + " " + starCord.get(1));
                System.out.println("AdjList: " + adjList);
                if (adjList.size() == 2) {
                    int tempSum = adjList.get(0) * adjList.get(1);
                    totalSum += tempSum;
                }
            }
            System.out.println("Total Sum: " + totalSum);
            
            

            

            
        }
        catch (Exception e) {
            System.out.println("Bad File Read");
            e.printStackTrace();
        }
        

               

    }

    private static boolean isNum(char c) {
        //if ('0' <= c && c <= '9') return true;
        if (Character.isDigit(c)) return true;
        else return false;
    }

    private static List<Integer> getNum(int index, char[] rowChars) {
        List<Integer> retList = new ArrayList<Integer>();

        int numVal = 0;
        int multFactor = 1;
        while (index < rowChars.length - 1 && isNum(rowChars[index + 1])) {
            //System.out.println(index);
            index++;
        }
        retList.add(index);

        while (index >= 0 && isNum(rowChars[index])) {
            //System.out.println("idx: " + index + " val: " + rowChars[index]);
            numVal += (Character.getNumericValue(rowChars[index]) * multFactor);
            //System.out.println("multF: " + multFactor + " val: " + rowChars[index]);
            //System.out.println("change: " + (rowChars[index] * multFactor));
            //System.out.println("Num: " + numVal);
            multFactor *= 10;
            index--;
        }
        retList.add(index + 1);

        //System.out.println("Num: " + numVal);
        retList.add(numVal);
        //System.out.println(retList);
        return retList;
    }

    private static List<Integer> nextNums(int row, int col, char[][] schematic) {
        List<Integer> retList = new ArrayList<Integer>();

        List<Integer> numReturn = new ArrayList<Integer>();
        
        //check left and right
        if (col - 1 >= 0 && isNum(schematic[row][col - 1])) {
            numReturn = getNum(col - 1, schematic[row]);
            retList.add(numReturn.get(2));
        }
        if (col + 1 <= schematic[row].length - 1 && isNum(schematic[row][col + 1])) {
            numReturn = getNum(col + 1, schematic[row]);
            retList.add(numReturn.get(2));
        }
        //check row above
        numReturn.clear();
        if (row - 1 >= 0) {
            if (col - 1 >= 0 && isNum(schematic[row-1][col-1])) {
                System.out.println("Top Left");
                numReturn = getNum(col - 1, schematic[row - 1]);
                retList.add(numReturn.get(2));
            }
            if (isNum(schematic[row-1][col])) {
                numReturn = getNum(col, schematic[row - 1]);
                //if (retList.size() == 0 || retList.get(retList.size() - 1) != numReturn.get(2)) {
                if (col - 1 < 0 || !isNum(schematic[row-1][col-1]) ) {
                    System.out.println("Top Middle");
                    retList.add(numReturn.get(2));
                }                
            }
            if (col + 1 <= schematic[row-1].length - 1 && isNum(schematic[row-1][col + 1])) {
                numReturn = getNum(col + 1, schematic[row - 1]);
                if ( !isNum(schematic[row-1][col]) ) {
                    System.out.println("Top Right");
                    retList.add(numReturn.get(2));
                }                
            }
        }
        //row above
        numReturn.clear();
        if (row + 1 <= schematic.length - 1) {
            if (col - 1 >= 0 && isNum(schematic[row + 1][col-1])) {
                System.out.println("Bottom Left");
                numReturn = getNum(col - 1, schematic[row + 1]);
                retList.add(numReturn.get(2));
            }
            if (isNum(schematic[row + 1][col])) {
                numReturn = getNum(col, schematic[row + 1]);
                //if (retList.size() == 0 || retList.get(retList.size() - 1) != numReturn.get(2)) {
                    if (col - 1 < 0 || !isNum(schematic[row+1][col-1]) ) {
                    System.out.println("Bottom Middle");
                    retList.add(numReturn.get(2));
                }                
            }
            if (col + 1 <= schematic[row + 1].length - 1 && isNum(schematic[row + 1][col + 1])) {
                numReturn = getNum(col + 1, schematic[row + 1]);
                if ( !isNum(schematic[row + 1][col]) ) {
                    System.out.println("Bottom Right");
                    retList.add(numReturn.get(2));
                }                
            }
        }       
        return retList;
    }
}


/*
 * if (col - 1 >= 0 && row - 1 >= 0 ) {
            //1 . 1
            if (isNum(schematic[row-1][col-1]) && !isNum(schematic[row-1][col]) && isNum(schematic[row-1][col+1])) {
                numReturn = getNum(col - 1, schematic[row - 1]);
                retList.add(numReturn.get(2));
                numReturn = getNum(col + 1, schematic[row - 1]);
                retList.add(numReturn.get(2));
            }
            // 1 . .
            else if (isNum(schematic[row-1][col-1]) && !isNum(schematic[row-1][col]) && !isNum(schematic[row-1][col+1])) {
                numReturn = getNum(col - 1, schematic[row - 1]);
                retList.add(numReturn.get(2));
            }
            // . 1 .
            else if (!isNum(schematic[row-1][col-1]) && isNum(schematic[row-1][col]) && !isNum(schematic[row-1][col+1])) {
                numReturn = getNum(col, schematic[row - 1]);
                retList.add(numReturn.get(2));
            }
            // . . 1
            else if (!isNum(schematic[row-1][col-1]) && !isNum(schematic[row-1][col]) && isNum(schematic[row-1][col+1])) {
                numReturn = getNum(col + 1, schematic[row - 1]);
                retList.add(numReturn.get(2));
            }
            // . 1 1
            else if (!isNum(schematic[row-1][col-1]) && isNum(schematic[row-1][col]) && isNum(schematic[row-1][col+1])) {
                numReturn = getNum(col, schematic[row - 1]);
                retList.add(numReturn.get(2));
            }
            // 1 1 .
            else if (isNum(schematic[row-1][col-1]) && isNum(schematic[row-1][col]) && !isNum(schematic[row-1][col+1])) {
                numReturn = getNum(col - 1, schematic[row - 1]);
                retList.add(numReturn.get(2));
            }
            // 1 1 1
            else if (isNum(schematic[row-1][col-1]) && isNum(schematic[row-1][col]) && isNum(schematic[row-1][col+1])) {
                numReturn = getNum(col - 1, schematic[row - 1]);
                retList.add(numReturn.get(2));
            }
        }
 */