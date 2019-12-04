package Plants;

public class ToxicFlower extends Flower {
    boolean hasPoison;
    String specialUse;

    public ToxicFlower(String family, String classType, String kind, boolean produceOxygen, String name, String color, boolean hasPoison, String specialUse) {
        super(family, classType, kind, produceOxygen, name, color);
        this.hasPoison = hasPoison;
        this.specialUse = specialUse;
    }

    @Override
    public String toString() {
        return "ToxicFlower{" +
                "hasPoison=" + hasPoison +
                ", specialUse='" + specialUse + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", family='" + family + '\'' +
                ", classType='" + classType + '\'' +
                ", kind='" + kind + '\'' +
                ", produceOxygen=" + produceOxygen +
                '}';
    }
}
