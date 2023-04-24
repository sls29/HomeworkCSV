package homeworkCSV;

import java.util.Comparator;

    public class TimeComparator implements java.util.Comparator<Runner> {
        public int compare(Runner runner1, Runner runner2) {
            return (runner1.time).compareTo(runner2.time);
        }
    }