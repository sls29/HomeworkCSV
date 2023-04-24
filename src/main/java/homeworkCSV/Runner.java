package homeworkCSV;


public class Runner {
    Integer number;
    String name;
    String country;
    String time;
    String firstShooting;
    String secondShooting;
    String thirdShooting;


    public Runner(Integer number, String name, String country, String time,
                  String firstShooting, String secondShooting, String thirdShooting) {
        this.number = number;
        this.name = name;
        this.country = country;
        this.time = time;
        this.firstShooting = firstShooting;
        this.secondShooting = secondShooting;
        this.thirdShooting = thirdShooting;
    }

    public String toString(){
    return number + "," + name + ", " + time;
    
    }
}

