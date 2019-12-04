package Plants;

public class Flower extends Plants{

    String name;
    String color;

    public Flower(String family, String classType, String kind, boolean produceOxygen, String name, String color) {
        super(family, classType, kind, produceOxygen);
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", classType='" + classType + '\'' +
                ", kingdom='" + kingdom + '\'' +
                ", kind='" + kind + '\'' +
                ", produceOxygen=" + produceOxygen +
                ", color='" + color + '\'' +
                ", growPeriod='" + growPeriod + '\'' +
                '}';
    }


}
