public class EnterPoint2 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        SyncDownloader syncDownloader = new SyncDownloader(startTime, Config.LoggerOn);
        syncDownloader.downloadImages("https://www.bing.com/HPImageArchive.aspx?format=js&idx=0&n=8&mkt=en-US");
    }
}
