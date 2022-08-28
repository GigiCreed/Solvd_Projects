package solvd.projects.multithread.ifuture;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.multithread.thread.MyCallable;

import java.util.concurrent.*;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
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
