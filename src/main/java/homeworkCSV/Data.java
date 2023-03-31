package homeworkCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Data {

    public void getDataFromCSV() throws FileNotFoundException {
        ArrayList<String> dataArray = new ArrayList<>();
        LinkedList<String> runners = new LinkedList<>();
        LinkedList<Runner> runnersR = new LinkedList<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(
                    "/home/think/IdeaProjects/CSVhomework/data.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        scanner.hasNextLine();
        while(scanner.hasNextLine()){
            dataArray.add(scanner.nextLine());
        }
        scanner.close();
        System.out.println(dataArray);
        System.out.println(dataArray.size());

        for(int i = 0; i < dataArray.size(); i++) {
            String[] runner = dataArray.get(i).split(",");
            runners.add(Arrays.toString(runner));
            runnersR.add(new Runner(Integer.parseInt(runner[0]), "runner[1]",
                    "runner[2]", "runner[3]",
                    "runner[4]", "runner[5]", "runner[6]"));
//            System.out.println(Arrays.toString(runner));
        }
        System.out.println(runners.size());
        System.out.println(runners);
        System.out.println(runnersR);



    }
}
