package homeworkCSV;

import java.io.FileNotFoundException;

/**
 *
 *
 */
public class App {
    public static void main( String[] args ) throws FileNotFoundException {

        Data data = new Data();

        data.getDataFromCSV();
        data.showRunners();
        data.getRunnersTime();
        data.showRunnersTime();
        data.timeInSeconds();
        data.runnersShoots();
    }
}
