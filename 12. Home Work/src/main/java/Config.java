import java.io.File;
import java.nio.file.Paths;

public class Config {
    private final String imagesPath = "./images/";
    static final boolean LoggerOn = false;

    public String getImagesPath(String fileName, String dispatcherType) {
        createDirs(imagesPath, dispatcherType);
        return Paths.get(imagesPath, dispatcherType, fileName).toAbsolutePath().toString();
    }

    private void createDirs(String firstPart, String... otherParts){
        String result = Paths.get(firstPart, otherParts).toAbsolutePath().toString();
        File file = new File(result);
        if( !file.exists() ) file.mkdirs();
    }
}
