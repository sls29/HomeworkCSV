package homeworkCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Data {

    ArrayList<String> dataArray = new ArrayList<>();
    LinkedList<String> runners = new LinkedList<>();
    LinkedList<Runner> runnersR = new LinkedList<>();
    ArrayList<Integer> timeInSeconds = new ArrayList<>();
    ArrayList<Integer> shootingResults = new ArrayList<>();
    ArrayList<Integer> totalTime = new ArrayList<>();
    ArrayList<String> totalTimeS = new ArrayList<>();
    ArrayList<String> runnersA = new ArrayList<>();
    HashMap<String, String> runnersMap = new HashMap<>();
    LinkedHashMap<String, String> standingMap = new LinkedHashMap<>();
    ArrayList<String> list = new ArrayList<>();


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
            System.out.printf("Incorrect data!");

        }
    }

    public void getRunner() {

        for (String line : dataArray) {
            String[] runnerData = line.split(",");
            runners.add(Arrays.toString(runnerData));
            runnersR.add(new Runner(Integer.parseInt(runnerData[0]), runnerData[1], runnerData[2],
                    runnerData[3], runnerData[4], runnerData[5], runnerData[6], null));
        }
    }

    public void timeInSeconds() {
        for (Runner nextRunner : runnersR) {
            int minutes = Integer.parseInt(((String) nextRunner.time).substring(0, 2));
            int seconds = Integer.parseInt(((String) nextRunner.time).substring(3));
            int timeInSec = (minutes * 60) + seconds;
            timeInSeconds.add(timeInSec);
        }
    }


    public void runnersShoots() {
        for (Runner nextRunner : runnersR) {
            runnersA.add((String) nextRunner.name);

            String firstShoot = (String) nextRunner.firstShooting;
            String secondShoot = (String) nextRunner.secondShooting;
            String thirdShoot = (String) nextRunner.thirdShooting;

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
            shootingResults.add(penalityForMissedShoots);
        }
    }

    public void finalTime() {
        int size = runnersR.size();
        for (int i = 0; i < size; i++) {
            totalTime.add(timeInSeconds.get(i) + shootingResults.get(i));
        }
    }

    public void timeInString() {
        int size = totalTime.size();
        for (int i = 0; i < size; i++) {
            String minutes = Integer.toString(totalTime.get(i) / 60);
            String seconds = Integer.toString(totalTime.get(i) % 60);
            String timeString = " " + minutes + ":" + seconds + ".";
            totalTimeS.add(timeString);
        }
    }

    public void standing() {

        Comparator<String> comparator = String::compareTo;

        int size = totalTimeS.size();
        for (int i = 0; i < size; i++) {
            runnersMap.put(runnersA.get(i), totalTimeS.get(i));
        }

        for (Map.Entry<String, String> entry : runnersMap.entrySet()) {
                list.add(entry.getValue());
        }

        list.sort(comparator);
            for (String str : list) {
                for (Map.Entry<String, String> entry : runnersMap.entrySet()) {
                    if (entry.getValue().equals(str)) {
                        standingMap.put(entry.getKey(), str);
                    }
                }
            }


        System.out.println(" ");
        System.out.println("------- Final Results -------");
        System.out.println(standingMap);
    }
}