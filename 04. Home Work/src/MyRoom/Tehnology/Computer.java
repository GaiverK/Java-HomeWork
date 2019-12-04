package MyRoom.Tehnology;

public class Computer extends Technology {
    int hddSpace;
    int coolersCount;
    String videoCard;

    public Computer(String name, int neededVoltage, int hddSpace, int coolersCount, String videoCard) {
        super(name, neededVoltage);
        this.hddSpace = hddSpace;
        this.coolersCount = coolersCount;
        this.videoCard = videoCard;
    }

}
