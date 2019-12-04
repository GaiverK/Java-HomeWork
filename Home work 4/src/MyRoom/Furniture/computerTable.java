package MyRoom.Furniture;

public class computerTable extends Furniture {
    boolean extendableShelf;

    public computerTable(String name, int legs, String color, String material, boolean extendableShelf) {
        super(name, legs, color, material);
        this.extendableShelf = extendableShelf;
    }

}
