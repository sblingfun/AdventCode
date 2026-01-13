import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;
public class Day4Part1 {

    public static void main(String[] args) {
        boolean isExample = false;
        if (args.length > 0 && args[0].contains("ex")) {
            isExample = true;
        }

        //System.out.println(isExample);
        String inputFile = "day4";
        if (isExample) {
            inputFile += "example";
        }
        else {
            inputFile += "main";
        }
        inputFile += ".txt";

        Path newFile = Paths.get(inputFile);
        
        int numTpRolls = 0;

        try {
            BufferedReader br = Files.newBufferedReader(newFile);
            String line;
            int lineNum = 0;
            int lineSize = 0;
            List<List<Integer>> tpMap = new ArrayList<List<Integer>>();
            while ( (line = br.readLine()) != null) {

                List<Integer> newLine = new ArrayList<Integer>(); 
                //System.out.println(line);
                lineSize = line.length();
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '@') {
                        newLine.add(i);
                    }
                }
                tpMap.add(newLine);
                lineNum++;
            }

            
            for (int i = 0; i < tpMap.size(); i++) {
                List<Integer> tpLine = tpMap.get(i);
                for (Integer index : tpLine) {
                    if (countSurrounding(tpMap, index, i, tpMap.size() - 1, lineSize) < 4) {
                        
                        numTpRolls++;
                        System.out.println("TP Added: " + i + " " + index);
                    }
                }
            }

            System.out.println("Number of TP Rolls: " + numTpRolls);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static int countSurrounding(List<List<Integer>> map, Integer idx, Integer row, int numRows, int lineSize) {
        int numSurrounding = 0;
        
        
        if (row > 0) {
            List<Integer> rowBefore = map.get(row - 1);
            if (rowBefore.contains(idx)) numSurrounding++;
            if (idx > 0 && rowBefore.contains(idx - 1)) numSurrounding++;
            if (idx < lineSize && rowBefore.contains(idx + 1)) numSurrounding++;
        }

        if (row < numRows) {
            List<Integer> rowAfter = map.get(row + 1);
            if (rowAfter.contains(idx)) numSurrounding++;
            if (idx > 0 && rowAfter.contains(idx - 1)) numSurrounding++;
            if (idx < lineSize && rowAfter.contains(idx + 1)) numSurrounding++;
        }

        List<Integer> curRow = map.get(row);
        if (curRow.contains(idx - 1)) numSurrounding++;
        if (curRow.contains(idx + 1)) numSurrounding++;


        return numSurrounding;
    }
}
