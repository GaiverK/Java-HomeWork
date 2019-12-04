package Buildings;

public class ApartmentHouse extends Building {
    boolean lift;
    boolean frontDoor;
    int frontDoorCount;

    public ApartmentHouse(String title, int floors, String baseMaterial, int capacity, double square, boolean lift, boolean frontDoor, int frontDoorCount) {
        super(title, floors, baseMaterial, capacity, square);
        this.lift = lift;
        this.frontDoor = frontDoor;
        this.frontDoorCount = frontDoorCount;
    }

    @Override
    public String toString() {
        return "ApartmentHouse{" +
                "title='" + title + '\'' +
                ", floors=" + floors +
                ", baseMaterial='" + baseMaterial + '\'' +
                ", square=" + square +
                ", capacity=" + capacity +
                ", frontDoor=" + frontDoor +
                ", frontDoorCount=" + frontDoorCount +
                ", lift=" + lift +
                '}';
    }
}
