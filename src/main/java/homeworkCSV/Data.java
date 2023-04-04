package homeworkCSV;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Data {

    ArrayList<String> dataArray = new ArrayList<>();
    LinkedList<String> runners = new LinkedList<>();
    LinkedList<Runner> runnersR = new LinkedList<>();
    HashMap<String, String> runnersMap = new HashMap<>();
    ArrayList<Integer> timeInSeconds = new ArrayList<>();
    ArrayList<Integer> shootingResults = new ArrayList<>();
    ArrayList<Integer> totalTime = new ArrayList<>();
    ArrayList<String> totalTimeS = new ArrayList<>();
    ArrayList<String> runnersA = new ArrayList<>();

    public void getDataFromCSV() throws FileNotFoundException {

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(
                    "/home/think/IdeaProjects/CSVhomework/data.csv"));
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
            int minutes = Integer.parseInt(((String) nextRunner.time).substring(0, 2));
            int secundes = Integer.parseInt(((String) nextRunner.time).substring(3));
            int timeInSec = (minutes * 60) + secundes;
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
        int size = totalTimeS.size();
        for (int i = 0; i < size; i++ ){
            runnersMap.put(runnersA.get(i), totalTimeS.get(i));
        }
        System.out.println(" ");
        System.out.println("Final Standing");
        System.out.println("______________________");
        for (Map.Entry<String, String> stringIntegerEntry : runnersMap.entrySet()) {
            System.out.println(stringIntegerEntry);
        }
        System.out.println("______________________");
    }
}