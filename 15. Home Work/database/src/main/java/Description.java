import java.util.ArrayList;
import java.util.List;

public class Description {
    private List<String> descriptions = new ArrayList<>();

    public List<String> getDescriptions(){
        return this.descriptions;
    }

    public void addDescription(String desc){
        this.descriptions.add(desc);
    }

    public void removeDescription(String desc){
        this.descriptions.remove(desc);
    }

    public void reset(){
        this.descriptions = new ArrayList<>();
    }

    static void printDescriptions(List<String> descriptions){
        descriptions.stream()
                .forEach(System.out::print);
    }
}
