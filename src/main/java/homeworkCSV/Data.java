package homeworkCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Data {

    ArrayList<String> dataArray = new ArrayList<>();
    LinkedList<String> runners = new LinkedList<>();
    LinkedList<Runner> runnersR = new LinkedList<>();
    HashMap<String, String> runnersTime = new HashMap<>();
    LinkedList<Integer> shootingResults = new LinkedList<>();

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
        System.out.println(dataArray);
        System.out.println(dataArray.size());

        for (String s : dataArray) {
            String[] runner = s.split(",");
            runners.add(Arrays.toString(runner));
            runnersR.add(new Runner(Integer.parseInt(runner[0]), runner[1], runner[2],
                    runner[3], runner[4], runner[5], runner[6]));
        }
//        System.out.println(runners.size());
//        System.out.println(runners);
//        System.out.println(runnersR.size());
//        System.out.println(runnersR);
    }

    public void showRunners() {
        for (Runner nextRunner : runnersR) {
            System.out.println(nextRunner.name + ": " + nextRunner.country);
        }
    }

    public void getRunnersTime() {
        for (Runner nextRunner : runnersR) {
            runnersTime.put((String) nextRunner.name, (String) nextRunner.time);
        }
    }

    public void showRunnersTime() {
        for (String i : runnersTime.values()) {
            System.out.println(i);
        }
    }

    public void timeInSeconds() {
        for (Runner nextRunner : runnersR) {
            Integer minutes = Integer.parseInt(((String) nextRunner.time).substring(0, 2));
            Integer secundes = Integer.parseInt(((String) nextRunner.time).substring(3));
            Integer timeInSeconds = (minutes * 60) + secundes;
            System.out.println(timeInSeconds);

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
            for (int i = 0; i < stringFirstLength; i++) {
                Character chr = firstShoot.charAt(i);
                Character check = new Character('o');
                if (chr.equals(check)) {
                    miss1 += 10;
                }
            }
            for (int i = 0; i < stringSecondLength; i++) {
                Character chr = secondShoot.charAt(i);
                Character check = new Character('o');
                if (chr.equals(check)) {
                    miss1 += 10;
                }
            }

            for(int i = 0; i < stringThirdLength; i++ ) {
                Character chr = thirdShoot.charAt(i);
                Character check = new Character('o');
                if (chr.equals(check)) {
                    miss1 += 10;
                }
            }
        shootingResults.add(miss1);
        }
        System.out.println(shootingResults);
    }
}