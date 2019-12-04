package Plants;

public class Tree extends Plants {
    String name;
    double maxHeight;
    String leavesType;
    final String trunkType = "single";

    public Tree(String family, String classType, String kind, boolean produceOxygen, String name, double maxHeight, String leavesType) {
        super(family, classType, kind, produceOxygen);
        this.name = name;
        this.maxHeight = maxHeight;
        this.leavesType = leavesType;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", classType='" + classType + '\'' +
                ", kingdom='" + kingdom + '\'' +
                ", kind='" + kind + '\'' +
                ", produceOxygen=" + produceOxygen +
                ", maxHeight=" + maxHeight +
                ", leavesType='" + leavesType + '\'' +
                ", trunkType='" + trunkType + '\'' +
                ", growPeriod='" + growPeriod + '\'' +
                '}';
    }
}
