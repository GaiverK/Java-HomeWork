package Buildings;

public class Cottedge extends Building {
    int minSquare = 100;
    int maxSquare = 500;
    boolean fence;
    boolean plotOfLand;
    double landSquare;
    boolean centralizedHomeSystem;

    public Cottedge(String title, int floors, String baseMaterial, int capacity, double square, boolean fence, boolean plotOfLand, double landSquare, boolean centralizedHomeSystem) {
        super(title, floors, baseMaterial, capacity, square);
        this.fence = fence;
        this.plotOfLand = plotOfLand;
        this.landSquare = landSquare;
        this.centralizedHomeSystem = centralizedHomeSystem;
    }

    private boolean isCottedge(double square){
        return square > minSquare && square < maxSquare;
    }

    @Override
    public String toString() {
        return "Cottedge{" +
                "title='" + title + '\'' +
                ", floors=" + floors +
                ", baseMaterial='" + baseMaterial + '\'' +
                ", square=" + square +
                ", capacity=" + capacity +
                ", minSquare=" + minSquare +
                ", maxSquare=" + maxSquare +
                ", centralizedHomeSystem=" + centralizedHomeSystem +
                '}';
    }
}
