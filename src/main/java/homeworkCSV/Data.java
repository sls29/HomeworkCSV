package homeworkCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Data {

    ArrayList<String> dataArray = new ArrayList<>();
    LinkedList<String> runners = new LinkedList<>();
    LinkedList<Runner> runnersR = new LinkedList<>();

    public void getDataFromCSV() throws FileNotFoundException {

        Scanner scanner = null;

        try {
            scanner = new Scanner(new File(
                    "data.csv"));
        scanner.useDelimiter(System.getProperty("line.separator"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        try {
            scanner.hasNextLine();
            while (scanner.hasNextLine()) {
                dataArray.add(scanner.nextLine());
            }
            scanner.close();
        } catch (NullPointerException e) {
            System.out.printf("Incorrect data!" + e.getMessage());
        }
    }

    public void getRunner() {
        for (String line : dataArray) {
            String[] runnerData = line.split(",");
            runners.add(Arrays.toString(runnerData));
            runnersR.add(new Runner(Integer.parseInt(runnerData[0]), runnerData[1], runnerData[2],
                    runnerData[3], runnerData[4], runnerData[5], runnerData[6]));
        }
    }

    public void calculateTime() {
        for (Runner nextRunner : runnersR) {

            int minutes = Integer.parseInt(nextRunner.time.substring(0, 2));
            int seconds = Integer.parseInt(nextRunner.time.substring(3));
            int timeInSec = (minutes * 60) + seconds;
            nextRunner.time = String.valueOf(timeInSec);

            String firstShoot = nextRunner.firstShooting;
            String secondShoot =nextRunner.secondShooting;
            String thirdShoot = nextRunner.thirdShooting;

            int stringFirstLength = firstShoot.length();
            int stringSecondLength = secondShoot.length();
            int stringThirdLength = thirdShoot.length();

            int penalityForMissedShoots = 0;
            @Deprecated
            Character check = new Character('o');

            for (int i = 0; i < stringFirstLength; i++) {
                Character chr = firstShoot.charAt(i);
                if (chr.equals(check)) {
                    penalityForMissedShoots += 10;
                }
            }

            for (int i = 0; i < stringSecondLength; i++) {
                Character chr = secondShoot.charAt(i);
                if (chr.equals(check)) {
                    penalityForMissedShoots += 10;
                }
            }

            for (int i = 0; i < stringThirdLength; i++) {
                Character chr = thirdShoot.charAt(i);
                if (chr.equals(check)) {
                    penalityForMissedShoots += 10;
                }
            }

            nextRunner.time = String.valueOf(Integer.parseInt(nextRunner.time) + penalityForMissedShoots);
            int minutesToString = Integer.parseInt(nextRunner.time) / 60;
            int secondsToString = Integer.parseInt(nextRunner.time) % 60;

            nextRunner.time = String.valueOf(minutesToString) + ":" + String.valueOf(secondsToString);
        }
    }

    public void finalStanding() {
        Collections.sort(runnersR, new TimeComparator());
        System.out.println("---Final Standing---");
        for (Runner nextRunner : runnersR) {
            System.out.println(nextRunner);
        }
        System.out.println("--------------------");
    }

}