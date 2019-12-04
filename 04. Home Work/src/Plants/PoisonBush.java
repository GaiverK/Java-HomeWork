package Plants;

public class PoisonBush extends Bush {
    boolean isEdible;
    boolean isToxic;
    boolean isDecorate;

    public PoisonBush(String family, String classType, String kind, boolean produceOxygen, String name, boolean isEdible, boolean isToxic, boolean isDecorate) {
        super(family, classType, kind, produceOxygen, name);
        this.isEdible = isEdible;
        this.isToxic = isToxic;
        this.isDecorate = isDecorate;
    }

    @Override
    public String toString() {
        return "PoisonBush{" +
                "isEdible=" + isEdible +
                ", isToxic=" + isToxic +
                ", isDecorate=" + isDecorate +
                ", trunkType='" + trunkType + '\'' +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", classType='" + classType + '\'' +
                ", kind='" + kind + '\'' +
                ", produceOxygen=" + produceOxygen +
                '}';
    }
}
