package MyRoom.Furniture;

public class computerChair extends Furniture {
    String leatherType;
    boolean armrest;

    public computerChair(String name, int legs, String color, String material, String leatherType, boolean armrest) {
        super(name, legs, color, material);
        this.leatherType = leatherType;
        this.armrest = armrest;
    }
}
