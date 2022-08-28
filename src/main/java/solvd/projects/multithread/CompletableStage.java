package solvd.projects.multithread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.multithread.thread.MyCallable;

import java.util.concurrent.*;


public class CompletableStage{
    private static final Logger LOGGER = LogManager.getLogger(CompletableStage.class);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
     ExecutorService executor = Executors.newFixedThreadPool(5);
        MyCallable myCallable =new MyCallable();

        for (int i = 0; i <7; i++) {
            CompletableFuture<Void> stage = CompletableFuture.runAsync(()->myCallable.call(),executor);
            while (!stage.isDone()){
                Thread.sleep(1000);
                LOGGER.info("....Working.....");
            }
        }

        executor.shutdown();
        LOGGER.info("Over!!");
    }
}

