package homeworkCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    int number;
    String name;
    String country;
    Integer time;
    String firstShooting;
    String secondShooting;
    String thirdShooting;
    public Runner(int number, String name, String country, Integer time,
                  String firstShooting, String secondShooting, String thirdShooting) {
        this.number = number;
        this.name = name;
        this.country = country;
        this.time = time;
        this.firstShooting = firstShooting;
        this.secondShooting = secondShooting;
        this.thirdShooting = thirdShooting;
    }

}

