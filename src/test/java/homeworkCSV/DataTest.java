package homeworkCSV;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;


class DataTest {


    @org.junit.jupiter.api.Test
    void getDataFromCSV() {
    }

    @org.junit.jupiter.api.Test
    void timeInSeconds() {
        LinkedList<Runner> runnersR = new LinkedList<>();
        Data data = new Data();
            Runner runner1 = new Runner(1, "John Doe",
                    "US", "20:30", "xxoox",
                    "xxxxo", "oxxxx", null);

            runnersR.add(runner1);
            data.timeInSeconds();


            assertEquals(1, runnersR.size());
    }


//        @org.junit.jupiter.api.Test
//        void runnersShoots () {
//            LinkedList<Runner> runnersR = new LinkedList<>();
//            Data data = new Data();
//            Runner runner1 = new Runner(1, "John Doe",
//                    "US", "20:30", "xxoox",
//                    "xxxxo", "oxxxx", null);
//
//            runnersR.add(runner1);
//
//            assertEquals(20, data.runnersShoots());
//        }
//        }
//
//        @org.junit.jupiter.api.Test
//        void finalTime () {
//        }
//
//        @org.junit.jupiter.api.Test
//        void timeInString () {
//        }
//
//        @org.junit.jupiter.api.Test
//        void standing () {
//        }
}

