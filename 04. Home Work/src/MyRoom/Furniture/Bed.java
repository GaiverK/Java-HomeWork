package MyRoom.Furniture;

public class Bed extends Furniture {
    boolean mattress;
    int pillows;

    public Bed(String name, int legs, String color, String material, boolean mattress, int pillows) {
        super(name, legs, color, material);
        this.mattress = mattress;
        this.pillows = pillows;
    }
}
