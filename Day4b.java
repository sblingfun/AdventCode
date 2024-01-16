import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Day4b {
    
    public static void main(String[] args) {
        try {
            String curDir = Path.of("").toAbsolutePath().toString();

            if (args.length > 0 && args[0].equalsIgnoreCase("test")) {
                curDir = curDir.concat("\\Day4InputTEST.txt");
            }
            else {
                curDir = curDir.concat("\\Day4Input.txt");
            }
            System.out.println(curDir);
            
            File inputFile = new File(curDir);

            int totalScore = 0;
            //List<List<Integer>> cardNumber = new ArrayList<List<Integer>>();
            List<List<Integer>> cardList = new ArrayList<List<Integer>>();
            List<HashSet<Integer>> playList = new ArrayList<HashSet<Integer>>();
            Scanner fileScan = new Scanner(inputFile);
            while (fileScan.hasNextLine()) {
                //System.out.println(fileScan.nextLine());
                String curLine = fileScan.nextLine();
                String[] lineSplit = curLine.split("[:|]");
                
                HashSet<Integer> luckyNum =  new HashSet<Integer>();
                String[] luckySplit = lineSplit[1].split(" ");
                //first split is empty
                for (int i = 0; i < luckySplit.length; i++) {
                    if (!luckySplit[i].equals("")) {
                        luckyNum.add(Integer.parseInt(luckySplit[i]));
                    }                    
                }
                playList.add(luckyNum);
                //System.out.println(luckyNum);
                
                List<Integer> cardNums = new ArrayList<Integer>();
                String[] playNums = lineSplit[2].split(" ");
                //first split is empty
                for (int i = 0; i < playNums.length; i++) {
                    if (!playNums[i].equals("")) {
                        cardNums.add(Integer.parseInt(playNums[i]));
                    }                    
                }
                //System.out.println(cardNums);
                cardList.add(cardNums);              
            }

            int[] cardFreq = new int[cardList.size()];
            Arrays.fill(cardFreq,1);

            for (int i = 0; i < cardList.size() - 1; i++) {
                for (int j = cardFreq[i]; j > 0; j--) {
                    int matchCnt = 0;
                    for (int num : cardList.get(i)) {
                        if (playList.get(i).contains(num)) matchCnt++;
                    }
                    while (matchCnt > 0) {
                        cardFreq[i + matchCnt]++;
                        matchCnt--;
                    }                    
                }
            }

            for (int score : cardFreq) {
                totalScore += score;
            }


            System.out.println("Final Total Score: " + totalScore);            
            
        }
        catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
