import LoggerAndShutdown.HttpLogger;
import LoggerAndShutdown.ShutDownHelper;
import com.google.gson.Gson;
import JsonResponseObjects.bingImages;
import JsonResponseObjects.bingUrl;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyncDownloader {
    private long startTime;
    private Config cnf;
    private OkHttpClient client;
    private int responseCounter;
    private ExecutorService service;
    private Gson gson = new Gson();
    private HttpLoggingInterceptor logger = HttpLogger.httpLogging();

    public SyncDownloader(long startTime, boolean loggerOn){
        this.startTime = startTime;
        Dispatcher dispatcher = new Dispatcher(Executors.newSingleThreadExecutor());
        if( loggerOn ) this.client  = new OkHttpClient.Builder().addInterceptor(logger).dispatcher(dispatcher).build();
        else this.client  = new OkHttpClient.Builder().dispatcher(dispatcher).build();
        this.service = client.dispatcher().executorService();
        this.cnf = new Config();
    }

    public String syncRequestString(String url){
        try (Response response = client.newCall(makeRequest(url)).execute()) {
           return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public InputStream syncRequestStream(String url, String imgName){
        try (Response response = client.newCall(makeRequest(url)).execute()) {
            try(BufferedInputStream bis = new BufferedInputStream(response.body().byteStream()); BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(cnf.getImagesPath(imgName, "syncDownloader")))){
                int ch;
                byte[] buffer = new byte[4096];
                while ((ch = bis.read(buffer)) != -1){
                    bos.write(buffer, 0, ch);
                }
                if( responseCounter-- == 0 ){
                    // Shutdown and measure time
                    System.out.println("Responses finished");
                    long stopTime = System.nanoTime();
                    System.out.println("Process time: " + (stopTime - startTime) + " ns");
                    ShutDownHelper.shutdownAndAwaitTermination(service, 10);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void downloadImages(String url){
        String jsonRes = syncRequestString(url);
        bingImages imagesObject = gson.fromJson(jsonRes, bingImages.class);
        responseCounter = imagesObject.images.size() - 1;
        for(bingUrl imageUrl: imagesObject.images ){
            HttpUrl imgUrl = buildImageUrl(imageUrl.url);
            String s = imgUrl.toString();
            String readyImageName = getNameWithExtension(s);
            syncRequestStream(s, readyImageName);
        }
    }

    private Request makeRequest(String url){
        return new Request.Builder()
                .url(url)
                .build();
    }

    private HttpUrl buildImageUrl(String url){
        HttpUrl imgUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("bing.com")
                .addPathSegment("th")
                .encodedQuery(url.replaceFirst("\\/th\\?",""))
                .build();
        return imgUrl;
    }

    private String getNameWithExtension(String url){

        Matcher imgName = Pattern.compile("(?=OHR\\.(.+?)_EN)").matcher(url);
        imgName.find();
        String imageName = imgName.group(1);

        imgName = Pattern.compile("(?=rf=.+?\\.(\\w+)&)").matcher(url);
        imgName.find();
        String imageExtenesion = imgName.group(1);

        return imageName + "." + imageExtenesion;
    }
}
