package LoggerAndShutdown;
import okhttp3.logging.HttpLoggingInterceptor;

public class HttpLogger {
    public static HttpLoggingInterceptor httpLogging(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(message -> System.out.printf("Thread Id - %d\nLog Message - %s\n",
                Thread.currentThread().getId(),
                message));
        logging.level(HttpLoggingInterceptor.Level.BASIC);
        return logging;
    }
}
