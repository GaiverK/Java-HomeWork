package MyRoom.Tehnology;

public class Fan extends Technology {
    int speedCount;
    boolean rotate;


    public Fan(String name, int neededVoltage, int speedCount, boolean rotate) {
        super(name, neededVoltage);
        this.speedCount = speedCount;
        this.rotate = rotate;
    }

}
