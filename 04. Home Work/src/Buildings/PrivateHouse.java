package Buildings;

public class PrivateHouse extends Building {
    boolean fence;
    boolean plotOfLand;
    double landSquare;
    double maxSquare = 100;

    public PrivateHouse(String title, int floors, String baseMaterial, int capacity, double square, boolean fence, boolean plotOfLand, double landSquare) {
        super(title, floors, baseMaterial, capacity, square);
        this.fence = fence;
        this.plotOfLand = plotOfLand;
        this.landSquare = landSquare;
    }

    @Override
    public String toString() {
        return "PrivateHouse{" +
                "title='" + title + '\'' +
                ", floors=" + floors +
                ", baseMaterial='" + baseMaterial + '\'' +
                ", square=" + square +
                ", capacity=" + capacity +
                ", plotOfLand=" + plotOfLand +
                ", landSquare=" + landSquare +
                ", maxSquare=" + maxSquare +
                ", fence=" + fence +
                '}';
    }
}
