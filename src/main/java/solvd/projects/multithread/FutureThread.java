package solvd.projects.multithread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.multithread.thread.MyCallable;

import java.util.concurrent.*;

public class FutureThread {
    private static final Logger LOGGER = LogManager.getLogger(FutureThread.class);
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i <7; i++) {
            Future<Long> future = executorService.submit(new MyCallable());
            while (!future.isDone()){
                Thread.sleep(1000);
                LOGGER.info("....Working.....");
            }
        }

        executorService.shutdown();
        LOGGER.info("OVER!!!");
    }
}
