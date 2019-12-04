import okhttp3.Dispatcher;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        AsyncDownloader asyncDownloader = new AsyncDownloader(startTime, null, Config.LoggerOn, "DefaultExecutor");
        asyncDownloader.asyncImageDownload("https://www.bing.com/HPImageArchive.aspx?format=js&idx=0&n=8&mkt=en-US");

        measureCachedThreadPool();
        measureFixedThreadPool();
        measureSingleThreadExecutor();
    }

    static void measureCachedThreadPool(){
        long startTime = System.nanoTime();
        Dispatcher dispatcher = new Dispatcher(Executors.newCachedThreadPool());
        AsyncDownloader asyncDownloader = new AsyncDownloader(startTime, dispatcher,Config.LoggerOn, "CachedThreadPool");
        asyncDownloader.asyncImageDownload("https://www.bing.com/HPImageArchive.aspx?format=js&idx=0&n=8&mkt=en-US");
    }

    static void measureFixedThreadPool(){
        long startTime = System.nanoTime();
        Dispatcher dispatcher = new Dispatcher(Executors.newFixedThreadPool(4));
        AsyncDownloader asyncDownloader = new AsyncDownloader(startTime, dispatcher,Config.LoggerOn, "FixedThreadPool");
        asyncDownloader.asyncImageDownload("https://www.bing.com/HPImageArchive.aspx?format=js&idx=0&n=8&mkt=en-US");
    }

    static void measureSingleThreadExecutor(){
        long startTime = System.nanoTime();
        Dispatcher dispatcher = new Dispatcher(Executors.newSingleThreadExecutor());
        AsyncDownloader asyncDownloader = new AsyncDownloader(startTime, dispatcher,Config.LoggerOn, "SingleThreadExecutor");
        asyncDownloader.asyncImageDownload("https://www.bing.com/HPImageArchive.aspx?format=js&idx=0&n=8&mkt=en-US");
    }

}
