import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            //File myObj = new File();
            File myObj = new File();
            Scanner myReader = new Scanner(myObj);

            ArrayList<String> hands = new ArrayList<>();
            ArrayList<Integer> bids = new ArrayList<>();

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //System.out.println(data);
                String[] split = data.split(" ");
                hands.add(split[0]);
                bids.add(Integer.parseInt(split[1]));

            }
            myReader.close();

            //LOGIC
//            for (int i = 0; i < hands.size(); i++) {
//                System.out.println(hands.get(i) + " : " + bids.get(i));
//            }




            //bubblesort
            for (int out = 0; out < hands.size() - 1; out++) {
                for (int inner = 0; inner < hands.size() - out - 1; inner++) {
                    if (compareHand(hands.get(inner), hands.get(inner + 1))) {
                        String temp = hands.get(inner);
                        int tempBid = bids.get(inner);
                        hands.set(inner, hands.get(inner + 1));
                        bids.set(inner, bids.get(inner + 1));
                        hands.set(inner + 1, temp);
                        bids.set(inner + 1, tempBid);
                    }
                }
            }

            System.out.println("AFTER");
            System.out.println(" \n ");
            for (int i = 0; i < hands.size(); i++) {
                System.out.println(hands.get(i) + " : " + bids.get(i));
            }

            double answer = 0;
            for (int i = 0; i < bids.size(); i++) {
                int bid = i + 1;
                bid *= bids.get(i);
                answer += bid;
            }

            System.out.println("answer: " + answer);



            System.out.println("Test");
            String hand1 = "KAAAK";
            String hand2 = "AJ939";
            System.out.println(hand1 + " : " + hand2);
            System.out.println(compareHand(hand1,hand2));



        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

    //Merge sort
    //public static void merge(ArrayList<Integer> input, int )

    public static boolean compareHand(String handOne, String handTwo) {
        //int highCard = 0;
        HashMap<Character, Integer> handOneChars = new HashMap<Character, Integer>();
        HashMap<Character, Integer> handTwoChars = new HashMap<Character, Integer>();
        for (int i = 0; i < handOne.length(); i++) {
            handOneChars.put(handOne.charAt(i), handOneChars.getOrDefault(handOne.charAt(i), 0) + 1);
            handTwoChars.put(handTwo.charAt(i), handTwoChars.getOrDefault(handTwo.charAt(i), 0) + 1);
        }
        int oneTopFreq = 0;
        int oneNextFreq = 0;
        int twoTopFreq = 0;
        int twoNextFreq = 0;

        for (int freq : handOneChars.values()) {
            if (freq > oneTopFreq) {
                if (oneTopFreq > oneNextFreq) {
                    oneNextFreq = oneTopFreq;
                }
                oneTopFreq = freq;
            }
            else if (freq > oneNextFreq) {
                oneNextFreq = freq;
            }
        }
        if (oneTopFreq == handOneChars.getOrDefault('J' , 0)) {
            oneTopFreq = oneNextFreq + handOneChars.get('J');
        }
        else {
            oneTopFreq += handOneChars.getOrDefault('J' , 0);
        }
        if (oneTopFreq + oneNextFreq >= 5) {
            oneNextFreq = 5 - oneTopFreq;
        }

        for (int freq : handTwoChars.values()) {
            if (freq > twoTopFreq) {
                if (twoTopFreq > twoNextFreq) {
                    twoNextFreq = twoTopFreq;
                }
                twoTopFreq = freq;
            }
            else if (freq > twoNextFreq) {
                twoNextFreq = freq;
            }
        }
        if (twoTopFreq == handTwoChars.getOrDefault('J' , 0)) {
            twoTopFreq = twoNextFreq + handTwoChars.get('J');
        }
        else {
            twoTopFreq += handTwoChars.getOrDefault('J' , 0);
        }

        if (twoTopFreq + twoNextFreq >= 5) {
            twoNextFreq = 5 - twoTopFreq;
        }

        System.out.println("Top1: " + oneTopFreq + " Next1: " + oneNextFreq);
        System.out.println("Top2: " + twoTopFreq + " Next2: " + twoNextFreq);

        if (oneTopFreq != twoTopFreq) {
            return oneTopFreq > twoTopFreq;
        }
        else if (oneNextFreq != twoNextFreq) {
            return oneNextFreq > twoNextFreq;
        }
        //need comparison
        else {
            for (int i = 0; i < handOne.length(); i++) {
                if (convertChar(handOne.charAt(i)) != convertChar(handTwo.charAt(i))) {
                    return convertChar(handOne.charAt(i)) > convertChar(handTwo.charAt(i));
                }
            }
            //same
        }


        return true;
    }

    public static int convertChar(char c) {
        if (c == 'A') return 14;
        else if (c == 'K') return 13;
        else if (c == 'Q') return 12;
        else if (c == 'J') return 1;
        else if (c == 'T') return 10;
        else return c - '0';
    }


}
