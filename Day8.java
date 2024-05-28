import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            //File myObj = new File("/day8Sample");
            //File myObj = new File("/day8Sample2");
            File myObj = new File("/day8");
            Scanner myReader = new Scanner(myObj);

            String directions = null;
            HashMap<String,String[]> network = new HashMap<String,String[]>();


            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //System.out.println(data);
                if (directions == null) {
                    directions = data;
                }
                else {
                    if (!data.equals("")) {
                        String[] nameSplit = data.split(" = ");
                        String[] nodeSplit = nameSplit[1].split(", ");
                        network.put(nameSplit[0], new String[] {nodeSplit[0].substring(1,4), nodeSplit[1].substring(0,3)});
                    }
                }
            }
            myReader.close();

            for (String name : network.keySet()) {
                System.out.println(name + " : " + network.get(name)[0] + " " + network.get(name)[1]);
            }
            System.out.println(directions);



            //LOGIC
            int index = 0;
            String current = "AAA";

            while (!current.equals("ZZZ")) {
                char choice = directions.charAt(index % directions.length());
                int arrNum = 0;
                if (choice == 'L') {
                    arrNum = 0;
                }
                else {
                    arrNum = 1;
                }
                System.out.println(current);
                current = network.get(current)[arrNum];
                index++;

                System.out.println(current);


            }

            System.out.println(index);







        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }






}
