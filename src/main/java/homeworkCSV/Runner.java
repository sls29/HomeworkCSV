package homeworkCSV;


public class Runner {
    Integer number;
    Object name;
    Object country;
    Object time;
    Object firstShooting;
    Object secondShooting;
    Object thirdShooting;
    Integer totalTime;
    public Runner(Integer number, Object name, Object country, Object time,
                  Object firstShooting, Object secondShooting, Object thirdShooting, Integer totalTime) {
        this.number = number;
        this.name = name;
        this.country = country;
        this.time = time;
        this.firstShooting = firstShooting;
        this.secondShooting = secondShooting;
        this.thirdShooting = thirdShooting;
        this.totalTime = totalTime;
    }

    
    public String toString(){
        System.out.println(number);
        System.out.println(name);
        System.out.println(firstShooting);
    return null;
    
    }
}

