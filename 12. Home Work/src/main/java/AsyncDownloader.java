import JsonResponseObjects.bingImages;
import JsonResponseObjects.bingUrl;
import LoggerAndShutdown.HttpLogger;
import LoggerAndShutdown.ShutDownHelper;
import com.google.gson.Gson;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AsyncDownloader {
    private long startTime;
    private Config cnf;
    private OkHttpClient client;
    private int responseCounter;
    private ExecutorService service;
    private HttpLoggingInterceptor logger = HttpLogger.httpLogging();
    private String executorType;

    public AsyncDownloader(long startTime, Dispatcher dispatcher, boolean loggerOn, String executorType){
            OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
            if( loggerOn ) clientBuilder.addInterceptor(logger);
            if( dispatcher != null ) clientBuilder.dispatcher(dispatcher);
            this.client  = clientBuilder.build();
            this.service = client.dispatcher().executorService();
            this.cnf = new Config();
            this.startTime = startTime;
            this.executorType = executorType;
    }


    public void asyncImageDownload(String url){

        client.newCall(makeRequest(url)).enqueue(new Callback() {
            public void onResponse(Call call, Response response) throws IOException {
                try(ResponseBody responseBody = response.body()){
                    // here is answer
                    String responseRes = responseBody.string();
                    Gson jsonWorker = new Gson();
                    bingImages bim = jsonWorker.fromJson(responseRes, bingImages.class);
                    responseCounter = bim.images.size()-1;
                    for( bingUrl single_image : bim.images ){
                        HttpUrl imgUrl = buildImageUrl(single_image.url);
                        String s = imgUrl.toString();
                        String readyImageName = getNameWithExtension(s);
                        saveImage(readyImageName, s);
                    }
                }
            }

            public void onFailure(Call call, IOException e) {
            }

        });
    }

    private Request makeRequest(String url){
        return new Request.Builder()
                .url(url)
                .build();
    }

    private void saveImage(String imgName, String imgUrl){
        client.newCall(makeRequest(imgUrl)).enqueue(new Callback() {
            public void onResponse(Call call, Response response) throws IOException {
                try(ResponseBody responseBody = response.body()){
                    try(BufferedInputStream bis = new BufferedInputStream(responseBody.byteStream()); BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(cnf.getImagesPath(imgName, executorType)))){
                        int ch;
                        byte[] buffer = new byte[4096];
                        while ((ch = bis.read(buffer)) != -1){
                            bos.write(buffer, 0, ch);
                        }
                        if( responseCounter-- == 0 ){
                            // Measure time and shutdown
                            long stopTime = System.nanoTime();
                            System.out.println(executorType + " - Process time: " + (stopTime - startTime) + " ns");
                            ShutDownHelper.shutdownAndAwaitTermination(service, 10);
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
        });
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
