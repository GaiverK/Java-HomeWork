package Plants;

public class Bush extends Plants {
    final String trunkType = "multiple";
    String name;

    public Bush(String family, String classType, String kind, boolean produceOxygen, String name) {
        super(family, classType, kind, produceOxygen);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bush{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", classType='" + classType + '\'' +
                ", kingdom='" + kingdom + '\'' +
                ", kind='" + kind + '\'' +
                ", produceOxygen=" + produceOxygen +
                ", trunkType='" + trunkType + '\'' +
                ", growPeriod='" + growPeriod + '\'' +
                '}';
    }


}
