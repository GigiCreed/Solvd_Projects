package solvd.projects.multithread.simplethreads;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThreadExample2 implements Runnable{
    private static final Logger LOGGER = LogManager.getLogger(MyThreadExample2.class);
    @Override
    public void run() {
        for (int i = 0; i <5; i++) {
            LOGGER.info(i);
        }
    }
}
