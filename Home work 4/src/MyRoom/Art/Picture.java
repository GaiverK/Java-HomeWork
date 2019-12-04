package MyRoom.Art;

public class Picture extends Art {

    public String author;

    public Picture(String name, int width, int height, boolean onTheWall, String description, String anAuthor) {
        super(name, width, height, onTheWall, description);
        this.author = anAuthor;
    }

}
