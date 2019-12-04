package Plants;

public class FruitTree extends Tree {

    boolean hasFruit;
    String fruitName;

    public FruitTree(String family, String classType, String kind, boolean produceOxygen, String name, double maxHeight, String leavesType, boolean hasFruit, String fruitName) {
        super(family, classType, kind, produceOxygen, name, maxHeight, leavesType);
        this.hasFruit = hasFruit;
        this.fruitName = fruitName;
    }

    @Override
    public String toString() {
        return "FruitTree{" +
                "hasFruit=" + hasFruit +
                ", fruitName='" + fruitName + '\'' +
                ", name='" + name + '\'' +
                ", maxHeight=" + maxHeight +
                ", leavesType='" + leavesType + '\'' +
                ", trunkType='" + trunkType + '\'' +
                ", family='" + family + '\'' +
                ", classType='" + classType + '\'' +
                ", kind='" + kind + '\'' +
                ", produceOxygen=" + produceOxygen +
                '}';
    }
}
