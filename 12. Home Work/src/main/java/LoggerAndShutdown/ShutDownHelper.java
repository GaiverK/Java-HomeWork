package LoggerAndShutdown;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ShutDownHelper {
    public static void shutdownAndAwaitTermination(ExecutorService pool, long seconds) {
        pool.shutdown();
        try {
            if (!pool.awaitTermination(seconds, TimeUnit.SECONDS)) {
                pool.shutdownNow();
                if (!pool.awaitTermination(seconds, TimeUnit.SECONDS)) {
                    System.err.println("Pool did not terminate");
                }
            }
        } catch (InterruptedException ie) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
