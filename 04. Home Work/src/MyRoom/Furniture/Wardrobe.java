package MyRoom.Furniture;

public class Wardrobe extends Furniture {
    int sectionCount;
    String doorsType;
    boolean hasMirror;

    public Wardrobe(String name, int legs, String color, String material, int sectionCount, String doorsType, boolean hasMirror) {
        super(name, legs, color, material);
        this.sectionCount = sectionCount;
        this.doorsType = doorsType;
        this.hasMirror = hasMirror;
    }
}
