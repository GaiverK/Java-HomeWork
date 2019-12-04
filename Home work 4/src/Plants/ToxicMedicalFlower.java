package Plants;

public class ToxicMedicalFlower extends ToxicFlower {
    boolean isMedical;
    String medicalDescription;

    public ToxicMedicalFlower(String family, String classType, String kind, boolean produceOxygen, String name, String color, boolean hasPoison, String specialUse, boolean isMedical, String medicalDescription) {
        super(family, classType, kind, produceOxygen, name, color, hasPoison, specialUse);
        this.isMedical = isMedical;
        this.medicalDescription = medicalDescription;
    }

    @Override
    public String toString() {
        return "ToxicMedicalFlower{" +
                "isMedical=" + isMedical +
                ", medicalDescription='" + medicalDescription + '\'' +
                ", hasPoison=" + hasPoison +
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
