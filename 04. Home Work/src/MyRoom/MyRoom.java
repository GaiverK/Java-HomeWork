package MyRoom;

import MyRoom.Art.Art;
import MyRoom.Design.Design;
import MyRoom.Furniture.Furniture;
import MyRoom.Tehnology.Technology;

public class MyRoom {
    int walls;
    Design[] designs;
    Art[] arts;
    Technology[] technologies;
    Furniture[] furnitures;

    public MyRoom(int walls, Design[] designs, Art[] arts, Technology[] technologies, Furniture[] furnitures) {
        this.walls = walls;
        this.designs = designs;
        this.arts = arts;
        this.technologies = technologies;
        this.furnitures = furnitures;
    }
}
