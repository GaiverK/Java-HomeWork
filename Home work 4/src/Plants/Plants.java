package Plants;

class Plants {
    static final String kingdom = "Plants";
    String family;
    String classType;
    String kind;
    static final String growPeriod = "always";
    boolean produceOxygen;

    public Plants(String family, String classType, String kind, boolean produceOxygen) {
        this.family = family;
        this.classType = classType;
        this.kind = kind;
        this.produceOxygen = produceOxygen;
    }

    @Override
    public String toString() {
        return "Plants{" +
                "family='" + family + '\'' +
                ", classType='" + classType + '\'' +
                ", kind='" + kind + '\'' +
                ", produceOxygen=" + produceOxygen +
                '}';
    }
}
