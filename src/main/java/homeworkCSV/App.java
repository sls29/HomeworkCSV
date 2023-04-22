package homeworkCSV;

import java.io.FileNotFoundException;

/**
 *
 *
 *
 */
public class App {
    public static void main( String[] args ) throws FileNotFoundException {

        Data data = new Data();

        data.getDataFromCSV();

        data.getRunner();

        data.calculateTime();

        data.finalStanding();

    }
}
