package MyRoom.Design;

public class Linoleum extends Design {

    String basis; // felt or other

    public Linoleum(String material, String color, String hasPicture, String basis) {
        super(material, color, hasPicture);
        this.basis = basis;
    }

}
