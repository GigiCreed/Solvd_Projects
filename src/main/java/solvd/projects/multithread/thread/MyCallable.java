package solvd.projects.multithread.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;
/*
////
This is Thread witch one we are using in IFuture,ThreadPool tasks
////
 */

public class MyCallable implements Callable<Long> {
    private static final Logger LOGGER = LogManager.getLogger(MyCallable.class);
    @Override
    public Long call() {
        LOGGER.info("Thread is Working :" +Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.error("Error !!!");
        }
        LOGGER.info("Thread Finished !!! :"+Thread.currentThread().getId());
        return  Thread.currentThread().getId();
    }
}
