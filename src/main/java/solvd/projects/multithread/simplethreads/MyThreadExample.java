package solvd.projects.multithread.simplethreads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThreadExample extends Thread{
    private static final Logger LOGGER = LogManager.getLogger(MyThreadExample.class);
    public void run(){
        for (int i = 0; i <5; i++) {
            LOGGER.info(i);
        }
    }
}
