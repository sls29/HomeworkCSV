package homeworkCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Data {

    ArrayList<String> dataArray = new ArrayList<>();
    LinkedList<String> runners = new LinkedList<>();
    LinkedList<Runner> runnersR = new LinkedList<>();
    HashMap<String, Integer> runnersMap = new HashMap<>();
    ArrayList<Integer> timeInSeconds = new ArrayList<>();
    ArrayList<Integer> shootingResults = new ArrayList<>();
    ArrayList<Integer> totalTime = new ArrayList<>();
    ArrayList<String> runnersA = new ArrayList<>();

    public void getDataFromCSV() throws FileNotFoundException {

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(
                    "/home/think/IdeaProjects/HomeworkCSV/data.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        scanner.hasNextLine();
        while (scanner.hasNextLine()) {
            dataArray.add(scanner.nextLine());
        }
        scanner.close();

        for (String s : dataArray) {
            String[] runner = s.split(",");
            runners.add(Arrays.toString(runner));
            runnersR.add(new Runner(Integer.parseInt(runner[0]), runner[1], runner[2],
                    runner[3], runner[4], runner[5], runner[6], null));
        }
    }

    public void timeInSeconds() {
        for (Runner nextRunner : runnersR) {
            Integer minutes = Integer.parseInt(((String) nextRunner.time).substring(0, 2));
            Integer secundes = Integer.parseInt(((String) nextRunner.time).substring(3));
            Integer timeInSec = (minutes * 60) + secundes;
            timeInSeconds.add(timeInSec);
            runnersA.add((String) nextRunner.name);
        }
    }

    public void runnersShoots() {
        for (Runner nextRunner : runnersR) {
            String firstShoot = (String) nextRunner.firstShooting;
            String secondShoot = (String) nextRunner.secondShooting;
            String thirdShoot = (String) nextRunner.thirdShooting;

            int stringFirstLength = firstShoot.length();
            int stringSecondLength = secondShoot.length();
            int stringThirdLength = thirdShoot.length();

            int miss1 = 0;
            Character check = new Character('o');

            for (int i = 0; i < stringFirstLength; i++) {
                Character chr = firstShoot.charAt(i);
                if (chr.equals(check)) {
                    miss1 += 10;
                }
            }
            for (int i = 0; i < stringSecondLength; i++) {
                Character chr = secondShoot.charAt(i);
                if (chr.equals(check)) {
                    miss1 += 10;
                }
            }

            for (int i = 0; i < stringThirdLength; i++) {
                Character chr = thirdShoot.charAt(i);
                if (chr.equals(check)) {
                    miss1 += 10;
                }
            }
            shootingResults.add(miss1);
        }
    }

    public void finalTime() {
        int size = runnersR.size();
        for (int i = 0; i < size; i++) {
            totalTime.add(timeInSeconds.get(i) + shootingResults.get(i));
            runnersMap.put(runnersA.get(i), totalTime.get(i));
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : runnersMap.entrySet()) {
            System.out.println(stringIntegerEntry);
        }
    }
}