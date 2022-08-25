package solvd.projects.multithread.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,5,1, TimeUnit.MICROSECONDS,new LinkedBlockingQueue<>(2),new Reject());
        for (int i = 0; i < 8; i++) {
            MyCallable myCallable = new MyCallable();
            threadPoolExecutor.submit(myCallable);
        }

        threadPoolExecutor.shutdown();
    }
}
