package MyRoom.Design;

public class Door extends  Design {

    boolean hasPlates;
    int doorHinges;

    public Door(String material, String color, String hasPicture, boolean hasPlates, int doorHinges) {
        super(material, color, hasPicture);
        this.hasPlates = hasPlates;
        this.doorHinges = doorHinges;
    }

}
