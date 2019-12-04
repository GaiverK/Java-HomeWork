package Buildings;

public class Building {
    String title;
    int floors;
    String baseMaterial;
    int capacity;
    double square;

    public Building(String title, int floors, String baseMaterial, int capacity, double square) {
        this.title = title;
        this.floors = floors;
        this.baseMaterial = baseMaterial;
        this.capacity = capacity;
        this.square = square;
    }

    @Override
    public String toString() {
        return "Building{" +
                "title='" + title + '\'' +
                ", floors=" + floors +
                ", baseMaterial='" + baseMaterial + '\'' +
                ", capacity=" + capacity +
                ", square=" + square +
                '}';
    }
}
