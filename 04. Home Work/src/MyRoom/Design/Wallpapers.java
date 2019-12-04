package MyRoom.Design;

public class Wallpapers extends Design {

    String destination; // Walls, ceil

    public Wallpapers(String material, String color, String hasPicture, String destination) {
        super(material, color, hasPicture);
        this.destination = destination;
    }

}
